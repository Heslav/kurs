package pl.programming4you.lectures5.lecture10;

import java.io.IOException;
import java.util.Properties;

public interface PropertiesProvider {
    Properties readProperties() throws ConfigurationException;
}
