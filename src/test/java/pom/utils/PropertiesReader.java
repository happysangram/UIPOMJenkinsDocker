package pom.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public Properties readPropertiesFile(String filepath) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(filepath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
