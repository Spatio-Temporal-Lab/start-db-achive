package org.urbcomp.start.db.stream.template;

import org.apache.flink.connector.jdbc.catalog.AbstractJdbcCatalog;
import org.apache.flink.connector.jdbc.catalog.JdbcCatalogUtils;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * check: https://blog.csdn.net/qq_41463207/article/details/115677404
 *
 * @author jimo
 **/
public class DDL {

    public static void main(String[] args) throws Exception {
        // parse args


        // init table environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);

        // init metadata

        final String catalogName = "default";
        final String dbName = "meta_data";
//        final String dbName = "db_stream";
        final String username = "root";
        final String pwd = "start_db";
        final String baseUrl = "jdbc:mysql://localhost:3306";
        final AbstractJdbcCatalog catalog = JdbcCatalogUtils.createCatalog(
                catalogName, dbName, username, pwd, baseUrl
        );
        tableEnv.registerCatalog(catalogName, catalog);
        tableEnv.useCatalog(catalog.getName());
        tableEnv.useDatabase(dbName);

        // execute stream sql
//        tableEnv.executeSql("CREATE TABLE MyUserTable (\n" +
//                "  id BIGINT,\n" +
//                "  name STRING,\n" +
//                "  age INT,\n" +
//                "  status BOOLEAN,\n" +
//                "  PRIMARY KEY (id) NOT ENFORCED\n" +
//                ") WITH (\n" +
//                "   'connector' = 'jdbc',\n" +
//                "   'url' = 'jdbc:mysql://localhost:3306/mydatabase',\n" +
//                "   'table-name' = 'users'\n" +
//                ")");
//
//        env.execute();

        final String[] tables = tableEnv.listTables();
        for (String table : tables) {
            System.out.println("table:" + table);
        }
    }
}
