package task2.actions.repeat;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.elements.UObject;

@AllArgsConstructor
public class RepeatableAdapter implements Repeatable {
    private final UObject<Command> uObject;

    @Override
    public Command getCommand() {
        return uObject.getProperty(Command.class, "command");
    }

    @Override
    public void setCommand(Command command) {
        uObject.setProperty("command", command);
    }
}
