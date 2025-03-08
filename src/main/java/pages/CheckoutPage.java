package pages;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends HeaderPage{

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Fill customer info checkout page.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param zipCode   the zip code
     * @return the checkout page
     */
    public CheckoutPage fillCustomerInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(zipCode);
        log.info("Customer info filled in: " + firstName + " " + lastName + ", zip code: " + zipCode );
        return new CheckoutPage(driver);
    }

    /**
     * Open checkout page checkout overview page.
     *
     * @return the checkout overview page
     */
    public CheckoutOverviewPage openCheckoutPage() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }
}
