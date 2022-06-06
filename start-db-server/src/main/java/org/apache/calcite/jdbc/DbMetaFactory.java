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

package org.apache.calcite.jdbc;

import lombok.SneakyThrows;
import org.apache.calcite.avatica.Meta;
import org.apache.calcite.config.CalciteConnectionProperty;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.Table;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

/**
 * For access {@link CalciteMetaImpl}
 *
 * @author jimo
 **/
public class DbMetaFactory implements Meta.Factory {

    private static SchemaPlus ROOT_SCHEMA;

    @SneakyThrows
    @Override
    public Meta create(List<String> list) {
        final URL resource = this.getClass().getResource("/model.json");
        final String url = URLDecoder.decode(resource.toString(), StandardCharsets.UTF_8.name());
        final Properties p = new Properties();
        p.put(CalciteConnectionProperty.CASE_SENSITIVE.camelName(), "false");
        p.put(CalciteConnectionProperty.MODEL.camelName(), url.replace("file:", ""));
        final Connection connection = DriverManager.getConnection("jdbc:calcite:fun=spatial", p);
        final CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
        ROOT_SCHEMA = calciteConnection.getRootSchema();
        // init UDF here
        return new CalciteMetaImpl((CalciteConnectionImpl) connection);
    }

    public static void addTable(String name, Table table) {
        ROOT_SCHEMA.add(name, table);
    }
}
