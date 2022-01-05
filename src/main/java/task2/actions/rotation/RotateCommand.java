package task2.actions.rotation;

import task2.actions.Command;
import task2.exception.UnsupportedCommandException;

public class RotateCommand implements Command {
    public RotateCommand() {
    }

    @Override
    public void execute(Object object) {
        if (object instanceof Rotable rotable) {
            rotable.setDirection((rotable.getDirection() + rotable.getAngularVelocity()) % rotable.getMaxDirections());
        } else {
            throw new UnsupportedCommandException("Rotable is not supported");
        }
    }
}
