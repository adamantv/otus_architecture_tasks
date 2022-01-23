package task2.queue;

import lombok.NoArgsConstructor;
import task2.actions.Command;
import task2.actions.repeat.RepeatCommand;

@NoArgsConstructor
public class TwoRepeatCommandHandler implements ExceptionHandler {
    private final UtilCommandFactory utilCommandFactory = new UtilCommandFactory();

    @Override
    public Command handle(Command headCommand, Exception e) {
        Command newCommand;
        if (headCommand instanceof RepeatCommand) {
            if (((RepeatCommand) headCommand).isSecond()) {
                newCommand = utilCommandFactory.createLogCommand(e.getMessage());
            } else {
                ((RepeatCommand) headCommand).setSecond(true);
                newCommand = headCommand;
            }
        } else {
            newCommand = utilCommandFactory.createRepeatCommand(headCommand);
        }
        return newCommand;
    }
}
