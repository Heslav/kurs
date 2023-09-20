package pl.programming4you.lectures5.lecture12.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import pl.programming4you.lectures5.lecture12.movies.Movie;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class MyHttpHandler implements HttpHandler {
    private static final Logger logger = Logger.getLogger(MyHttpHandler.class.getName());
    private final Map<Integer, Movie> movies = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private int lastId = 1;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Movie returnedMovie = null;
        String errorMessage = null;
        try {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                returnedMovie = handleGetRequest(httpExchange);
            } else if ("POST".equals(httpExchange.getRequestMethod())) {
                returnedMovie = handlePostRequest(httpExchange);
            } else {
                errorMessage = "This HTTP method is not allowed.";
            }

        } catch (CannotProcessJsonException | MovieNotFoundException e) {
            errorMessage = e.getMessage();
        }
        handleResponse(httpExchange, returnedMovie, errorMessage);
    }

    private Movie handlePostRequest(HttpExchange httpExchange) throws CannotProcessJsonException, IOException {
        try {
            Movie movie = objectMapper.readValue(httpExchange.getRequestBody(), Movie.class);
            int id = lastId++;
            Movie movieWithId = new Movie(id, movie.name(), movie.movieType(), movie.releaseYear(), movie.rating());
            movies.put(id, movieWithId);
            logger.info("Saved movie " + movieWithId);
            return movieWithId;
        } catch (JsonProcessingException e) {
            throw new CannotProcessJsonException("Cannot properly process Json content.");
        } catch (IOException e) {
            throw new IOException("Something went wrong during reading request body.");
        }
    }

    private Movie handleGetRequest(HttpExchange httpExchange) throws MovieNotFoundException {
        String requestUri = httpExchange.getRequestURI().toString();
        Integer id = Integer.parseInt(requestUri.substring(requestUri.lastIndexOf('/') + 1));
        Movie movie = movies.get(id);
        if (movie == null) {
            throw new MovieNotFoundException("Sorry, couldn't find a movie. Our data base currently has a size of: "
                    + movies.size());
        }
        return movie;
    }

    private void handleResponse(HttpExchange httpExchange, Movie movie, String errorMessage) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String response;
        int responseCode;
        int responseLength;

        if (Objects.equals(errorMessage, "HTTP method not allowed")) {
            responseCode = 405;
            response = errorMessage;
            responseLength = response.length();
        } else if (errorMessage != null) {
            responseCode = 400;
            response = errorMessage;
            responseLength = response.length();
        } else {
            if (movie == null) {
                responseCode = 404;
                response = null;
                responseLength = 0;
            } else {
                responseCode = 200;
                response = objectMapper.writeValueAsString(movie);
                responseLength = response.length();
            }
        }
        httpExchange.sendResponseHeaders(responseCode, responseLength);
        if (response != null) {
            outputStream.write(response.getBytes());
        }
        outputStream.flush();
    }
}
