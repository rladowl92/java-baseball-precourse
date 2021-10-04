package baseball.exception;

public class BaseballException extends IllegalArgumentException {
    public BaseballException() {
        super();
    }

    public BaseballException(String msg) {
        super("[ERROR] " + msg);
    }

    public BaseballException(String msg, Throwable cause) {
        super("[ERROR] " + msg, cause);
    }
}
