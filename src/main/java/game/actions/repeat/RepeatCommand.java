package game.actions.repeat;

import game.actions.Command;
import game.actions.Second;
import game.exception.UnsupportedCommandException;
import lombok.AllArgsConstructor;

/**
 * RepeatCommand repeats the command that threw the exception.
 */
@AllArgsConstructor
public class RepeatCommand implements Command, Second {
    private Object ability;
    private boolean isSecond;

    public RepeatCommand(Object ability) {
        this.ability = ability;
        this.isSecond = false;
    }

    @Override
    public void execute() {
        if (ability instanceof Repeatable repeatable) {
            Command command = repeatable.getCommand();
            command.execute();
        } else {
            throw new UnsupportedCommandException("Repeatable is not supported");
        }
    }

    public boolean isSecond() {
        return isSecond;
    }

    public void setSecond(boolean second) {
        this.isSecond = second;
    }
}
