package task2.actions.rotation;

import lombok.AllArgsConstructor;
import task2.elements.UObject;

@AllArgsConstructor
public class RotatableAdapter implements Rotatable {
    private UObject<Integer> uObject;

    @Override
    public int getDirection() {
        return uObject.getProperty(Integer.class, "direction");
    }

    @Override
    public void setDirection(int direction) {
        uObject.setProperty("direction", direction);
    }

    @Override
    public int getAngularVelocity() {
        return uObject.getProperty(Integer.class, "angularVelocity");
    }

    @Override
    public int getMaxDirections() {
        return uObject.getProperty(Integer.class, "maxDirections");
    }
}
