package game.actions.fuel;

public interface FuelBurnable {
    void setFuelLevel(int newValue);

    int getFuelLevel();

    int getFuelBurnRate();
}
