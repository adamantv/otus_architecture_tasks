package task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.actions.Command;
import task2.actions.log.LogCommand;
import task2.actions.movement.MoveCommand;
import task2.actions.repeat.RepeatCommand;
import task2.actions.repeat.RepeatableAdapter;
import task2.elements.GameElement;
import task2.queue.TwoRepeatCommandHandler;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TwoRepeatCommandHandlerTest {
    @Test
    @DisplayName("Case if need to repeat command after first exception")
    void testGenerateFirstRepeatCommand() {
        TwoRepeatCommandHandler handler = new TwoRepeatCommandHandler();
        MoveCommand moveCommand = mock(MoveCommand.class);
        Command newCommand = handler.handle(moveCommand, new Exception("test"));
        assertTrue(newCommand instanceof RepeatCommand);
    }

    @Test
    @DisplayName("Case if need to second repeat command after first repeat command")
    void testGenerateSecondRepeatCommand() {
        TwoRepeatCommandHandler handler = new TwoRepeatCommandHandler();
        GameElement<Command> gameElement = new GameElement<>();
        gameElement.setProperty("command", mock(MoveCommand.class));
        RepeatCommand repeatCommand = new RepeatCommand(new RepeatableAdapter(gameElement));
        Command newCommand = handler.handle(repeatCommand, new Exception("test"));
        assertTrue(newCommand instanceof RepeatCommand);
        assertTrue(((RepeatCommand) newCommand).isSecond());
    }

    @Test
    @DisplayName("Case if need to use log command after second repeat command")
    void testGenerateLogCommand() {
        TwoRepeatCommandHandler handler = new TwoRepeatCommandHandler();
        GameElement<Command> gameElement = new GameElement<>();
        gameElement.setProperty("command", mock(MoveCommand.class));
        RepeatCommand repeatCommand = new RepeatCommand(new RepeatableAdapter(gameElement));
        repeatCommand.setSecond(true);
        Command newCommand = handler.handle(repeatCommand, new Exception("test"));
        assertTrue(newCommand instanceof LogCommand);
    }
}
