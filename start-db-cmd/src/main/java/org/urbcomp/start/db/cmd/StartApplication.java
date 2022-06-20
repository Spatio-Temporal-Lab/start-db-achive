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
