package pl.programming4you.lectures5.lecture12.server;

public class CannotProcessJsonException extends Exception {
    public CannotProcessJsonException(String message) {
        super(message);
    }
}
