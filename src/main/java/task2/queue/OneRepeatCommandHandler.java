package task2.queue;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.actions.repeat.RepeatCommand;

import java.util.Queue;

@AllArgsConstructor
public class OneRepeatCommandHandler implements ExceptionHandler {
    private UtilCommandFactory utilCommandFactory;

    @Override
    public void handle(CommandQueue commandQueue, Exception e, Command headCommand) {
        Queue<Command> queue = commandQueue.getQueue();
        Command newCommand;
        if (headCommand instanceof RepeatCommand) {
            newCommand = utilCommandFactory.createLogCommand(e.getMessage());
        } else {
            newCommand = utilCommandFactory.createRepeatCommand(headCommand);
        }
        queue.add(newCommand);
        queue.remove();
    }
}
