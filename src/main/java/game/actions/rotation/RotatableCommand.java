package game.actions.rotation;

import game.actions.Command;
import game.exception.UnsupportedCommandException;
import lombok.AllArgsConstructor;

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
