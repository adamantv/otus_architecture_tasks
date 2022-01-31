package game.actions;

import game.actions.change.velocity.ChangeVelocityCommand;
import game.actions.change.velocity.VelocityChangeable;
import game.actions.movement.Movable;
import game.actions.rotation.Rotatable;
import game.exception.UnsupportedCommandException;
import game.util.Vector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class ChangeVelocityCommandTest {
    @Test
    void testAllAbilitiesSupported() {
        Movable movable = mock(Movable.class);
        Rotatable rotatable = mock(Rotatable.class);
        VelocityChangeable velocityChangeable = mock(VelocityChangeable.class);
        when(movable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        when(rotatable.getAngularVelocity()).thenReturn(15);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(movable, rotatable, velocityChangeable);
        changeVelocityCommand.execute();
        verify(movable).getVelocity();
        verify(rotatable).getAngularVelocity();
        verify(velocityChangeable).setVelocity(any());
    }

    @Test
    void testMovableIsNotSupported() {
        Rotatable rotatable = mock(Rotatable.class);
        VelocityChangeable velocityChangeable = mock(VelocityChangeable.class);
        when(rotatable.getAngularVelocity()).thenReturn(15);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(null, rotatable, velocityChangeable);
        changeVelocityCommand.execute();
        verify(rotatable).getAngularVelocity();
        verify(velocityChangeable).setVelocity(any());
    }

    @Test
    void testRotatableIsNotSupported() {
        Movable movable = mock(Movable.class);
        VelocityChangeable velocityChangeable = mock(VelocityChangeable.class);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(movable, movable, velocityChangeable);
        assertThatThrownBy(changeVelocityCommand::execute).isInstanceOf(UnsupportedCommandException.class).hasMessageContaining("Rotatable is not supported");
    }

    @Test
    void testVelocityChangeableIsNotSupported() {
        Movable movable = mock(Movable.class);
        Rotatable rotatable = mock(Rotatable.class);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(movable, rotatable, rotatable);
        assertThatThrownBy(changeVelocityCommand::execute).isInstanceOf(UnsupportedCommandException.class).hasMessageContaining("VelocityChangeable is not supported");
    }


}
