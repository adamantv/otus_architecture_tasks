package task2.actions.repeat;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.exception.UnsupportedCommandException;

@AllArgsConstructor
public class RepeatCommand implements Command {
    private final Object ability;

    @Override
    public void execute() {
        if (ability instanceof Repeatable repeatable) {
            Command command = repeatable.getCommand();
            command.execute();
        } else {
            throw new UnsupportedCommandException("Loggable is not supported");
        }
    }
}
