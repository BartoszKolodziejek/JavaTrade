package exception;

public class SendingException extends Exception {
    public SendingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SendingException(String message) {
        super(message);
    }
}
