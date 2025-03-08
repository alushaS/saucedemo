package pages;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Log4j2
public class ProductsPage extends HeaderPage{

    public static final By BOLT_T_SHIRT_ID = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By PRODUCT_FILTER = By.xpath("//*[@data-test='product-sort-container']");
    public static final By PRICE_LIST = By.xpath("//*[@data-test='inventory-item-price']");
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Add product to cart products page.
     *
     * @param productNames the product names
     * @return the products page
     */
    public ProductsPage addProductToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        log.info("Product {} added to cart", (Object) productNames);
        return this;
    }

    /**
     * Is add to cart button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * Sets prices from high to low.
     */
    public ProductsPage setPricesFromHighToLow() {
        Select select = new Select(driver.findElement(PRODUCT_FILTER));
        List<WebElement> optionsList = select.getOptions();
        WebElement highToLowOption = optionsList.get(2);
        highToLowOption.click();
        log.info("Prices were set from high to low");
        return this;
    }

    /**
     * Gets lowest price.
     *
     * @return the lowest price
     */
    public String getLowestPrice() {
        log.info("The lowest price is " + driver.findElements(PRICE_LIST).get(0).getText());
       return driver.findElements(PRICE_LIST).get(0).getText();
    }
}
