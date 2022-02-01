package game.actions;

import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.FuelBurnable;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BurnFuelCommandTest {

    @Test
    void checkBurnFuelCommandExecute() {
        FuelBurnable fuelBurnable = mock(FuelBurnable.class);
        when(fuelBurnable.getFuelLevel()).thenReturn(90);
        when(fuelBurnable.getFuelBurnRate()).thenReturn(50);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurnable);
        burnFuelCommand.execute();
        verify(fuelBurnable).setFuelLevel(40);
    }
}
