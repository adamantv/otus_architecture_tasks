package task2.queue;

import task2.actions.Command;

public interface ExceptionHandler {
    Command handle(Command command, Exception e);
}
