package pom.Factory;

import pom.constants.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private WebDriver driver;

    public WebDriver driverInstantiation(String browser) {

       // String browser = System.getProperty("browser","CHROME");
        switch (BrowserType.valueOf( browser.toUpperCase())) {

            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }

            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            default -> {
                throw new IllegalStateException("Browser not found");
            }
        }
        return driver;
    }

    public WebDriver getDriver() {
        this.driver = driver;
        return driver;
    }
}

