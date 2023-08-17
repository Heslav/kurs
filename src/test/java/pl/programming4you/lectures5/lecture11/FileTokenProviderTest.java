package pl.programming4you.lectures5.lecture11;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileTokenProviderTest {
    @Test
    @DisplayName("Should return token from test.properties file")
    public void testFileTokenProviderGettingToken() throws ConfigurationException {
        FileTokenProvider fileTokenProvider = new FileTokenProvider("test.properties");
        assertEquals("testToken", fileTokenProvider.readToken().getProperty("token"));
    }

    @Test
    @DisplayName("Should throw ConfigurationException when properties file doesn't exist")
    public void testFileTokenProviderWithNoFile() {
        FileTokenProvider fileTokenProvider = new FileTokenProvider("noFile.properties");
        assertThrows(ConfigurationException.class, fileTokenProvider::readToken);
    }
}
