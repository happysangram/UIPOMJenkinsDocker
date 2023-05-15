package pom.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pom.constants.BrowserType;

public class BrowserFactory {

    public static DriverFactory selectBrowser(String browser){

        switch (BrowserType.valueOf( browser.toUpperCase())){

            case CHROME -> {
               //return new ChromeDriverFactory();

                return  new ChromeDriverFactory();
            }

            case FIREFOX -> {
                return new FirefoxDriverFactory();
            }
            default -> {
                throw new IllegalStateException("Browser not found");
            }

        }
    }
}
