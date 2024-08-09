package poo.exceptions;

public class RegisterDuplicateAccessDataException extends WriteAccessDataException {
    public RegisterDuplicateAccessDataException(String message) {
        super(message);
    }
}
