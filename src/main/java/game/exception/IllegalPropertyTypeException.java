package game.exception;

public class IllegalPropertyTypeException extends RuntimeException {
    public IllegalPropertyTypeException(Class<?> cls, String parameter) {
        super("Illegal type " + cls + " for parameter " + parameter);
    }
}

