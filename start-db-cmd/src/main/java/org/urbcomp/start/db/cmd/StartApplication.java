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

package org.urbcomp.start.db.cmd;

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
