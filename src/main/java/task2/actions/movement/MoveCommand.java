package task2.actions.movement;

import task2.actions.Command;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

public class MoveCommand implements Command {
    private Object ability;

    public MoveCommand(Object ability) {
        this.ability = ability;
    }

    @Override
    public void execute() {
        if (ability instanceof Movable movable) {
            movable.setPosition(Vector.sum(movable.getPosition(), movable.getVelocity()));
        } else {
            throw new UnsupportedCommandException("Movable is not supported");
        }
    }
}
