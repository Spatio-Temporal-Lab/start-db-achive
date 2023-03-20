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
package org.urbcomp.cupid.db.server;

import org.apache.calcite.avatica.server.AvaticaJsonHandler;
import org.apache.calcite.avatica.server.HttpServer;
import org.apache.calcite.jdbc.DbMetaFactory;
import org.urbcomp.cupid.db.server.daemon.DaemonManager;

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
