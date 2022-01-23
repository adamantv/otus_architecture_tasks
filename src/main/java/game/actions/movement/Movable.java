package game.actions.movement;

import game.util.Vector;

public interface Movable {
    Vector getPosition();

    Vector getVelocity();

    void setPosition(Vector newValue);
}
