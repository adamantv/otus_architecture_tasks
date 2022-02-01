package game.util;

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

    public Vector rotate(int angle) {
        double angleInRadian = angle * Math.PI / 180;
        int[] resultCoordinates = new int[2];
        resultCoordinates[0] = (int) Math.round(coordinates[0] * Math.cos(angleInRadian) - coordinates[1] * Math.sin(angleInRadian));
        resultCoordinates[1] = (int) Math.round(coordinates[0] * Math.sin(angleInRadian) + coordinates[1] * Math.cos(angleInRadian));
        return new Vector(resultCoordinates);
    }
}
