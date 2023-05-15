package pom.pages;

import pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"https://askomdch.com/checkout/\"]")
    private WebElement checkoutButton;



    private By validateProductName(String product) {
        return By.xpath("//a[text()=" + "'" + product + "'" + "]");
    }

    public String validateProduct(String product) {
        By by = validateProductName(product);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by))).getText();
    }

    public CheckOutPage clickCheckOutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckOutPage(driver);
    }

}
