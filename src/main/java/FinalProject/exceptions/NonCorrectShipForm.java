package FinalProject.exceptions;

import java.util.InputMismatchException;

public class NonCorrectShipForm extends InputMismatchException {
    public NonCorrectShipForm() {
        super("Provided coordinates cannot be used to construct correct ship form");
    }

    public NonCorrectShipForm(String message) {
        super(message);
    }
}
