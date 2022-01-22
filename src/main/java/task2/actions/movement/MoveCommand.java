package task2.actions.movement;

import lombok.AllArgsConstructor;
import task2.actions.Command;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

@AllArgsConstructor
public class MoveCommand implements Command {
    private final Vector vector = new Vector();

    @Override
    public void execute(Object ability) {
        if (ability instanceof Movable movable) {
            movable.setPosition(vector.sum(movable.getPosition(), movable.getVelocity()));
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
