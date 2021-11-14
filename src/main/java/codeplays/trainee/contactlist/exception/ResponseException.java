package codeplays.trainee.contactlist.exception;

public class ResponseException {

    private String errorMessage;

    public ResponseException() {
    }

    public ResponseException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
