package game.actions.rotation;

public interface Rotatable {
    int getDirection();

    void setDirection(int direction);

    int getAngularVelocity();

    int getMaxDirections();
}
