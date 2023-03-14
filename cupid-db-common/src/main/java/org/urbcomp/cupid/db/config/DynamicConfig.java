/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.config;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * global dynamic config
 *
 * @author jimo
 **/
public class DynamicConfig {

    public static final String DB_SPARK_JARS = "livy.spark.db.jars";

    private final static Properties properties = new Properties();

    public static void updateProperties(String key, String value) {
        properties.put(key, value);
    }

    public static String getLivyUrl() {
        return properties.getProperty("livy.url", "http://localhost:8998");
    }

    public static int getSparkDriverCores() {
        return Integer.parseInt(properties.getProperty("livy.spark.driverCores", "1"));
    }

    public static String getSparkDriverMemory() {
        return properties.getProperty("livy.spark.driverMemory", "1G");
    }

    public static int getSparkNumExecutors() {
        return Integer.parseInt(properties.getProperty("livy.spark.numExecutors", "1"));
    }

    public static int getSparkExecutorCores() {
        return Integer.parseInt(properties.getProperty("livy.spark.executorCores", "1"));
    }

    public static String getSparkExecutorMemory() {
        return properties.getProperty("livy.spark.executorMemory", "1G");
    }

    /**
     * 这个jar包要放在Livy Server能够访问的地方，如果是本地，就要放在Livy Server机器上
     */
    public static List<String> getDbSparkJars() {
        final String jar = properties.getProperty(DB_SPARK_JARS, "/opt/cupid-db-spark-shaded.jar");
        final String[] jars = jar.split(",");
        return Arrays.asList(jars);
    }

    public static String getHdfsPath() {
        return properties.getProperty("hdfs.path", "hdfs://localhost:9000");
    }

    public static String getHdfsDataSplitter() {
        return properties.getProperty("hdfs.data.splitter", "\001");
    }

    public static String getHadoopUser() {
        return properties.getProperty("hadoop.user", "hadoop");
    }

    public static String getSparkHdfsResultPath() {
        return getHdfsPath() + properties.getProperty("hdfs.spark.res-dir", "/result/");
    }

    public static String getResultSchemaName(String sqlId) {
        return sqlId + "_schema";
    }

    public static String getResultDataName(String sqlId) {
        return sqlId + "_data";
    }
}
