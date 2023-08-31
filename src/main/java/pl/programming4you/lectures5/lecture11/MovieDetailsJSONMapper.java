package pl.programming4you.lectures5.lecture11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class MovieDetailsJSONMapper {
    public Integer getYearReleased(InputStream json) throws IOException {
        return new ObjectMapper().readTree(json).get("d").get(0).get("y").asInt();
    }
}
