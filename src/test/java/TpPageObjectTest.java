import amazon.CartPage;
import amazon.HomePage;
import commun.SetupTeardown;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

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