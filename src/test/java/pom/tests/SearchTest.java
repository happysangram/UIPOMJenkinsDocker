package pom.tests;

import pom.base.BaseTest;
import pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test
    public void SearchPartialText(){
        StorePage storePage= new StorePage(getDriver()).loadPage();
        storePage.setSearchField("Blue").clickSearchButton();
        Assert.assertTrue(storePage.getSearchText().contains("Blue"));
    }
}
