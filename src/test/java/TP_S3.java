import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TP_S3 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement clickBar = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
        clickBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-component-type='s-search-result']")));

        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        productList.get(1).click();

        WebElement panierButton = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        panierButton.click();

        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonmerci.click();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    public void teardown1() {
        driver.quit();
    }
}
