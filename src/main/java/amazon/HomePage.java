package amazon;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");

    private By searchBarSelector = By.cssSelector("[aria-label=Rechercher]");
    private By searchButtonSelector = By.cssSelector("[type=submit]");

    private static final Logger Log = LogManager.getLogger(HomePage.class);

    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage acceptCookie() {

        Log.info("J'accepte les cookies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    public amazon.SearchResultPage searchWithButton(String keyword) {

        Log.info("Je cherche avec le bouton de recherche");
        WebElement searchBar = driver.findElement(searchBarSelector);
        searchBar.sendKeys(keyword);

        WebElement loupeButton = driver.findElement(searchButtonSelector);
        loupeButton.click();

        return new amazon.SearchResultPage(driver);
    }
}