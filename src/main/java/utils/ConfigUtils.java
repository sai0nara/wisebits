package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ConfigUtils {
    public static final String baseUrl;

    static {
        String propsFileName = "default.properties";
        Properties props = loadProps(propsFileName);
        baseUrl = props.getProperty("base.url");
    }


    private static Properties loadProps(String filename) {
        Properties properties = new Properties();
        URL resource = ConfigUtils.class.getClassLoader().getResource(filename);
        if (resource == null)
            throw new RuntimeException(String.format("Can't find file \"%s\" in resource directory", filename));
        try (InputStream configInputStream = new FileInputStream(new File(resource.toURI()))) {
            properties.load(configInputStream);
            properties.forEach((k, v) -> {
                if (System.getProperty(k.toString()) != null) properties.setProperty(k.toString(), System.getProperty(k.toString()));
            });
            return properties;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Can't load configuration file from resource file: " + filename, e);
        }
    }
}
