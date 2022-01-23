package game.actions.log;

import game.actions.Command;
import game.exception.UnsupportedCommandException;
import lombok.AllArgsConstructor;

/**
 * The command writes information about the thrown exception to the log.
 */
@AllArgsConstructor
public class LogCommand implements Command {
    private final Object ability;

    @Override
    public void execute() {
        if (ability instanceof Loggable loggable) {
            String log = loggable.getLog();
            System.out.println(log);
        } else {
            throw new UnsupportedCommandException("Loggable is not supported");
        }
    }
}
