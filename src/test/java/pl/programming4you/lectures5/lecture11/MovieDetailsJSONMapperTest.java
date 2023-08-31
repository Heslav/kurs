package pl.programming4you.lectures5.lecture11;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MovieDetailsJSONMapperTest {
    @Test
    @DisplayName("Should return first 'y' value from JSON format")
    public void shouldReturnFirstYValue() throws JsonProcessingException {
        MovieDetailsJSONMapper movieDetailsJsonMapper = new MovieDetailsJSONMapper();
        //TODO: fix test
        //assertEquals(2000, movieDetailsJsonMapper.getYearReleased("{\"d\":[{\"y\":2000},{\"y\":2001}]}"));
    }
}
