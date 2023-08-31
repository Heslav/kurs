package pl.programming4you.lectures5.lecture11;

public interface MovieDetailsApi {
    Integer getReleaseYear(String movieTitle) throws CannotGetMovieInfoException;
}
