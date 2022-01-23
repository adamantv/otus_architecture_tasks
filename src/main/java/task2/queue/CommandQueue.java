package task2.queue;

import lombok.AllArgsConstructor;
import task2.actions.Command;

import java.util.Queue;

@AllArgsConstructor
public class CommandQueue {
    private Queue<Command> queue;
    private ExceptionHandler exceptionHandler;

    public void addCommandToQueue(Command command) {
        queue.add(command);
    }

    public void executeQueue() {
        if (queue != null && queue.peek() != null) {
            Command headCommand = queue.peek();
            try {
                headCommand.execute();
                queue.remove();
            } catch (Exception e) {
                Command newCommand = exceptionHandler.handle(headCommand, e);
                queue.add(newCommand);
                queue.remove();
            }
        }
    }

    public Queue<Command> getQueue() {
        return queue;
    }
}
