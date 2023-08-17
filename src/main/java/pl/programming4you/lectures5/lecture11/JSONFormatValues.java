package pl.programming4you.lectures5.lecture11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFormatValues {
    public Integer getYearValueFromJSON(String source) throws JsonProcessingException {
        return new ObjectMapper().readTree(source).get("d").get(0).get("y").asInt();
    }
}
