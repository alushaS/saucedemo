package pages;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * The type Cart page.
 */
@Log4j2
public class CartPage extends HeaderPage{
    public static final By ADDED_PRODUCT = By.xpath("//*[@data-test='inventory-item-name']");
    public static final By REMOVE_BOLT_T_SHIRT = By.id("remove-sauce-labs-bolt-t-shirt");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By PRODUCTS_LIST = By.className("inventory_item_name");
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String ADD_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName() {
        WebElement addedProduct = driver.findElement(ADDED_PRODUCT);
        log.info("Get product name: " + addedProduct.getText());
        return driver.findElement(ADDED_PRODUCT).getText();
    }

    /**
     * Remove product from cart header page.
     *
     * @param productName the product name
     * @return the header page
     */
    public HeaderPage removeProductFromCart(String productName) {
        log.info("Product " + productName + " is removed from cart");
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<WebElement> getProducts() {
        List<WebElement> list = driver.findElements(PRODUCTS_LIST);
        log.info("Get product list: " + list);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElements(PRODUCTS_LIST);
    }

    /**
     * Click continue button cart page.
     *
     * @return the cart page
     */
    public CartPage clickContinueButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return this;
    }

    /**
     * Click checkout button checkout page.
     *
     * @return the checkout page
     */
    public CheckoutPage clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName) {
        if (!driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty()){
            log.info("Product" + productName + " is not displayed on page");
        }
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}
