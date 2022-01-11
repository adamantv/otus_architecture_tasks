package task2.actions.movement;

import task2.elements.UObject;
import task2.util.Vector;

public class MovableAdapter implements Movable {
    private UObject uObject;

    public MovableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Vector getPosition() {
        return (Vector) uObject.getProperty("position");
    }

    @Override
    public Vector getVelocity() {
        return (Vector) uObject.getProperty("velocity");
    }

    @Override
    public void setPosition(Vector newValue) {
        uObject.setProperty("position", newValue);
    }
}
