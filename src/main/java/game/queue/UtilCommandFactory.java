package game.queue;

import game.actions.Command;
import game.actions.log.LogCommand;
import game.actions.log.LoggableAdapter;
import game.actions.repeat.RepeatCommand;
import game.actions.repeat.RepeatableAdapter;
import game.elements.GameElement;

/**
 * Class for creating util commands
 */
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
