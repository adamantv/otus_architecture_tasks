package game.actions;

import game.actions.fuel.CheckFuelCommand;
import game.actions.fuel.FuelCheckable;
import game.exception.CommandException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckFuelCommandTest {
    @Test
    void checkFuelCommandSuccess() {
        FuelCheckable fuelCheckable = mock(FuelCheckable.class);
        when(fuelCheckable.getFuelLevel()).thenReturn(7);
        when(fuelCheckable.getFuelBurnRate()).thenReturn(6);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelCheckable);
        assertDoesNotThrow(checkFuelCommand::execute);
    }

    @Test
    void checkFuelCommandFailure() {
        FuelCheckable fuelCheckable = mock(FuelCheckable.class);
        when(fuelCheckable.getFuelLevel()).thenReturn(5);
        when(fuelCheckable.getFuelBurnRate()).thenReturn(6);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelCheckable);
        assertThatThrownBy(checkFuelCommand::execute).isInstanceOf(CommandException.class)
                .hasMessageContaining("Required fuel quantity is not enough");
    }
}
