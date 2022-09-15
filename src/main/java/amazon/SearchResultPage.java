package amazon;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    private WebDriver driver;
    private By productImageSelector = By.cssSelector("img.s-image");

    private static final Logger Log = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openSearchResult(int index) {

        Log.info("Je suis sur la page de résultat");
        List<WebElement> resultatList = driver.findElements(productImageSelector);
        resultatList.get(index).click();
        return new ProductPage(driver);
    }
}