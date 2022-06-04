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

package org.urbcomp.start.db.jdbc;

import org.apache.calcite.avatica.DriverVersion;

/**
 * custom JDBC driver
 *
 * @author jimo
 **/
public class Driver extends org.apache.calcite.avatica.remote.Driver {

    static {
        new Driver().register();
    }

    @Override
    protected String getConnectStringPrefix() {
        return "jdbc:start-db:";
    }

    @Override
    protected DriverVersion createDriverVersion() {
        return DriverVersion.load(
            org.apache.calcite.avatica.remote.Driver.class,
            "org-apache-calcite-jdbc.properties",
            "Start-DB Remote JDBC Driver",
            "1.0.0-SNAPSHOT",
            "MYSQL",
            "5.1.47"
            // "START-DB",
            // "1.0.0-SNAPSHOT"
        );
    }
}
