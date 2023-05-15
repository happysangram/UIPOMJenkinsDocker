package pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitShort;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void waitForOverLayToDisappear(By by){
        List<WebElement> overlay= driver.findElements(by);
        System.out.println(overlay.size());
        if(overlay.size()>0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlay));
        }
    }

    public void Load(String url){
        driver.get("https://askomdch.com/"+url);
    }
}
