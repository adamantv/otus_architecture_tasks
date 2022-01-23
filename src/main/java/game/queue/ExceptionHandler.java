package game.queue;

import game.actions.Command;

public interface ExceptionHandler {
    Command handle(Command command, Exception e);
}
