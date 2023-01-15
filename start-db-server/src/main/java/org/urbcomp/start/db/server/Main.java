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

package org.urbcomp.start.db.server;

import org.apache.calcite.avatica.server.AvaticaJsonHandler;
import org.apache.calcite.avatica.server.HttpServer;
import org.apache.calcite.jdbc.DbMetaFactory;
import org.urbcomp.start.db.server.daemon.DaemonManager;

/**
 * @author jimo
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        String[] params = { DbMetaFactory.class.getCanonicalName() };
        final HttpServer server = org.apache.calcite.avatica.server.Main.start(
            params,
            8000,
            AvaticaJsonHandler::new
        );
        DaemonManager.start();
        server.join();
    }
}
