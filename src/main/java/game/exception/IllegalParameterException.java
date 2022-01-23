package game.exception;

public class IllegalParameterException extends RuntimeException {
    public IllegalParameterException(String parameter) {
        super(parameter);
    }
}

