/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.cupid.db.udtf;

import org.apache.calcite.DataContext;
import org.apache.calcite.config.CalciteConnectionConfig;
import org.apache.calcite.linq4j.AbstractEnumerable;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.linq4j.tree.Types;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.ScannableTable;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.Statistic;
import org.apache.calcite.schema.Statistics;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.type.SqlTypeName;
import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.algorithm.clustering.AbstractClustering;
import org.urbcomp.cupid.db.model.point.SpatialPoint;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

public class DBSCANClustering {
    public static Method DBSCAN_CLUSTERING_TABLE_METHOD = Types.lookupMethod(
        DBSCANClustering.class,
        "st_dbscan_clustering",
        List.class,
        BigDecimal.class,
        int.class
    );

    public ScannableTable st_dbscan_clustering(
        List<SpatialPoint> pointList,
        BigDecimal distanceInM,
        int minPoints
    ) {
        return new ScannableTable() {
            List<MultiPoint> clusters = null;

            @Override
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
                return typeFactory.builder().add("cluster", SqlTypeName.MULTIPOINT).build();
            }

            @Override
            public Statistic getStatistic() {
                return Statistics.UNKNOWN;
            }

            @Override
            public Schema.TableType getJdbcTableType() {
                return Schema.TableType.TABLE;
            }

            @Override
            public boolean isRolledUp(String s) {
                return false;
            }

            @Override
            public boolean rolledUpColumnValidInsideAgg(
                String s,
                SqlCall sqlCall,
                SqlNode sqlNode,
                CalciteConnectionConfig calciteConnectionConfig
            ) {
                return false;
            }

            public Enumerable<Object[]> scan(DataContext root) {
                return new AbstractEnumerable<Object[]>() {
                    private int count = 0;
                    private MultiPoint current = null;

                    public Enumerator<Object[]> enumerator() {
                        return new Enumerator<Object[]>() {
                            /**
                             * current result
                             *
                             * @return current
                             */
                            public Object[] current() {
                                return new Object[] {
                                    current,
                                    current.getCentroid(),
                                    current.getBoundary() };
                            }

                            /**
                             * has Next
                             *
                             * @return true or false
                             */
                            public boolean moveNext() {
                                if (clusters == null) {
                                    AbstractClustering method =
                                        new org.urbcomp.cupid.db.algorithm.clustering.DBSCANClustering(
                                            pointList,
                                            distanceInM.doubleValue(),
                                            minPoints
                                        );
                                    clusters = method.cluster();
                                }
                                if (count < clusters.size()) {
                                    current = clusters.get(count);
                                    count++;
                                    return true;
                                } else {
                                    return false;
                                }
                            }

                            /**
                             * reset
                             */
                            public void reset() {
                                count = 0;
                            }

                            /**
                             * close
                             */
                            public void close() {}
                        };
                    }
                };
            }
        };

    }
}
