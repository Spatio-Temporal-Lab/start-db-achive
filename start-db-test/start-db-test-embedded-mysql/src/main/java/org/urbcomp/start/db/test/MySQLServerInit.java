/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

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
        String jdbcUrl =
            "jdbc:mysql://localhost:3306/meta_data?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        String user = "start_db";
        String password = "start_db";
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String sqlTxt = Files.readAllLines(
            Paths.get("start-db-core/src/main/resources/metadata/ddl.sql")
        )
            .stream()
            .filter(line -> !line.trim().startsWith("#") && !line.trim().startsWith("--"))
            .collect(Collectors.joining());
        final String[] sqlList = sqlTxt.split(";");
        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            for (String sql : sqlList) {
                final Statement stat = conn.createStatement();
                stat.execute(sql.trim());
            }
        }
    }
}
