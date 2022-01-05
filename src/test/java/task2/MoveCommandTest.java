package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.actions.movement.Movable;
import task2.actions.movement.MovableAdapter;
import task2.actions.movement.MoveCommand;
import task2.elements.GameElement;
import task2.exception.IllegalParameterException;
import task2.util.Vector;

public class MoveCommandTest {
    @Test
    @DisplayName("Change position")
    public void test1() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(12, 5));
        gameElement.setProperty("position", new Vector(-7, 3));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        moveCommand.execute();
        Assertions.assertEquals(movable.getPosition(), new Vector(5, 8));
    }

    @Test
    @DisplayName("Illegal position")
    public void test2() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(12, 5));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        Throwable throwable = Assertions.assertThrows(
                IllegalParameterException.class,
                moveCommand::execute
        );
        Assertions.assertEquals(throwable.getMessage(), "position");
    }

    @Test
    @DisplayName("Illegal velocity")
    public void test3() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(-7, 3));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        Throwable throwable = Assertions.assertThrows(
                IllegalParameterException.class,
                moveCommand::execute
        );
        Assertions.assertEquals(throwable.getMessage(), "velocity");
    }
}
