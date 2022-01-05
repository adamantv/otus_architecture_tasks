package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.actions.movement.Movable;
import task2.actions.movement.MovableAdapter;
import task2.actions.movement.MoveCommand;
import task2.actions.rotation.RolableAdapter;
import task2.actions.rotation.Rotable;
import task2.elements.GameElement;
import task2.exception.IllegalParameterException;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

public class MoveCommandTest {
    @Test
    @DisplayName("Try to change position for object with given coordinates")
    public void test1() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(12, 5));
        gameElement.setProperty("position", new Vector(-7, 3));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand();
        moveCommand.execute(movable);
        Assertions.assertEquals(movable.getPosition(), new Vector(5, 8));
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of position")
    public void impossibleReadPosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(12, 5));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand();
        Throwable throwable = Assertions.assertThrows(
                IllegalParameterException.class,
                () -> moveCommand.execute(movable)
        );
        Assertions.assertEquals(throwable.getMessage(), "position");
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of velocity")
    public void impossibleReadVelocity() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(-7, 3));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand();
        Throwable throwable = Assertions.assertThrows(
                IllegalParameterException.class,
                () -> moveCommand.execute(movable)
        );
        Assertions.assertEquals(throwable.getMessage(), "velocity");
    }

    @Test
    @DisplayName("Try to move object with impossibility to change position")
    public void impossibleChangePosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(-7, 3));
        Rotable rotable = new RolableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand();
        Throwable throwable = Assertions.assertThrows(
                UnsupportedCommandException.class,
                () -> moveCommand.execute(rotable)
        );
        Assertions.assertEquals(throwable.getMessage(), "Movable is not supported");
    }
}
