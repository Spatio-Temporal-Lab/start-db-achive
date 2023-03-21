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
package org.urbcomp.cupid.db.metadata;

import org.apache.calcite.config.CalciteConnectionProperty;
import org.urbcomp.cupid.db.geomesa.GeomesaSchemaFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

/**
 * about model.json
 *
 * @author jimo
 **/
public class CalciteHelper {

    public static String modelJson() {
        return "{\n"
            + "  \"version\": \"1.0\",\n"
            + "  \"defaultSchema\": \"CUPID_DB\",\n"
            + "  \"schemas\": [\n"
            + "    {\n"
            + "      \"name\": \"CUPID_DB\",\n"
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
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return DriverManager.getConnection("jdbc:calcite:fun=spatial", p);
    }
}
