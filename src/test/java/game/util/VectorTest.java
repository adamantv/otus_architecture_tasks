package game.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VectorTest {
    @Test
    void testRotateCorrect() {
        Vector vector = new Vector(new int[]{5, 10});
        Vector v1 = vector.rotate(30);
        assertThat(v1).isNotNull();
        assertThat(v1.getCoordinates()).hasSize(2);
    }
}
