package task2.queue;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.actions.repeat.RepeatCommand;

import java.util.Queue;

@AllArgsConstructor
public class TwoRepeatCommandHandler implements ExceptionHandler {
    private UtilCommandFactory utilCommandFactory;

    @Override
    public void handle(CommandQueue commandQueue, Exception e, Command headCommand) {
        Queue<Command> queue = commandQueue.getQueue();
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
        queue.add(newCommand);
        queue.remove();
    }
}
