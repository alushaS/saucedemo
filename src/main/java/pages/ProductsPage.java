package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

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

    public void addProductToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
    }

    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public void setPricesFromHighToLow() {
        Select select = new Select(driver.findElement(PRODUCT_FILTER));
        List<WebElement> optionsList = select.getOptions();
        WebElement highToLowOption = optionsList.get(2);
        highToLowOption.click();
    }

    public String getLowestPrice() {
       return driver.findElements(PRICE_LIST).getFirst().getText();
    }
}
