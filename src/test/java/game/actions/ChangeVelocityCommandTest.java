package game.actions;

import game.actions.change.velocity.ChangeVelocityCommand;
import game.actions.change.velocity.VelocityChangeable;
import game.actions.movement.Movable;
import game.actions.rotation.Rotatable;
import game.util.Vector;
import org.junit.jupiter.api.Test;

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
}
