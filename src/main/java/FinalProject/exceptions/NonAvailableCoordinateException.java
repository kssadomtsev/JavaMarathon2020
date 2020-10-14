package FinalProject.exceptions;

import java.util.InputMismatchException;

public class NonAvailableCoordinateException extends InputMismatchException {
    private String reason;

    public NonAvailableCoordinateException(String message) {
        super(message);
        reason = message;
    }
}
