package task2.actions.movement;

import task2.actions.Command;
import task2.util.Vector;

public class MoveCommand implements Command {
    Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        movable.setPosition(Vector.sum(movable.getPosition(), movable.getVelocity()));
    }
}
