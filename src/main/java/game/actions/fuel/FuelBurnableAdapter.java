package game.actions.fuel;

import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuelBurnableAdapter implements FuelBurnable {
    private final UObject uObject;

    @Override
    public void burnFuel() {
        uObject.setProperty("fuel_level", this.getFuelLevel() - this.getFuelBurnRate());
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
