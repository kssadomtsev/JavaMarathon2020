package FinalProject.exceptions;

import java.util.InputMismatchException;

public class NonCoordinateException extends InputMismatchException {
    public NonCoordinateException() {
        super("Input is not in valid coordinate format. Valid format is 0-9,0-9");
    }

    public NonCoordinateException(String message) {
        super(message);
    }
}
