package pl.programming4you.lectures5.lecture12.server;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
