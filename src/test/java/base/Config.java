package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {
    public static final String URL;
    public static final String BROWSER_NAME;

    static {
        URL = getUrl();
        BROWSER_NAME = getBrowserName();
    }
    private static String getUrl() {
        return loadProperties().getProperty("url");
    }

    private static String getBrowserName() {
        String browser = System.getenv("BROWSER");
        if(browser == null) {
            browser = "CHROME";
        }
        return browser;
    }

    private static Properties loadProperties() {
        String configFileName = "config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFileName);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + configFileName + "} conf file from classpath", ioe);
        }
        return properties;
    }
}