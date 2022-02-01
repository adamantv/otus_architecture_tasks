package game.actions.rotation;

import game.actions.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RotateCommand implements Command {
    private Rotatable rotatable;

    @Override
    public void execute() {
        rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getMaxDirections());
    }
}
