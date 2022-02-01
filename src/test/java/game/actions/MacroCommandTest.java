package game.actions;

import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.CheckFuelCommand;
import game.actions.fuel.FuelChangeable;
import game.actions.macro.MacroCommand;
import game.actions.movement.ChangeVelocityCommand;
import game.actions.movement.MoveCommand;
import game.actions.movement.VelocityMovable;
import game.actions.rotation.Rotatable;
import game.actions.rotation.RotateCommand;
import game.exception.CommandException;
import game.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class MacroCommandTest {
    @Test
    @DisplayName("Check case if command sequence stopped, and MacroCommand throws a CommandException")
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

    @Test
    @DisplayName("Check MacroCommand creates correctly")
    void macroCommandCreate() {
        Command command1 = mock(Command.class);
        Command command2 = mock(Command.class);
        Command command3 = mock(Command.class);
        MacroCommand macroCommand = new MacroCommand(command1, command2, command3);
        assertThat(macroCommand.getCommands()).isNotNull().hasSize(3);
    }

    @Test
    @DisplayName("Check MacroCommand for straight movement with fuel consumption")
    void macroCommandMoveTest() {
        VelocityMovable velocityMovable = mock(VelocityMovable.class);
        when(velocityMovable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        when(velocityMovable.getPosition()).thenReturn(new Vector(new int[]{15, 20}));
        FuelChangeable fuelChangeable = mock(FuelChangeable.class);
        when(fuelChangeable.getFuelLevel()).thenReturn(7);
        when(fuelChangeable.getFuelBurnRate()).thenReturn(6);
        doNothing().when(fuelChangeable).setFuelLevel(anyInt());
        MacroCommand macroCommand = new MacroCommand(new CheckFuelCommand(fuelChangeable), new MoveCommand(velocityMovable), new BurnFuelCommand(fuelChangeable));
        assertDoesNotThrow(macroCommand::execute);
        verify(velocityMovable).getPosition();
        verify(velocityMovable).getVelocity();
        verify(velocityMovable).setPosition(new Vector(new int[]{20, 30}));
        verify(fuelChangeable).setFuelLevel(anyInt());
    }

    @Test
    @DisplayName("Check MacroCommand of rotation, when also changed velocity vector, if exists")
    void macroCommandRotateTest() {
        Rotatable rotatable = mock(Rotatable.class);
        when(rotatable.getAngularVelocity()).thenReturn(30);
        when(rotatable.getDirection()).thenReturn(1);
        when(rotatable.getMaxDirections()).thenReturn(5);
        RotateCommand rotateCommand = new RotateCommand(rotatable);
        VelocityMovable velocityMovable = mock(VelocityMovable.class);
        when(velocityMovable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(velocityMovable, rotatable);
        MacroCommand macroCommand = new MacroCommand(rotateCommand, changeVelocityCommand);
        macroCommand.execute();
        verify(rotatable).setDirection(anyInt());
        verify(velocityMovable).setVelocity(any(Vector.class));
    }
}
