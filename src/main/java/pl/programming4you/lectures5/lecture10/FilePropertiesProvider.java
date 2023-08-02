package pl.programming4you.lectures5.lecture10;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class FilePropertiesProvider implements PropertiesProvider {

    private final String propertiesPath;

    public FilePropertiesProvider(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }

    @Override
    public Properties readProperties() throws ConfigurationException {
        Properties properties = new Properties();
        try (InputStream inputStream = FilePropertiesProvider.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new ConfigurationException("Cannot find .properties file in " + propertiesPath + ". Ensure that file exists");
            }
            return properties;
        } catch (IOException e) {
            throw new ConfigurationException("Cannot read properties");
        }
    }
}
