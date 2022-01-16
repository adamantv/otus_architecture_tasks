package quadratic_equation;

public class EquationSolver {
    public double[] solve(double a, double b, double c, double eps) {
        if (Double.isNaN(a) || a == Double.NEGATIVE_INFINITY || a == Double.POSITIVE_INFINITY) {
            throw new IllegalCoefficientException("a", a);
        }
        if (Double.isNaN(b) || b == Double.NEGATIVE_INFINITY || b == Double.POSITIVE_INFINITY) {
            throw new IllegalCoefficientException("b", b);
        }
        if (Double.isNaN(c) || c == Double.NEGATIVE_INFINITY || c == Double.POSITIVE_INFINITY) {
            throw new IllegalCoefficientException("c", c);
        }
        double d = b * b - 4 * a * c;
        if (Math.abs(a) < eps) {
            throw new IllegalCoefficientException("a", a);
        } else {
            if (d > eps) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
                return new double[]{x1, x2};
            } else if (Math.abs(d) <= eps) {
                double x = -b / (2 * a);
                System.out.println("Уравнение имеет единственный корень: x = " + x);
                return new double[]{x};
            } else {
                System.out.println("Уравнение не имеет действительных корней");
                return new double[0];
            }
        }
    }
}
