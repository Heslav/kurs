package pl.programming4you.lectures5.lecture10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePropertiesProviderTest {
    @Test
    @DisplayName("Should return token and model from test.properties")
    public void testBreakfastIdeaFilePropertiesReader() throws ConfigurationException {
        Properties properties = new FilePropertiesProvider("test.properties").readProperties();
        assertEquals("testToken", properties.getProperty("token"));
        assertEquals("testModel", properties.getProperty("model"));
    }

    @Test
    @DisplayName("Should throw ConfigurationException when .properties file doesn't exist")
    public void testBreakfastIdeasFilePropertiesReaderWithoutFile() throws ConfigurationException {
        assertThrows(ConfigurationException.class, () ->
                new FilePropertiesProvider("noFile.properties").readProperties().getProperty("token"));
    }
}