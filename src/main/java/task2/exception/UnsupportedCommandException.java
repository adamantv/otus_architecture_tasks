package task2.exception;

public class UnsupportedCommandException extends RuntimeException {
    public UnsupportedCommandException(String parameter) {
        super(parameter);
    }
}

