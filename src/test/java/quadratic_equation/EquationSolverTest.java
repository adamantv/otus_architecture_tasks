package quadratic_equation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EquationSolverTest {
    private final EquationSolver equationSolver = new EquationSolver();
    private static final double EPSILON = 1e-7;

    @Test
    @DisplayName("Test for check if roots is not exist")
    public void rootsIsNotExist() {
        double[] roots = equationSolver.solve(1, 0, 1, EPSILON);
        Assertions.assertEquals(0, roots.length);
    }

    @Test
    @DisplayName("Test for check if exist two roots")
    public void existTwoRoots() {
        double[] roots = equationSolver.solve(1, 0, -1, EPSILON);
        Assertions.assertEquals(2, roots.length);
        Assertions.assertEquals(-1.0, roots[0]);
        Assertions.assertEquals(1.0, roots[1]);
    }

    @Test
    @DisplayName("Test for check if exist one root")
    public void existOneRoot() {
        double[] roots = equationSolver.solve(1, 2, 0.99999999999, EPSILON);
        Assertions.assertEquals(1, roots.length);
        Assertions.assertEquals(-1.0, roots[0]);
    }

    @Test
    @DisplayName("Test for check case if a = 0 ")
    public void checkIllegalCoefficientException() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(0, 2, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if a is NaN")
    public void checkAIsNan() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(Double.NaN, 2, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if a is NEGATIVE_INFINITY")
    public void checkAIsNegativeInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(Double.NEGATIVE_INFINITY, 2, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if a is POSITIVE_INFINITY")
    public void checkAIsPositiveInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(Double.POSITIVE_INFINITY, 2, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if b is NaN")
    public void checkBIsNan() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(1, Double.NaN, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if b is NEGATIVE_INFINITY")
    public void checkBIsNegativeInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(1, Double.NEGATIVE_INFINITY, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if b is POSITIVE_INFINITY")
    public void checkBIsPositiveInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(1, Double.POSITIVE_INFINITY, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if c is NaN")
    public void checkCIsNan() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(1, 2, Double.NaN, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if c is NEGATIVE_INFINITY")
    public void checkCIsNegativeInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(Double.NEGATIVE_INFINITY, 1, 1, EPSILON)
        );
    }

    @Test
    @DisplayName("Test for check if c is POSITIVE_INFINITY")
    public void checkCIsPositiveInfinity() {
        Assertions.assertThrows(
                IllegalCoefficientException.class,
                () -> equationSolver.solve(Double.POSITIVE_INFINITY, 1, 1, EPSILON)
        );
    }
}
