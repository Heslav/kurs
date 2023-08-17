package pl.programming4you.lectures5.lecture11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileTokenProvider implements TokenProvider {
    private final String tokenPath;

    public FileTokenProvider(String tokenPath) {
        this.tokenPath = tokenPath;
    }

    @Override
    public Properties readToken() throws ConfigurationException {
        Properties properties = new Properties();
        try (InputStream inputStream = FileTokenProvider.class.getClassLoader().getResourceAsStream(tokenPath)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new ConfigurationException("Cannot find .properties file in " + tokenPath + ". Ensure that file exists");
            }
            return properties;
        } catch (IOException e) {
            throw new ConfigurationException("Cannot read properties.");
        }
    }
}
