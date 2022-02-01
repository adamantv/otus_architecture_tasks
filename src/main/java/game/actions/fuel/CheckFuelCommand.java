package game.actions.fuel;

import game.actions.Command;
import game.exception.CommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckFuelCommand implements Command {
    private final FuelCheckable fuelCheckable;

    @Override
    public void execute() {
        if (!this.isFuelEnough()) {
            throw new CommandException("Required fuel quantity is not enough");
        }
    }

    private boolean isFuelEnough() {
        return fuelCheckable.getFuelLevel() >= fuelCheckable.getFuelBurnRate();
    }
}
