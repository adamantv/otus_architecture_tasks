package task2.actions.movement;

import task2.util.Vector;

public interface Movable {
    Vector getPosition();

    Vector getVelocity();

    void setPosition(Vector newValue);
}
