package task2.queue;

import task2.actions.Command;
import task2.actions.log.LogCommand;
import task2.actions.log.LoggableAdapter;
import task2.actions.repeat.RepeatCommand;
import task2.actions.repeat.RepeatableAdapter;
import task2.elements.GameElement;

public class UtilCommandFactory {
    public LogCommand createLogCommand(String message) {
        GameElement<String> gameElement = new GameElement<>();
        gameElement.setProperty("log", message);
        return new LogCommand(new LoggableAdapter(gameElement));
    }

    public RepeatCommand createRepeatCommand(Command headCommand) {
        GameElement<Command> gameElement = new GameElement<>();
        gameElement.setProperty("command", headCommand);
        return new RepeatCommand(new RepeatableAdapter(gameElement));
    }
}
