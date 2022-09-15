package test.java;



import main.java.amazon.CartPage;
import main.java.amazon.HomePage;

import main.java.commun.SetupTeardown;
import org.testng.Assert;

import org.testng.annotations.Test;



public class TpPageObjectTest extends SetupTeardown {

    @Test
    public void testPO() {
        // arrange
        final String keyword = "iPhone 13";

        // act
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.acceptCookie()
                .searchWithButton(keyword)
                .openSearchResult(0)
                .addToCart()
                .refuseAppleCare()
                .openCartPage();

        // assert
        Assert.assertEquals(cartPage.getSubTotal(), "1000");
    }

}