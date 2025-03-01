package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Checkout overview page.
 */
public class CheckoutOverviewPage extends HeaderPage{
    /**
     * The constant FINISH_BUTTON.
     */
    public static final By FINISH_BUTTON = By.id("finish");

    /**
     * Instantiates a new Checkout overview page.
     *
     * @param driver the driver
     */
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open checkout complete page.
     */
    public void openCheckoutCompletePage() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
