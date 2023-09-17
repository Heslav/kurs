package pl.programming4you.lectures5.lecture11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieDetailsJSONMapperTest {
    @Test
    @DisplayName("Should return first y value from JSON format")
    public void shouldReturnFirstYValue() throws CannotGetValidJsonValueException {
        assertEquals(2000, new MovieDetailsJSONMapper().
                getYearReleased(new ByteArrayInputStream("{\"d\": [{\"y\": 2000}]}".getBytes())));
    }

    @Test
    @DisplayName("Should throw CannotGetValidJsonValueException when y value is not an int")
    public void shouldThrowExceptionWhenJsonValueIsString() {
        assertThrows(CannotGetValidJsonValueException.class, () -> new MovieDetailsJSONMapper().
                getYearReleased(new ByteArrayInputStream("{\"d\": [{\"y\": fifa}]}".getBytes())));
    }

    @Test
    @DisplayName("Should throw CannotGetValidJsonValueException when y value is empty")
    public void shouldThrowExceptionWhenJsonValueIsEmpty() {
        assertThrows(CannotGetValidJsonValueException.class, () -> new MovieDetailsJSONMapper().
                getYearReleased(new ByteArrayInputStream("{\"d\": [{\"y\":}]}".getBytes())));
    }

    @Test
    @DisplayName("Should throw CannotGetValidJsonValueException when json is null")
    public void shouldThrowExceptionWhenJsonValueIsInvalid() {
        assertThrows(CannotGetValidJsonValueException.class, () -> new MovieDetailsJSONMapper().
                getYearReleased(new ByteArrayInputStream("".getBytes())));
    }
}
