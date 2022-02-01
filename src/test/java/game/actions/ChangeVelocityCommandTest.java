package game.actions;

import game.actions.movement.ChangeVelocityCommand;
import game.actions.movement.VelocityMovable;
import game.actions.rotation.Rotatable;
import game.util.Vector;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ChangeVelocityCommandTest {
    @Test
    void testAllAbilitiesSupported() {
        VelocityMovable velocityMovable = mock(VelocityMovable.class);
        Rotatable rotatable = mock(Rotatable.class);
        when(velocityMovable.getVelocity()).thenReturn(new Vector(new int[]{5, 10}));
        when(rotatable.getAngularVelocity()).thenReturn(15);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(velocityMovable, rotatable);
        changeVelocityCommand.execute();
        verify(velocityMovable).getVelocity();
        verify(rotatable).getAngularVelocity();
        verify(velocityMovable).setVelocity(any());
    }

    @Test
    void testMovableIsNotSupported() {
        Rotatable rotatable = mock(Rotatable.class);
        VelocityMovable velocityMovable = mock(VelocityMovable.class);
        when(rotatable.getAngularVelocity()).thenReturn(15);
        when(velocityMovable.getVelocity()).thenReturn(null);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(velocityMovable, rotatable);
        changeVelocityCommand.execute();
        verify(rotatable).getAngularVelocity();
        verify(velocityMovable).setVelocity(any());
    }
}
