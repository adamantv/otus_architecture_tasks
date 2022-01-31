package game.actions.fuel;

import game.actions.Command;
import game.exception.UnsupportedCommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BurnFuelCommand implements Command {
    private final Object ability;

    @Override
    public void execute() {
        if (ability instanceof FuelBurnable fuelBurnable) {
            fuelBurnable.burnFuel();
        } else {
            throw new UnsupportedCommandException("FuelBurnable is not supported");
        }
    }
}
