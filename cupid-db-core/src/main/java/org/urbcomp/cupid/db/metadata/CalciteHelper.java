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

package org.urbcomp.cupid.db.metadata;

import org.apache.calcite.config.CalciteConnectionProperty;
import org.urbcomp.cupid.db.geomesa.GeomesaSchemaFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * about model.json
 *
 * @author jimo
 **/
public class CalciteHelper {

    public static String modelJson() {
        return "{\n"
            + "  \"version\": \"1.0\",\n"
            + "  \"defaultSchema\": \"START_DB\",\n"
            + "  \"schemas\": [\n"
            + "    {\n"
            + "      \"name\": \"START_DB\",\n"
            + "      \"type\": \"custom\",\n"
            + "      \"factory\": \""
            + GeomesaSchemaFactory.class.getCanonicalName().replace("$", "")
            + "\"\n"
            + "    }\n"
            + "  ]\n"
            + "}\n";
    }

    /**
     * outside should close the connection
     */
    public static Connection createConnection() throws SQLException {
        final Properties p = new Properties();
        p.put(CalciteConnectionProperty.CASE_SENSITIVE.camelName(), "false");
        p.put(CalciteConnectionProperty.MODEL.camelName(), "inline:" + modelJson());
        p.put(CalciteConnectionProperty.TIME_ZONE.camelName(), "UTC");
        return DriverManager.getConnection("jdbc:calcite:fun=spatial", p);
    }
}
