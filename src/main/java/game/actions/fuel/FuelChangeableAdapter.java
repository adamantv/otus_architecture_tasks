package game.actions.fuel;

import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuelChangeableAdapter implements FuelChangeable {
    private final UObject uObject;

    @Override
    public void setFuelLevel(int newValue) {
        uObject.setProperty("fuel_level", newValue);
    }

    @Override
    public int getFuelLevel() {
        return (int) uObject.getProperty(Integer.class, "fuel_level");
    }

    @Override
    public int getFuelBurnRate() {
        return (int) uObject.getProperty(Integer.class, "fuel_burn_rate");
    }
}
