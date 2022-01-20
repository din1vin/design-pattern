package c02;

public final class IllegalTransactionException extends RuntimeException {
    public IllegalTransactionException(String message) {
        super(message);
    }

    public IllegalTransactionException() {
    }

    public IllegalTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
