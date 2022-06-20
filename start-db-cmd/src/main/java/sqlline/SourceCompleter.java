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
