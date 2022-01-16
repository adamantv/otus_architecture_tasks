package task2.actions.movement;

import lombok.AllArgsConstructor;
import task2.elements.UObject;
import task2.util.Vector;

@AllArgsConstructor
public class MovableAdapter implements Movable {
    private final UObject<Vector> uObject;

    @Override
    public Vector getPosition() {
        return uObject.getProperty(Vector.class, "position");
    }

    @Override
    public Vector getVelocity() {
        return uObject.getProperty(Vector.class, "velocity");
    }

    @Override
    public void setPosition(Vector newValue) {
        uObject.setProperty("position", newValue);
    }
}
