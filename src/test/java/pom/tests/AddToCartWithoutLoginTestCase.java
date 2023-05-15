package pom.tests;

import pom.Objects.BillingAddress;
import pom.Objects.Products;
import pom.base.BaseTest;
import pom.pages.*;
import pom.utils.ConfigLoader;
import pom.utils.jacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartWithoutLoginTestCase extends BaseTest {


    @Test
    public void withoutLogin() throws InterruptedException, IOException {
        BillingAddress billingAddress;
//        InputStream is=getClass().getClassLoader().getResourceAsStream("BillingDetails.json");
//        billingAddress= jacksonUtils.DeserializeJson(is,billingAddress);

        billingAddress= jacksonUtils.DeserializeJsonGneric("BillingDetails.json",BillingAddress.class);
//        BillingAddress billingAddress = new BillingAddress("Sangram", "Das", "Bangalore",
//                "Bangalore", "90011", "sad@gmail.com");
        Products products=new Products(1215);
        HomePage home = new HomePage(getDriver());
        StorePage store = home.clickStoreLink();
        store.setSearchField("Blue").clickSearchButton();
//        Assert.assertEquals(store.getSearchText(),
//                "Search results: “Blue”");

        Assert.assertTrue(store.getSearchText().contains("Blue"));
        CartPage cart = store.clickAddToCartButton("1215").clickAddToCartLink("1215");

       Assert.assertEquals(cart.validateProduct("Blue Shoes"), products.getName());

        CheckOutPage checkOutPage = cart.clickCheckOutBtn();
        checkOutPage.setBillingAddressWithPojo(billingAddress);
        //checkOutPage.selectPaymentMenthod();
        OrderPage orderPage = checkOutPage.clickBtn();
        Assert.assertEquals(orderPage.checkTitle(), "Checkout");

    }

    @Test(priority = 2)
    public void withLogin() throws InterruptedException, IOException {

        Products products=new Products(1196);
        HomePage home = new HomePage(getDriver());
        StorePage store = home.clickStoreLink();
        store.setSearchField("Blue").clickSearchButton();
//        Assert.assertEquals(store.getSearchText(),
//                "Search results: “Blue”");
        Assert.assertTrue(store.getSearchText().contains("Blue"));
        CartPage cart = store.clickAddToCartButton("1196").clickAddToCartLink("1196");
        Assert.assertEquals(cart.validateProduct("Blue Tshirt"), products.getName());

        CheckOutPage checkOutPage = cart.clickCheckOutBtn();
        checkOutPage.clickLoginBtn();
        checkOutPage.setCredential(ConfigLoader.getInstance().prop.getProperty("username"), configLoader.prop.getProperty("password"))
        .setBillingAddress("Sangram", "Das", "Bangalore",
                "Bangalore", "560037", "sad@gmail.com","India","Karnataka");
        OrderPage orderPage = checkOutPage.clickBtn();
        Assert.assertEquals(orderPage.checkTitle(), "Checkout");

    }
}
