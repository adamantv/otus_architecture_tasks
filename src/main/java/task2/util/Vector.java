package task2.util;

import java.util.Arrays;

public class Vector {
    int[] coordinates;

    public Vector(int... coordinates) {
        this.coordinates = coordinates;
    }

    public static Vector sum(Vector v1, Vector v2) {
        int[] result = new int[v1.coordinates.length];
        for (int i = 0; i < result.length; i++)
            result[i] = v1.coordinates[i] + v2.coordinates[i];
        return new Vector(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(coordinates, vector.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
