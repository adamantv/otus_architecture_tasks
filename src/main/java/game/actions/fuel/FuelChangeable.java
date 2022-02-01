package game.actions.fuel;

public interface FuelChangeable {
    void setFuelLevel(int newValue);

    int getFuelLevel();

    int getFuelBurnRate();
}
