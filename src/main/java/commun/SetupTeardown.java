package commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class SetupTeardown {

    public WebDriver driver;

    String browser = "edge";

    @BeforeMethod
    public void setup() throws MalformedURLException {

        //System.out.println(System.getProperty("user.dir"));
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\main\\resources\\chromedriver.exe");
/*
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.14:4449"), options);

        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "edge");
        //driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.14:4444"), options);
        driver = new EdgeDriver();

*/
        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            break;

        }

        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }



}
