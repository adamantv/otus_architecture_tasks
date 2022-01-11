package task2.actions.rotation;

import task2.elements.UObject;

public class RotatableAdapter implements Rotatable {
    private UObject uObject;

    public RotatableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public int getDirection() {
        return (int) uObject.getProperty("direction");
    }

    @Override
    public void setDirection(int direction) {
        uObject.setProperty("direction", direction);
    }

    @Override
    public int getAngularVelocity() {
        return (int) uObject.getProperty("angularVelocity");
    }

    @Override
    public int getMaxDirections() {
        return (int) uObject.getProperty("maxDirections");
    }
}
