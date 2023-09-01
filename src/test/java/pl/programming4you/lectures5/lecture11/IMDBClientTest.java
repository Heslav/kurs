package pl.programming4you.lectures5.lecture11;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IMDBClientTest {
    @Test
    @DisplayName("Should return year of made of a movie")
    public void shouldReturnIntegerYearValue() throws IOException, InterruptedException, CannotGetMovieInfoException,
            CannotGetValidJsonValueException {

        HttpResponse<InputStream> httpResponse = mock(HttpResponse.class);
        HttpClient httpClient = mock(HttpClient.class);
        MovieDetailsJSONMapper movieDetailsJSONMapper = mock(MovieDetailsJSONMapper.class);

        when(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofInputStream()))).thenReturn(httpResponse);
        when(httpResponse.body()).thenReturn(new ByteArrayInputStream("{\"d\": [{\"y\": 2000}]}".getBytes()));
        when(movieDetailsJSONMapper.getYearReleased(any(InputStream.class))).thenReturn(2000);

        IMDBClient imdbClient = new IMDBClient(movieDetailsJSONMapper, "testToken", httpClient);
        assertEquals(2000, imdbClient.getReleaseYear("testTitle"));
    }

    @Test
    @DisplayName("Should throw exception when cannot get movie release year")
    public void shouldThrowException() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        when(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofInputStream()))).thenThrow(IOException.class);
        IMDBClient imdbClient = new IMDBClient(new MovieDetailsJSONMapper(), "testToken", httpClient);
        assertThrows(CannotGetMovieInfoException.class, () -> imdbClient.getReleaseYear("testTitle"));
    }
}
