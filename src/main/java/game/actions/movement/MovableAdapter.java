package game.actions.movement;

import game.elements.UObject;
import game.util.Vector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovableAdapter implements Movable {
    private final UObject uObject;

    @Override
    public Vector getPosition() {
        return (Vector) uObject.getProperty(Vector.class, "position");
    }

    @Override
    public Vector getVelocity() {
        return (Vector) uObject.getProperty(Vector.class, "velocity");
    }

    @Override
    public void setPosition(Vector newValue) {
        uObject.setProperty("position", newValue);
    }
}
