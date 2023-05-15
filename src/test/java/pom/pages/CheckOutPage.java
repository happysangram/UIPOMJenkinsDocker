package pom.pages;

import pom.Objects.BillingAddress;
import pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"billing_first_name\"]")
    private WebElement fname;
    @FindBy(xpath = "//input[@id=\"billing_last_name\"]")
    private WebElement lname;

    @FindBy(xpath = "//input[@id=\"billing_address_1\"]")
    private WebElement add;
    @FindBy(xpath = "//input[@id=\"billing_city\"]")
    private WebElement city;

    @FindBy(xpath = "//input[@id=\"billing_postcode\"]")
    private WebElement postalCode;
    @FindBy(xpath = "//input[@id=\"billing_email\"]")
    private WebElement email;

    @FindBy(xpath = "//button[@id=\"place_order\"]")
    private WebElement placeOrderBtn;

    @FindBy(className = "showlogin")
    private WebElement loginBtn;
    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement uname;
    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//select[@id='billing_country']")
    @CacheLookup private WebElement selectCountry;

    @FindBy(xpath = "//select[@id='billing_state']")
    private WebElement selectState;

    @FindBy(xpath = "//input[@id='payment_method_cod']")
           private WebElement paymentbtn;

    String overlay="//div[@class='blockUI blockOverlay']";

    public CheckOutPage selectPaymentMenthod(){
       WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(paymentbtn));
       if(!ele.isSelected())
           ele.click();

       return this;
    }


    public CheckOutPage selectCountry(String country){
//        Select select=new Select(selectCountry);
//        select.selectByVisibleText(country);
        return this;
    }

    public CheckOutPage selectState(String state){
//        Select select=new Select(selectState);
//        select.selectByVisibleText(state);
        return this;
    }

    public CheckOutPage setUname(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(uname)).sendKeys(username);
        return this;
    }

    public CheckOutPage setPassword(String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
        return this;
    }

    public OrderPage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return new OrderPage(driver);
    }

    public CheckOutPage setCredential(String uname, String password) {
        return setUname(uname)
                .setPassword(password);
    }


    public CheckOutPage setFname(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(fname)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(fname)).sendKeys(firstName);
        return this;
    }

    public CheckOutPage setLname(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lname)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(lname)).sendKeys(lastName);
        return this;
    }

    public CheckOutPage setAddress(String address) {
        wait.until(ExpectedConditions.elementToBeClickable(add)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(add)).sendKeys(address);
        return this;
    }

    public CheckOutPage setCity(String cityName) {
        wait.until(ExpectedConditions.elementToBeClickable(city)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(cityName);
        return this;
    }

    public CheckOutPage setZip(String postCode) {
        wait.until(ExpectedConditions.elementToBeClickable(postalCode)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(postalCode)).sendKeys(postCode);
        return this;
    }

    public CheckOutPage setEmail(String emailId) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(emailId);
        return this;
    }

    public OrderPage clickBtn() {
        waitForOverLayToDisappear(By.xpath(overlay));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return new OrderPage(driver);
    }

    public CheckOutPage setBillingAddress(String fname, String lname, String address, String city, String zip, String email,String country,String state) {

        return setFname(fname)
                .setLname(lname)
                .setAddress(address)
                .setCity(city)
                .setZip(zip)
                .setEmail(email)
                .selectCountry(country)
                .selectState(state);
    }

    public CheckOutPage setBillingAddressWithPojo(BillingAddress billingAddress) {

        return setFname(billingAddress.getFname())
                .setLname(billingAddress.getLname())
                .setAddress(billingAddress.getAddress())
                .setCity(billingAddress.getCity())
                .setZip(billingAddress.getZip())
                .setEmail(billingAddress.getEmail())
                .selectCountry(billingAddress.getCountry())
                .selectState(billingAddress.getState());

    }


}
