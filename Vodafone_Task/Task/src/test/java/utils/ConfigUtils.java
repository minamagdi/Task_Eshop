package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    public static Properties readDataFromPropertyFile() {
        File file = new File("src/test/resources/data.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }
}
