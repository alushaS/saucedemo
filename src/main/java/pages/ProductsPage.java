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
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(By product){
        driver.findElement(product).click();
    }

    public void setPricesFromHighToLow(){
        Select select = new Select(driver.findElement(PRODUCT_FILTER));
        List<WebElement> optionsList = select.getOptions();
        WebElement highToLowOption = optionsList.get(2);
        highToLowOption.click();
    }

    public String getLowestPrice(){
       return driver.findElements(By.xpath("//*[@data-test='inventory-item-price']")).getFirst().getText();
    }
}
