package pl.programming4you.lectures5.lecture11;

import java.util.Properties;

public interface TokenProvider {
    Properties readToken() throws ConfigurationException;
}
