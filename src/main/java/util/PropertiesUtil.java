package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
  private static final Properties PROPERTIES = new Properties();

  static {
    loadProperties();
  }

  public static String get(String key) {
    return PROPERTIES.getProperty(key);
  }

  private static void loadProperties() {
    InputStream resource = PropertiesUtil.class.getClassLoader()
            .getResourceAsStream("application.properties");
    try {
      PROPERTIES.load(resource);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
