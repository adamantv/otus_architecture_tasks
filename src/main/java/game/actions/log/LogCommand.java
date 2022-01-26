package game.actions.log;

import game.actions.Command;
import lombok.AllArgsConstructor;

/**
 * The command writes information about the thrown exception to the log.
 */
@AllArgsConstructor
public class LogCommand implements Command {
    private final String message;

    @Override
    public void execute() {
        System.out.println(message);
    }
}
