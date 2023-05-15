package pom.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import pom.base.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverFactory implements DriverFactory {
    @Override
    public WebDriver createDriver(ITestContext ctx) throws MalformedURLException {


//       return WebDriverManager.chromedriver()
//               .capabilities(new ChromeOptions()
//                       .addArguments("--remote-allow-origins=*"))
//               .create();

        String host = "localhost";
       // String host ="192.168.1.8";
        MutableCapabilities dc;
        dc = new ChromeOptions();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", ctx.getCurrentXmlTest().getName());
        WebDriver driver = new RemoteWebDriver(new URL(completeUrl), dc);

        return driver;
    }
}
