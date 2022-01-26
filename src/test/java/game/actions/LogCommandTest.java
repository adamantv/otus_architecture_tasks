package game.actions;

import game.actions.log.LogCommand;
import game.actions.movement.MoveCommand;
import game.exception.IllegalParameterException;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class LogCommandTest {
    @Test
    void checkLogCommand() {
        MoveCommand moveCommand = mock(MoveCommand.class);
        LogCommand logCommand = new LogCommand(new IllegalParameterException("!!!"), moveCommand);
        logCommand.execute();
    }
}
