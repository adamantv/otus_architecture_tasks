package game.actions;

import game.actions.fuel.FuelCheckableAdapter;
import game.elements.UObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FuelCheckableAdapterTest {
    @Test
    void checkFuelCheckableAdapter() {
        UObject uObject = mock(UObject.class);
        when(uObject.getProperty(Integer.class, "fuel_level")).thenReturn(60);
        when(uObject.getProperty(Integer.class, "fuel_burn_rate")).thenReturn(30);
        FuelCheckableAdapter fuelCheckableAdapter = new FuelCheckableAdapter(uObject);
        assertThat(fuelCheckableAdapter.getFuelLevel()).isEqualTo(60);
        assertThat(fuelCheckableAdapter.getFuelBurnRate()).isEqualTo(30);
    }
}
