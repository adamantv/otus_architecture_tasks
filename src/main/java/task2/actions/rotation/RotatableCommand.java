package task2.actions.rotation;

import task2.actions.Command;
import task2.exception.UnsupportedCommandException;

public class RotatableCommand implements Command {
    private Object ability;

    public RotatableCommand(Object ability) {
        this.ability = ability;
    }

    @Override
    public void execute() {
        if (ability instanceof Rotatable rotatable) {
            rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getMaxDirections());
            ;
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
