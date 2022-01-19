package task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.actions.movement.Movable;
import task2.actions.movement.MovableAdapter;
import task2.actions.movement.MoveCommand;
import task2.actions.rotation.Rotatable;
import task2.actions.rotation.RotatableAdapter;
import task2.elements.GameElement;
import task2.exception.IllegalParameterException;
import task2.exception.IllegalPropertyTypeException;
import task2.exception.UnsupportedCommandException;
import task2.util.Vector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCommandTest {
    @Test
    @DisplayName("Try to change position for object with given coordinates")
    public void changePosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(new int[]{12, 5}));
        gameElement.setProperty("position", new Vector(new int[]{-7, 3}));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        moveCommand.execute();
        assertThat(movable.getPosition()).isEqualTo(new Vector(new int[]{5, 8}));
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of position")
    public void impossibleReadPosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(new int[]{12, 5}));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        assertThatThrownBy(moveCommand::execute).isInstanceOf(IllegalParameterException.class)
                .hasMessageContaining("position");
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of velocity")
    public void impossibleReadVelocity() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(new int[]{-7, 3}));
        Movable movable = new MovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        assertThatThrownBy(moveCommand::execute).isInstanceOf(IllegalParameterException.class)
                .hasMessageContaining("velocity");
    }

    @Test
    @DisplayName("Try to move object with impossibility to change position")
    public void impossibleChangePosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(new int[]{-7, 3}));
        Rotatable rotatable = new RotatableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(rotatable);
        assertThatThrownBy(moveCommand::execute).isInstanceOf(UnsupportedCommandException.class)
                .hasMessageContaining("Movable is not supported");
    }

    @Test
    @DisplayName("Try get property for wrong type")
    public void getPropertyForWrongType() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(new int[]{12, 5}));
        assertThatThrownBy(() -> {
            gameElement.getProperty(Integer.class, "velocity");
        }).isInstanceOf(IllegalPropertyTypeException.class)
                .hasMessageContaining("Illegal type class java.lang.Integer for parameter velocity");
    }
}
