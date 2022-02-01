package game.actions;

import game.actions.fuel.FuelChangeableAdapter;
import game.elements.UObject;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FuelChangeableAdapterTest {
    @Test
    void checkFuelBurnableAdapter() {
        UObject uObject = mock(UObject.class);
        when(uObject.getProperty(Integer.class, "fuel_level")).thenReturn(90);
        when(uObject.getProperty(Integer.class, "fuel_burn_rate")).thenReturn(50);
        FuelChangeableAdapter fuelBurnableAdapter = new FuelChangeableAdapter(uObject);
        fuelBurnableAdapter.setFuelLevel(40);
        verify(uObject).setProperty("fuel_level", 40);
        fuelBurnableAdapter.getFuelBurnRate();
        verify(uObject).getProperty(Integer.class, "fuel_burn_rate");
        fuelBurnableAdapter.getFuelLevel();
        verify(uObject).getProperty(Integer.class, "fuel_level");
    }
}
