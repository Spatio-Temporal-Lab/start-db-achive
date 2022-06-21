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

package sqlline;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

/**
 * source completer
 *
 * @author jimo
 **/
public class SourceCompleter implements Completer {

    private final SqlLine sqlLine;

    public SourceCompleter(SqlLine sqlLine) {
        this.sqlLine = sqlLine;
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        if (sqlLine.getDatabaseConnection() == null) {
            return;
        }
        // TODO

        new StringsCompleter("hehe", "10").complete(reader, line, candidates);
    }
}
