package game.actions;

import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.CheckFuelCommand;
import game.actions.fuel.FuelBurnable;
import game.actions.fuel.FuelCheckable;
import game.actions.macro.MacroCommand;
import game.actions.macro.MacroCommandFactory;
import game.actions.movement.Movable;
import game.actions.movement.MoveCommand;
import game.util.Vector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class MacroCommandFactoryTest {
    @Test
    void macroCommandCreate() {
        Command command1 = mock(Command.class);
        Command command2 = mock(Command.class);
        Command command3 = mock(Command.class);
        MacroCommandFactory macroCommandFactory = new MacroCommandFactory();
        MacroCommand macroCommand = macroCommandFactory.createMacroCommand(command1, command2, command3);
        assertThat(macroCommand.getCommands()).isNotNull().hasSize(3);
    }

    @Test
    void macroCommandMoveTest() {
        FuelCheckable fuelCheckable = mock(FuelCheckable.class);
        when(fuelCheckable.getFuelLevel()).thenReturn(7);
        when(fuelCheckable.getFuelBurnRate()).thenReturn(6);
        Movable movable = mock(Movable.class);
        when(movable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        when(movable.getPosition()).thenReturn(new Vector(new int[]{15, 20}));
        FuelBurnable fuelBurnable = mock(FuelBurnable.class);
        doNothing().when(fuelBurnable).burnFuel();
        MacroCommandFactory macroCommandFactory = new MacroCommandFactory();
        MacroCommand macroCommand = macroCommandFactory.createMacroCommand(new CheckFuelCommand(fuelCheckable), new MoveCommand(movable), new BurnFuelCommand(fuelBurnable));
        assertDoesNotThrow(macroCommand::execute);
        verify(movable).getPosition();
        verify(movable).getVelocity();
        verify(movable).setPosition(new Vector(new int[]{20, 30}));
        verify(fuelBurnable).burnFuel();
    }
}
