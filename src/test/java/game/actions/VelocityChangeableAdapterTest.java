package game.actions;

import game.actions.change.velocity.VelocityChangeableAdapter;
import game.elements.UObject;
import game.util.Vector;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VelocityChangeableAdapterTest {
    @Test
    void checkVelocityChangeableAdapter() {
        UObject uObject = mock(UObject.class);
        VelocityChangeableAdapter velocityChangeableAdapter = new VelocityChangeableAdapter(uObject);
        Vector vector = new Vector(new int[]{5, 10});
        velocityChangeableAdapter.setVelocity(vector);
        verify(uObject).setProperty("velocity", vector);
    }
}
