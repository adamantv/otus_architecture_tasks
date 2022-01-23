package game.actions.repeat;

import game.actions.Command;
import game.elements.UObject;
import lombok.AllArgsConstructor;

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
