package org.apache.calcite.jdbc;

import lombok.SneakyThrows;
import org.apache.calcite.avatica.Meta;

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
import java.net.URL;
import java.net.URLDecoder;
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

    @SneakyThrows
    @Override
    public Meta create(List<String> list) {
        final Properties p = new Properties();
        final URL url = this.getClass().getResource("/model.json");
        p.put("model", URLDecoder.decode(url.toString(), "UTF-8").replace("file:", ""));
        final Connection connection = DriverManager.getConnection("jdbc:calcite:", p);
        return new CalciteMetaImpl((CalciteConnectionImpl) connection);
    }
}
