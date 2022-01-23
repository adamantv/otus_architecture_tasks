package task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.actions.Command;
import task2.actions.log.LogCommand;
import task2.actions.movement.MoveCommand;
import task2.actions.repeat.RepeatCommand;
import task2.queue.OneRepeatCommandHandler;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class OneRepeatCommandHandlerTest {
    @Test
    @DisplayName("Case if need to repeat command after first exception")
    void testGenerateRepeatCommand() {
        OneRepeatCommandHandler handler = new OneRepeatCommandHandler();
        MoveCommand moveCommand = mock(MoveCommand.class);
        Command newCommand = handler.handle(moveCommand, new Exception("test"));
        assertTrue(newCommand instanceof RepeatCommand);
    }

    @Test
    @DisplayName("Case if need to log command after first repeat command")
    void testGenerateLogCommand() {
        OneRepeatCommandHandler handler = new OneRepeatCommandHandler();
        RepeatCommand repeatCommand = mock(RepeatCommand.class);
        Command newCommand = handler.handle(repeatCommand, new Exception("test"));
        assertTrue(newCommand instanceof LogCommand);
    }
}
