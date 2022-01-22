package task2.actions.log;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

@AllArgsConstructor
public class LogCommand implements Command {
    private final Object ability;
    private final Vector vector = new Vector();

    @Override
    public void execute() {
        if (ability instanceof Loggable loggable) {
            loggable.getLog();
        } else {
            throw new UnsupportedCommandException("Loggable is not supported");
        }
    }
}
