package pom.pages;

import pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@class='woocommerce-product-search']//descendant::input[@type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//form[@class='woocommerce-product-search']//descendant::button")
    private WebElement searchButton;
    @FindBy(xpath = "//h1[@class='woocommerce-products-header__title page-title']")
    private WebElement seachTextField;
    // @FindBy(xpath = "//a[@href='?add-to-cart=1215']") private WebElement addToCartButton;
    @FindBy(xpath = "//a[@href='?add-to-cart=1215']//following-sibling::a")
    private WebElement addToCartLink;


    public StorePage loadPage(){
        Load("Store");
        return this;
    }
    public StorePage setSearchField(String searchFieldItem) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(searchFieldItem);
        return this;
    }

    public StorePage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public String getSearchText() {
        return wait.until(ExpectedConditions.visibilityOf(seachTextField)).getText();
    }

    private By getProductValue(String product) {
        return By.xpath("//a[@href='?add-to-cart=" + product + "']");
    }

    public StorePage clickAddToCartButton(String product) {
        By by = getProductValue(product);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
        return this;
    }

    private By getProductValueLink(String product) {
        return By.xpath("//a[@href='?add-to-cart=" + product + "']//following-sibling::a");
    }

    public CartPage clickAddToCartLink(String product) throws InterruptedException {
        Thread.sleep(5000);
        By by = getProductValueLink(product);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
        return new CartPage(driver);
    }

}
