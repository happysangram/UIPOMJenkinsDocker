package pom.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader configLoader;
    public final Properties prop;
    private static String file = "Config.properties";

    private ConfigLoader() throws IOException {

        String env=System.getProperty("env");
        if(env==null) {
            env = "STAGE";
        }
        switch (env){
            case "STAGE"->{
              //  prop=new PropertiesReader().readPropertiesFile( getClass().getClassLoader().getResourceAsStream("Config.properties"));

                prop = new Properties();
                InputStream inputstream = getClass().getClassLoader().getResourceAsStream(file);
                prop.load(inputstream);

                System.out.println("STAGE"+"ooooooo22222222234567890");

            }
            case "TEST"->{
                prop=new PropertiesReader().readPropertiesFile("/Users/sangram.das/GIT/POMUIAutomation/src/test/resources/Config.properties");
                System.out.println("TEST"+"ooooooo22222222234567890");
            }
            default -> {
                System.out.println("PROD"+"ooooooo22222222234567890");
                throw new IllegalStateException("Environment is Invalid!!!");

            }
        }
    }
    public static ConfigLoader getInstance() throws IOException {
        if(configLoader==null){
            configLoader= new ConfigLoader();
        }
        return configLoader;
    }
}
