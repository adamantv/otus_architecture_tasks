package game.actions;

import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.FuelChangeable;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BurnFuelCommandTest {

    @Test
    void checkBurnFuelCommandExecute() {
        FuelChangeable fuelChangeable = mock(FuelChangeable.class);
        when(fuelChangeable.getFuelLevel()).thenReturn(90);
        when(fuelChangeable.getFuelBurnRate()).thenReturn(50);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelChangeable);
        burnFuelCommand.execute();
        verify(fuelChangeable).setFuelLevel(40);
    }
}
