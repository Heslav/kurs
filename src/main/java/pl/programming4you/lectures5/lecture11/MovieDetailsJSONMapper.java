package pl.programming4you.lectures5.lecture11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class MovieDetailsJSONMapper {
    public Integer getYearReleased(InputStream json) throws CannotGetValidJsonValueException {
        try {
            return new ObjectMapper().readTree(json).get("d").get(0).get("y").asInt();
        } catch (IOException | NullPointerException e) {
            throw new CannotGetValidJsonValueException("Sorry, couldn't get valid year value from IMDB api.", e);
        }
    }
}
