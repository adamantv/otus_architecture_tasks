package task2.queue;

import task2.actions.Command;

public interface ExceptionHandler {
    void handle(CommandQueue commandQueue, Exception e, Command headCommand);
}
