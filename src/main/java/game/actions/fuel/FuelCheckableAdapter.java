package game.actions.fuel;

import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuelCheckableAdapter implements FuelCheckable {
    private final UObject uObject;

    @Override
    public int getFuelLevel() {
        return (int) uObject.getProperty(Integer.class, "fuel_level");
    }

    @Override
    public int getFuelBurnRate() {
        return (int) uObject.getProperty(Integer.class, "fuel_burn_rate");
    }

    @Override
    public boolean isFuelEnough() {
        return this.getFuelLevel() >= this.getFuelBurnRate();
    }
}
