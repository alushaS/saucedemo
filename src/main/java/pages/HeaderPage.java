package pages;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Header page.
 */
@Log4j2
public class HeaderPage extends BasePage{
    /**
     * The constant CART_BUTTON.
     */
    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");

    /**
     * Instantiates a new Header page.
     *
     * @param driver the driver
     */
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open cart page.
     *
     * @return the cart page
     */
    public CartPage openCart() {
        driver.findElement(CART_BUTTON).click();
        log.info("Cart page opened");
        return new CartPage(driver);
    }
}
