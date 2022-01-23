package game.queue;

import game.actions.Command;
import game.actions.repeat.RepeatCommand;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OneRepeatCommandHandler implements ExceptionHandler {
    private final UtilCommandFactory utilCommandFactory = new UtilCommandFactory();

    /**
     * Handle strategy: on the first throw of an exception, repeat the command;
     * on the second throw of an exception, write the information to the log.
     *
     * @param headCommand - the command from queue, that threw exception
     * @param e           - exception thrown by the headCommand
     * @return new util command (LogCommand or RepeatCommand) for next adding to the queue
     */
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
