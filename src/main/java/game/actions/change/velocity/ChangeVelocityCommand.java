package game.actions.change.velocity;

import game.actions.Command;
import game.actions.movement.Movable;
import game.actions.rotation.Rotatable;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeVelocityCommand implements Command {
    private final Movable movable;
    private final Rotatable rotatable;
    private final VelocityChangeable velocityChangeable;

    @Override
    public void execute() {
        Vector velocity;
        if (movable == null) {
            velocity = new Vector(new int[]{0, 0});
        } else {
            velocity = movable.getVelocity();
        }
        int angularVelocity = rotatable.getAngularVelocity();
        Vector result = velocity.rotate(angularVelocity);
        velocityChangeable.setVelocity(result);
    }
}
