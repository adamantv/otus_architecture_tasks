package task2.actions.rotation;

import task2.actions.Command;

public class RotateCommand implements Command {
    Rotable rotable;

    public RotateCommand(Rotable r) {
        this.rotable = r;
    }

    @Override
    public void execute() {
        rotable.setDirection((rotable.getDirection() + rotable.getAngularVelocity()) % rotable.getMaxDirections());
    }
}
