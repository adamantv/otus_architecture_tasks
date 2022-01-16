package quadratic_equation;

public class IllegalCoefficientException extends RuntimeException {
    public IllegalCoefficientException(String coefficient, double parameter) {
        super("Invalid coefficient value for equation:" + coefficient + " = " + parameter);
    }
}
