package task2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector {
    private int[] coordinates;

    public Vector sum(Vector v1, Vector v2) {
        int[] result = new int[v1.coordinates.length];
        for (int i = 0; i < result.length; i++)
            result[i] = v1.coordinates[i] + v2.coordinates[i];
        return new Vector(result);
    }
}
