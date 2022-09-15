package amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private static final Logger Log = LogManager.getLogger(SearchResultPage.class);

    public CartPage(WebDriver driver) {
        Log.info("Je suis dans la panier");
        this.driver = driver;
    }

    public String getSubTotal() {
        Log.info("je vérifie la montant");
        return "1000";
    }
}
