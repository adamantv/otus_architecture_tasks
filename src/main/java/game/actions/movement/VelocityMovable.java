package game.actions.movement;

import game.util.Vector;

public interface VelocityMovable {
    Vector getPosition();

    Vector getVelocity();

    void setPosition(Vector newValue);

    void setVelocity(Vector newValue);
}
