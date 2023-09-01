package pl.programming4you.lectures5.lecture11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IMDBClient implements MovieDetailsApi {
    private final MovieDetailsJSONMapper movieDetailsJSONMapper;
    private final String imdbToken;
    private final HttpClient httpClient;

    public IMDBClient(MovieDetailsJSONMapper movieDetailsJSONMapper, String imdbToken) {
        this.movieDetailsJSONMapper = movieDetailsJSONMapper;
        this.imdbToken = imdbToken;
        this.httpClient = HttpClient.newHttpClient();
    }

    IMDBClient(MovieDetailsJSONMapper movieDetailsJSONMapper, String imdbToken, HttpClient httpClient) {
        this.movieDetailsJSONMapper = movieDetailsJSONMapper;
        this.imdbToken = imdbToken;
        this.httpClient = httpClient;
    }

    @Override
    public Integer getReleaseYear(String movieTitle) throws CannotGetMovieInfoException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=" + movieTitle.replace(" ", "")))
                    .GET()
                    .header("X-RapidAPI-Key", imdbToken)
                    .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                    .build();
            return movieDetailsJSONMapper.getYearReleased(httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream()).body());
        } catch (InterruptedException | IOException | CannotGetValidJsonValueException e) {
            throw new CannotGetMovieInfoException("Something went wrong while connecting with IMDB API. " +
                    "Make sure your api key is still valid and your internet connection is good", e);
        }
    }
}
