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
import org.urbcomp.cupid.db.algorithm.staypointdetect.StayGPSPointList;
import org.urbcomp.cupid.db.algorithm.staypointdetect.StayPointDetect;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.lang.reflect.Method;
import java.util.List;

public class StayPoint {
    public static Method STAYPOINTDETECTION_TABLE_METHOD = Types.lookupMethod(
        StayPoint.class,
        "st_traj_stayPointDetect",
        Trajectory.class,
        double.class,
        double.class
    );

    public ScannableTable st_traj_stayPointDetect(Trajectory trajectory, double d, double t) {
        return new ScannableTable() {
            @Override
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
                return typeFactory.builder()
                    .add("startTime", SqlTypeName.TIMESTAMP)
                    .add("endTime", SqlTypeName.TIMESTAMP)
                    .add("gpsPoints", SqlTypeName.MULTIPOINT)
                    .build();
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

            List<StayGPSPointList> result;
            /**
             * 持有变量，防止多次进行json的解析操作
             */
            StayPointDetect detector;

            public Enumerable<Object[]> scan(DataContext root) {
                return new AbstractEnumerable<Object[]>() {
                    public Enumerator<Object[]> enumerator() {
                        return new Enumerator<Object[]>() {
                            private int count = 0;
                            private StayGPSPointList current;

                            /**
                             * current result
                             *
                             * @return current
                             */
                            public Object[] current() {
                                return new Object[] {
                                    current.getStarTime().getTime(),
                                    current.getEndTime().getTime(),
                                    current.getMultiPoint() };
                            }

                            /**
                             * has Next
                             *
                             * @return true or false
                             */
                            public boolean moveNext() {
                                try {
                                    if (detector == null) {
                                        detector = new StayPointDetect();
                                    }
                                    if (null == result) {
                                        result = detector.detect(trajectory, d, t);
                                    }
                                    if (count < result.size()) {
                                        current = result.get(count);
                                        count += 1;
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return false;
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
