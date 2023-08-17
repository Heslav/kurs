package pl.programming4you.lectures5.lecture11;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IMDBClientTest {
    @Test
    @DisplayName("Should return year of made of a movie")
    public void shouldReturnIntegerYearValue() throws ConfigurationException, JsonProcessingException, CustomInterruptedException, InvalidMovieTitleException {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("Shrek");

        JSONFormatValues jsonFormatValues = mock(JSONFormatValues.class);
        String source = "testJson";
        when(jsonFormatValues.getYearValueFromJSON(source)).thenReturn(2000);

        Properties properties = mock(Properties.class);
        when(properties.getProperty("testToken")).thenReturn("testToken");

        FileTokenProvider fileTokenProvider = mock(FileTokenProvider.class);
        when(fileTokenProvider.readToken()).thenReturn(properties);


        IMDBClient imdbClient = new IMDBClient(jsonFormatValues, fileTokenProvider, "");
        assertEquals(2000, imdbClient.getYearOfMade());
        

    }
}
