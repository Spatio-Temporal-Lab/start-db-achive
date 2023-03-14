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
package org.urbcomp.cupid.db.cmd;

import sqlline.Application;
import sqlline.CommandHandler;
import sqlline.ReflectiveCommandHandler;
import sqlline.SqlLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * rewrite Application to add more command
 *
 * @author jimo
 **/
public class StartApplication extends Application {

    @Override
    public Collection<CommandHandler> getCommandHandlers(SqlLine sqlLine) {
        final Collection<CommandHandler> commandHandlers = super.getCommandHandlers(sqlLine);
        List<CommandHandler> handlers = new ArrayList<>(commandHandlers);
        handlers.add(new ReflectiveCommandHandler(sqlLine, Collections.emptyList(), "source"));
        return handlers;
    }
}
