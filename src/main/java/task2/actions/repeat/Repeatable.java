package task2.actions.repeat;

import task2.actions.Command;

public interface Repeatable {
    Command getCommand();

    void setCommand(Command command);
}
