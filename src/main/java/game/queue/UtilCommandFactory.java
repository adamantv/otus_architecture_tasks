package game.queue;

import game.actions.Command;
import game.actions.log.LogCommand;
import game.actions.repeat.RepeatCommand;
import game.actions.repeat.RepeatableAdapter;
import game.elements.GameElement;

/**
 * Class for creating util commands
 */
public class UtilCommandFactory {
    public LogCommand createLogCommand(Exception e, Command command) {
        return new LogCommand(e, command);
    }

    public RepeatCommand createRepeatCommand(Command headCommand) {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("command", headCommand);
        return new RepeatCommand(new RepeatableAdapter(gameElement));
    }
}
