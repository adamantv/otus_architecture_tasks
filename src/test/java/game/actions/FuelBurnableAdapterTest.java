package game.actions;

import game.actions.fuel.FuelBurnableAdapter;
import game.elements.UObject;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FuelBurnableAdapterTest {
    @Test
    void checkFuelBurnableAdapter() {
        UObject uObject = mock(UObject.class);
        when(uObject.getProperty(Integer.class, "fuel_level")).thenReturn(90);
        when(uObject.getProperty(Integer.class, "fuel_burn_rate")).thenReturn(50);
        FuelBurnableAdapter fuelBurnableAdapter = new FuelBurnableAdapter(uObject);
        fuelBurnableAdapter.burnFuel();
        verify(uObject).getProperty(Integer.class, "fuel_level");
        verify(uObject).getProperty(Integer.class, "fuel_burn_rate");
        verify(uObject).setProperty("fuel_level", 40);
    }
}
