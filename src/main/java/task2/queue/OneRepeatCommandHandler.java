package task2.queue;

import lombok.NoArgsConstructor;
import task2.actions.Command;
import task2.actions.repeat.RepeatCommand;

@NoArgsConstructor
public class OneRepeatCommandHandler implements ExceptionHandler {
    private final UtilCommandFactory utilCommandFactory = new UtilCommandFactory();

    @Override
    public Command handle(Command headCommand, Exception e) {
        Command newCommand;
        if (headCommand instanceof RepeatCommand) {
            newCommand = utilCommandFactory.createLogCommand(e.getMessage());
        } else {
            newCommand = utilCommandFactory.createRepeatCommand(headCommand);
        }
        return newCommand;
    }
}
