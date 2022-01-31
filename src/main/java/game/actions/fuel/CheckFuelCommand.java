package game.actions.fuel;

import game.actions.Command;
import game.exception.CommandException;
import game.exception.UnsupportedCommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckFuelCommand implements Command {
    private final Object ability;

    @Override
    public void execute() {
        if (ability instanceof FuelCheckable fuelCheckable) {
            if (!fuelCheckable.isFuelEnough()) {
                throw new CommandException("Required fuel quantity is not enough");
            }
        } else {
            throw new UnsupportedCommandException("FuelCheckable is not supported");
        }
    }
}
