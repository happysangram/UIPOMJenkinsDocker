package pom.base;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.codehaus.groovy.runtime.WritableFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import pom.Factory.BrowserFactory;
import pom.Factory.DriverManager;
import pom.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    public static ITestResult result;

    protected ConfigLoader configLoader;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Parameters("browser")
    @BeforeMethod

    //browser using Testng parameter tag
    public void beforeSuite(String browser, ITestContext ctx) throws IOException {
        System.out.println("-------------------" + browser);
        // setDriver(new DriverManager().driverInstantiation(browser));
        setDriver(new BrowserFactory().selectBrowser(browser).createDriver(ctx));
        getDriver().get("https://askomdch.com/");
        getDriver().manage().window().maximize();
        System.out.println("Thread name: " + Thread.currentThread().getId());
        configLoader = ConfigLoader.getInstance();
        System.out.println("Thread name: " + Thread.currentThread().getId());
    }

    @Parameters("browser")
    @AfterMethod
    public void afterSuite(String browser, ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(100);

        if (result.getStatus() == ITestResult.FAILURE) {
            File descfile = new File("screenshots" + File.separator + browser + File.separator + result.getTestClass().getRealClass().getSimpleName() +
                    "_" + result.getMethod().getMethodName() + ".png");
            System.out.println(descfile);
            takeScreenshot(descfile);
        }
        getDriver().quit();
    }

    private void takeScreenshot(File desfile) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File actFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(actFile, desfile);

    }
}
