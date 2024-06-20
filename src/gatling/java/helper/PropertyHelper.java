package helper;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class PropertyHelper {

    public static String getProperty(String propertyName, String defaultValue) {
        Config settings = ConfigFactory.load();
        return System.getenv().getOrDefault(propertyName, settings.getString(defaultValue));
    }

    public static void setProperty(String propertyName, String value) {
        System.setProperty(propertyName, value);
    }
}
