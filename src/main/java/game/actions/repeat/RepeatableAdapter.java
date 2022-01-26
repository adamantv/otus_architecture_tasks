package game.actions.repeat;

import game.actions.Command;
import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RepeatableAdapter implements Repeatable {
    private final UObject uObject;

    @Override
    public Command getCommand() {
        return (Command) uObject.getProperty(Command.class, "command");
    }

    @Override
    public void setCommand(Command command) {
        uObject.setProperty("command", command);
    }
}
