package task2.exception;

public class IllegalPropertyTypeException extends RuntimeException {
    public <T> IllegalPropertyTypeException(Class<T> cls, String parameter) {
        super("Illegal type " + cls + " for parameter " + parameter);
    }
}

