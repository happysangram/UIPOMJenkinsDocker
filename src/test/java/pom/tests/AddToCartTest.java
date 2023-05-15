package pom.tests;

import org.testng.annotations.DataProvider;
import pom.Objects.ProductPojo;
import pom.Objects.Products;
import pom.base.BaseTest;
import pom.pages.CartPage;
import pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.utils.jacksonUtils;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartProduct() throws InterruptedException, IOException {

        Products products = new Products(1215);
        StorePage storePage = new StorePage(getDriver())
                .loadPage()
                .setSearchField("Blue")
                .clickSearchButton();
        CartPage cart = storePage
                .clickAddToCartButton("1215")
                .clickAddToCartLink("1215");
        Assert.assertEquals(cart.validateProduct("Blue Shoes"), products.getName());
    }



}
