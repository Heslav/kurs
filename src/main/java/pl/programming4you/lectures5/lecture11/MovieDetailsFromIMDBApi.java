package pl.programming4you.lectures5.lecture11;

public interface MovieDetailsFromIMDBApi {
    Integer getYearOfMade() throws InvalidMovieTitleException, ConfigurationException, CustomInterruptedException;
}
