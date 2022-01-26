package game.actions.log;

import game.actions.Command;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * The command writes information about the thrown exception to the log.
 */
@AllArgsConstructor
@ToString
public class LogCommand implements Command {
    private final Exception exception;
    private final Command cause;

    @Override
    public void execute() {
        System.out.println(this.toString());
    }
}
