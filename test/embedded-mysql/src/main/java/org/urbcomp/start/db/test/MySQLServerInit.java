package org.urbcomp.start.db.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

/**
 * init mysql schema and data
 *
 * @author jimo
 * @date 2022/5/11 7:31
 **/
public class MySQLServerInit {

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        String jdbcUrl = "jdbc:mysql://mysql:3306/meta_data?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT+8";
        String user = "start_db";
        String password = "start_db";
        final String sqlTxt = Files.readAllLines(Paths.get("test/embedded-mysql/src/main/resources/metadata/ddl.sql"))
                .stream().filter(line -> !line.trim().startsWith("#") && !line.trim().startsWith("--")).collect(Collectors.joining());
        final String[] sqlList = sqlTxt.split(";");
        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            for (String sql : sqlList) {
                final Statement stat = conn.createStatement();
                stat.execute(sql.trim());
            }
        }
    }
}
