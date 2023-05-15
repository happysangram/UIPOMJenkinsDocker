package pom.Factory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.net.MalformedURLException;

public interface DriverFactory {

    WebDriver createDriver(ITestContext ctx) throws MalformedURLException;
}
