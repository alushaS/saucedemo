package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


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
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(ADDED_PRODUCT).getText();
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public List<WebElement> getProducts() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElements(PRODUCTS_LIST);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}
