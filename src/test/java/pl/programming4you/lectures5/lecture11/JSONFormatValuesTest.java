package pl.programming4you.lectures5.lecture11;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONFormatValuesTest {
    @Test
    @DisplayName("Should return first 'y' value from JSON format")
    public void shouldReturnFirstYValue() throws JsonProcessingException {
        JSONFormatValues jsonFormatValues = new JSONFormatValues();
        assertEquals(2000, jsonFormatValues.getYearValueFromJSON("{\"d\":[{\"y\":2000},{\"y\":2001}]}"));
    }
}
