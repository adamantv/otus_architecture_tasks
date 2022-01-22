package task2.actions.repeat;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.actions.Second;
import task2.exception.UnsupportedCommandException;

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
            throw new UnsupportedCommandException("Loggable is not supported");
        }
    }

    public boolean isSecond() {
        return isSecond;
    }

    public void setSecond(boolean second) {
        isSecond = second;
    }
}
