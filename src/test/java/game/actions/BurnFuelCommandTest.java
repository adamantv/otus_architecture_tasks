package game.actions;

import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.FuelBurnable;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BurnFuelCommandTest {

    @Test
    void checkBurnFuelCommandExecute() {
        FuelBurnable fuelBurnable = mock(FuelBurnable.class);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurnable);
        burnFuelCommand.execute();
        verify(fuelBurnable).burnFuel();
    }
}
