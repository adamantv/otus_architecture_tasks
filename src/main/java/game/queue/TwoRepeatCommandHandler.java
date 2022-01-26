package game.queue;

import game.actions.Command;
import game.actions.repeat.RepeatCommand;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TwoRepeatCommandHandler implements ExceptionHandler {
    private final UtilCommandFactory utilCommandFactory = new UtilCommandFactory();

    /**
     * Handle strategy: repeat twice, then write to the log.
     *
     * @param headCommand - the command from queue, that threw exception
     * @param e           - exception thrown by the headCommand
     * @return new util command (LogCommand or RepeatCommand) for next adding to the queue
     */
    @Override
    public Command handle(Command headCommand, Exception e) {
        Command newCommand;
        if (headCommand instanceof RepeatCommand) {
            if (((RepeatCommand) headCommand).isSecond()) {
                newCommand = utilCommandFactory.createLogCommand(e, headCommand);
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
