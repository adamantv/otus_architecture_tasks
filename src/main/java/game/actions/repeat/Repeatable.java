package game.actions.repeat;

import game.actions.Command;

public interface Repeatable {
    Command getCommand();

    void setCommand(Command command);
}
