package game.actions.change.velocity;

import game.actions.Command;
import game.actions.movement.Movable;
import game.actions.rotation.Rotatable;
import game.exception.UnsupportedCommandException;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeVelocityCommand implements Command {
    private Object movable;
    private Object rotatable;
    private Object velocityChangeable;

    @Override
    public void execute() {
        Vector velocity;
        if (movable == null) {
            velocity = new Vector(new int[]{0, 0});
        } else {
            velocity = ((Movable) movable).getVelocity();
        }
        if (!(rotatable instanceof Rotatable)) {
            throw new UnsupportedCommandException("Rotatable is not supported");
        }
        int angularVelocity = ((Rotatable) rotatable).getAngularVelocity();
        if (!(velocityChangeable instanceof VelocityChangeable)) {
            throw new UnsupportedCommandException("VelocityChangeable is not supported");
        }
        Vector result = velocity.rotate(angularVelocity);
        ((VelocityChangeable) velocityChangeable).setVelocity(result);
    }
}
