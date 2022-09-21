package org.urbcomp.start.db.stream.template;

import org.apache.flink.connector.jdbc.catalog.AbstractJdbcCatalog;
import org.apache.flink.connector.jdbc.catalog.JdbcCatalogUtils;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class Main {

    public static void main(String[] args) throws Exception {
        // parse args


        // init table environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);

        // init metadata

        final String catalogName = "start";
        final String dbName = "db_stream";
        final String username = "root";
        final String pwd = "123456";
        final String baseUrl = "jdbc:mysql://localhost:3306";
        final AbstractJdbcCatalog catalog = JdbcCatalogUtils.createCatalog(
                catalogName, dbName, username, pwd, baseUrl
        );
        tableEnv.registerCatalog("start_db", catalog);
        tableEnv.useCatalog(catalog.getName());

        // execute stream sql

        final String[] tables = tableEnv.listTables();
        for (String table : tables) {
            System.out.println("table:" + table);
        }

        // submit job
        env.execute();
    }
}
