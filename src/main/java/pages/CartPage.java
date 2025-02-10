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

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(ADDED_PRODUCT).getText();
    }

    public void removeProductFromCart(By product){
        driver.findElement(product).click();
    }

    public List<WebElement> getProducts(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElements(By.className("inventory_item_name"));
    }

    public void clickContinueButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
