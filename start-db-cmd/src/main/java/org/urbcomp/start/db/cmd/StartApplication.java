package org.urbcomp.start.db.cmd;

import sqlline.*;

import java.util.ArrayList;
import java.util.Collection;
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
        handlers.add(new ReflectiveCommandHandler(sqlLine, new SourceCompleter(sqlLine), "source"));
        return handlers;
    }
}
