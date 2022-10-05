/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.parser;

/**
 * @author stan
 * @date 2022/10/5 10:29
 */
public class Constant {

    // specify name
    public static final String HBASE_CATALOG = "hbase.catalog";
    public static final String HBASE_ZK = "hbase.zookeepers";
    public static final String SPARK_SERIALIZER = "spark.serializer";
    public static final String SPARK_KRYO = "spark.kryo.registrator";

    // custom name
    public static final String CATALOG = "root.default";
    public static final String ZK = "localhost:2181";
    public static final String SERIALIZER = "org.apache.spark.serializer.KryoSerializer";

}
