package game.actions;

import game.actions.movement.VelocityMovableAdapter;
import game.elements.UObject;
import game.util.Vector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class VelocityMovableAdapterTest {
    @Test
    void checkVelocityChange() {
        UObject uObject = mock(UObject.class);
        VelocityMovableAdapter velocityMovableAdapter = new VelocityMovableAdapter(uObject);
        Vector vector = new Vector(new int[]{5, 10});
        velocityMovableAdapter.setVelocity(vector);
        verify(uObject).setProperty("velocity", vector);
    }

    @Test
    void checkGetVelocity() {
        UObject uObject = mock(UObject.class);
        Vector vector = new Vector(new int[]{5, 10});
        when(uObject.getProperty(Vector.class, "velocity")).thenReturn(vector);
        VelocityMovableAdapter velocityMovableAdapter = new VelocityMovableAdapter(uObject);
        Vector velocity = velocityMovableAdapter.getVelocity();
        verify(uObject).getProperty(Vector.class, "velocity");
        assertThat(velocity).isEqualTo(vector);
    }

    @Test
    void checkPositionChange() {
        UObject uObject = mock(UObject.class);
        VelocityMovableAdapter velocityMovableAdapter = new VelocityMovableAdapter(uObject);
        Vector vector = new Vector(new int[]{5, 10});
        velocityMovableAdapter.setPosition(vector);
        verify(uObject).setProperty("position", vector);
    }

    @Test
    void checkGetPosition() {
        UObject uObject = mock(UObject.class);
        Vector vector = new Vector(new int[]{5, 10});
        when(uObject.getProperty(Vector.class, "position")).thenReturn(vector);
        VelocityMovableAdapter velocityMovableAdapter = new VelocityMovableAdapter(uObject);
        Vector velocity = velocityMovableAdapter.getPosition();
        verify(uObject).getProperty(Vector.class, "position");
        assertThat(velocity).isEqualTo(vector);
    }
}
