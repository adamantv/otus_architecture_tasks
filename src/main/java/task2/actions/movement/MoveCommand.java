package task2.actions.movement;

import task2.actions.Command;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

public class MoveCommand implements Command {
    public MoveCommand() {
    }

    @Override
    public void execute(Object object) {
        if (object instanceof Movable movable) {
            movable.setPosition(Vector.sum(movable.getPosition(), movable.getVelocity()));
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
