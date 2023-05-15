package pom.tests;

import pom.base.BaseTest;
import pom.pages.HomePage;
import pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() throws IOException {
        HomePage home = new HomePage(getDriver());
        StorePage store = home.clickStoreLink();
        Assert.assertTrue(store.getSearchText().contains("Store"));
    }
}
