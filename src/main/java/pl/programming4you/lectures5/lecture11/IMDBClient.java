package pl.programming4you.lectures5.lecture11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.Scanner;

public class IMDBClient implements MovieDetailsFromIMDBApi {
    private final JSONFormatValues JSONFormatValues;
    private final Properties properties;
    private String movieTitle;

    public IMDBClient(JSONFormatValues JSONFormatValues,
                      FileTokenProvider fileTokenProvider, String movieTitle) throws ConfigurationException {
        this.JSONFormatValues = JSONFormatValues;
        this.properties = fileTokenProvider.readToken();
        this.movieTitle = movieTitle;
    }

    @Override
    public Integer getYearOfMade() throws CustomInterruptedException, ConfigurationException, InvalidMovieTitleException {
        System.out.println("Enter a movie title to check its year of production: ");
        movieTitle = new Scanner(System.in).nextLine();

        if (movieTitle.isEmpty() || movieTitle == null) {
            throw new InvalidMovieTitleException("Movie title cannot be null or empty. Type something.");
        }

        try {
            return JSONFormatValues.getYearValueFromJSON(HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=" + movieTitle.replace(" ", "")))
                    .header("X-RapidAPI-Key", properties.getProperty("token"))
                    .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (IOException e) {
            throw new ConfigurationException("Cannot read properties.");
        } catch (InterruptedException e) {
            throw new CustomInterruptedException("Something went wrong while connecting with IMDB API. " +
                    "Make sure your api key is still valid and your internet connection is good");
        }
    }
}
