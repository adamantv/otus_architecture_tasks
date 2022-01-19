package task2.actions.rotation;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.exception.UnsupportedCommandException;

@AllArgsConstructor
public class RotatableCommand implements Command {
    private Object ability;

    @Override
    public void execute() {
        if (ability instanceof Rotatable rotatable) {
            rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getMaxDirections());
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
