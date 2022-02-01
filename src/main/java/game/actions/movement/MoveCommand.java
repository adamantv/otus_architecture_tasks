package game.actions.movement;

import game.actions.Command;
import game.exception.UnsupportedCommandException;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MoveCommand implements Command {
    private final Object ability;
    private final Vector vector = new Vector();

    @Override
    public void execute() {
        if (ability instanceof VelocityMovable movable) {
            movable.setPosition(vector.sum(movable.getPosition(), movable.getVelocity()));
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
