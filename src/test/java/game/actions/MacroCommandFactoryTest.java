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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class MacroCommandFactoryTest {
    @Test
    void checkExecuteSomeCommands() {
        FuelCheckable fuelCheckable = mock(FuelCheckable.class);
        when(fuelCheckable.isFuelEnough()).thenReturn(true);
        Movable movable = mock(Movable.class);
        when(movable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        when(movable.getPosition()).thenReturn(new Vector(new int[]{15, 20}));
        FuelBurnable fuelBurnable = mock(FuelBurnable.class);
        doNothing().when(fuelBurnable).burnFuel();
        MacroCommandFactory macroCommandFactory = new MacroCommandFactory();
        MacroCommand macroCommand = macroCommandFactory.createMoveBurnFuelMacroCommand(new CheckFuelCommand(fuelCheckable), new MoveCommand(movable), new BurnFuelCommand(fuelBurnable));
        assertDoesNotThrow(macroCommand::execute);
        verify(fuelCheckable).isFuelEnough();
        verify(movable).getPosition();
        verify(movable).getVelocity();
        verify(movable).setPosition(new Vector(new int[]{20, 30}));
        verify(fuelBurnable).burnFuel();
    }
}
