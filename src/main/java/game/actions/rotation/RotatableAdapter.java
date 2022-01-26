package game.actions.rotation;

import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RotatableAdapter implements Rotatable {
    private UObject uObject;

    @Override
    public int getDirection() {
        return (int) uObject.getProperty(Integer.class, "direction");
    }

    @Override
    public void setDirection(int direction) {
        uObject.setProperty("direction", direction);
    }

    @Override
    public int getAngularVelocity() {
        return (int) uObject.getProperty(Integer.class, "angularVelocity");
    }

    @Override
    public int getMaxDirections() {
        return (int) uObject.getProperty(Integer.class, "maxDirections");
    }
}
