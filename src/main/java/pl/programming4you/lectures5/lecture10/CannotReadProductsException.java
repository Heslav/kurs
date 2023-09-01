package pl.programming4you.lectures5.lecture10;

public class CannotReadProductsException extends Exception {
    public CannotReadProductsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotReadProductsException(String message) {
        super(message);
    }
}
