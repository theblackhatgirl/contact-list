package codeplays.trainee.contactlist.exception;

public class BadRequestException extends Exception {

    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
