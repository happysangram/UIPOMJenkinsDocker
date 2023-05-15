package pom.pages;

import pom.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Checkout']")
    private WebElement pageTitle;

    public String checkTitle() {
        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();
    }
}
