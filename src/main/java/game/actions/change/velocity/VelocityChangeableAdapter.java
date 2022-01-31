package game.actions.change.velocity;

import game.elements.UObject;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VelocityChangeableAdapter implements VelocityChangeable {
    private final UObject uObject;

    @Override
    public void setVelocity(Vector newValue) {
        uObject.setProperty("velocity", newValue);
    }
}
