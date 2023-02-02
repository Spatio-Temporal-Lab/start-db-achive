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
import org.urbcomp.cupid.db.algorithm.staypointdetection.StayGPSPointList;
import org.urbcomp.cupid.db.algorithm.staypointdetection.StayPointDetection;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.lang.reflect.Method;
import java.util.List;

public class StayPointDetect {
    public static Method STAYPOINTDETECTION_TABLE_METHOD = Types.lookupMethod(
        StayPointDetect.class,
        "st_traj_stayPointDetection",
        StayGPSPointList.class,
        Trajectory.class,
        Double.class
    );

    public ScannableTable st_traj_stayPointDetection(Trajectory trajectory, Double d, Double t) {
        StayPointDetection stayPointDetection = new StayPointDetection();
        List<StayGPSPointList> limit = stayPointDetection.detection(trajectory, d, t);
        return new ScannableTable() {
            @Override
            public Enumerable<Object[]> scan(DataContext dataContext) {
                return new AbstractEnumerable<Object[]>() {
                    @Override
                    public Enumerator<Object[]> enumerator() {
                        return new Enumerator<Object[]>() {
                            private int current = 0;
                            private int prev = 1;

                            @Override
                            public Object[] current() {
                                return new Object[] { limit.get(current) };
                            }

                            @Override
                            public boolean moveNext() {
                                final int next = current + prev;
                                if (next >= limit.size()) return false;
                                current = next;
                                return true;
                            }

                            @Override
                            public void reset() {
                                prev = 0;
                                current = 1;
                            }

                            @Override
                            public void close() {

                            }
                        };
                    }
                };
            }

            @Override
            public RelDataType getRowType(RelDataTypeFactory relDataTypeFactory) {
                return relDataTypeFactory.builder().add("N", SqlTypeName.BIGINT).build();
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
                return true;
            }
        };
    }

}
