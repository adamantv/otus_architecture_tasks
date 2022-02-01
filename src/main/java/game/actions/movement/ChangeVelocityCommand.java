package game.actions.movement;

import game.actions.Command;
import game.actions.rotation.Rotatable;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeVelocityCommand implements Command {
    private final VelocityMovable velocityMovable;
    private final Rotatable rotatable;

    @Override
    public void execute() {
        Vector velocity;
        if (velocityMovable.getVelocity() == null) {
            velocity = new Vector(new int[]{0, 0});
        } else {
            velocity = velocityMovable.getVelocity();
        }
        int angularVelocity = rotatable.getAngularVelocity();
        Vector result = velocity.rotate(angularVelocity);
        velocityMovable.setVelocity(result);
    }
}
