package game.actions;

import game.actions.macro.MacroCommand;
import game.exception.CommandException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class MacroCommandTest {
    @Test
    void checkInterruptMacroCommand() {
        Command command1 = mock(Command.class);
        Command command2 = mock(Command.class);
        doThrow(new CommandException("")).when(command2).execute();
        Command command3 = mock(Command.class);
        MacroCommand macroCommand = new MacroCommand(Arrays.asList(command1, command2, command3));
        assertThatThrownBy(macroCommand::execute).isInstanceOf(CommandException.class);
        verify(command1).execute();
        verify(command2).execute();
        verify(command3, times(0)).execute();
    }
}
