package game.actions;

import game.actions.movement.MoveCommand;
import game.actions.movement.VelocityMovable;
import game.actions.movement.VelocityMovableAdapter;
import game.actions.rotation.Rotatable;
import game.actions.rotation.RotatableAdapter;
import game.elements.GameElement;
import game.exception.IllegalParameterException;
import game.exception.IllegalPropertyTypeException;
import game.exception.UnsupportedCommandException;
import game.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class MoveCommandTest {
    @Test
    @DisplayName("Try to change position for object with given coordinates")
    public void changePosition() {
        VelocityMovable movable = mock(VelocityMovable.class);
        when(movable.getVelocity()).thenReturn(new Vector(new int[]{12, 5}));
        when(movable.getPosition()).thenReturn(new Vector(new int[]{-7, 3}));
        MoveCommand moveCommand = new MoveCommand(movable);
        moveCommand.execute();
        ArgumentCaptor<Vector> captor = ArgumentCaptor.forClass(Vector.class);
        verify(movable).setPosition(captor.capture());
        assertThat(captor.getValue()).isEqualTo(new Vector(new int[]{5, 8}));
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of position")
    public void impossibleReadPosition() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("velocity", new Vector(new int[]{12, 5}));
        VelocityMovable movable = new VelocityMovableAdapter(gameElement);
        MoveCommand moveCommand = new MoveCommand(movable);
        assertThatThrownBy(moveCommand::execute).isInstanceOf(IllegalParameterException.class)
                .hasMessageContaining("position");
    }

    @Test
    @DisplayName("Try to move object with impossibility to read the value of velocity")
    public void impossibleReadVelocity() {
        GameElement gameElement = new GameElement();
        gameElement.setProperty("position", new Vector(new int[]{-7, 3}));
        VelocityMovable movable = new VelocityMovableAdapter(gameElement);
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
