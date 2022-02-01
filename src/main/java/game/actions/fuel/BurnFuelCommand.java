package game.actions.fuel;

import game.actions.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BurnFuelCommand implements Command {
    private final FuelChangeable fuelBurnable;

    @Override
    public void execute() {
        fuelBurnable.setFuelLevel(this.burnFuel());
    }

    private int burnFuel() {
        return fuelBurnable.getFuelLevel() - fuelBurnable.getFuelBurnRate();
    }
}
