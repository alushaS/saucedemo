import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainPage {

    WebDriver driver = new ChromeDriver();

    private final WebElement searchById = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    private final WebElement searchByClassName = driver.findElement(By.className("bm-burger-button"));
    private final WebElement searchByCssSelector = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
    private final WebElement linkText = driver.findElement(By.linkText("All Items"));
    private final WebElement partLinkText = driver.findElement(By.partialLinkText("All"));
    private final WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]"));
    private final WebElement productName = driver.findElement(By.xpath("//*[text() =\"Sauce Labs Backpack\"]"));
    private final WebElement productNamePartial = driver.findElement(By.xpath("//*[contains(text(), \"Light\")]"));
    private final List<WebElement> priceList = driver.findElements(By.xpath("//*[contains(@data-test, 'price')]"));
    //*[@class='login_wrapper-inner']//descendant::div
    //*[@class='login_wrapper-inner']//parent::div
    //input[@id='password']/preceding::input[1]
    //*[@class='login_wrapper-inner']/following-sibling::di v
    //input[@id='password']/preceding-sibling::input[1]

    //*[text()='Test']//ancestor::div

//*[@class='login_wrapper-inner']//descendant::div

//*[@class='login_wrapper-inner']//parent::div

//input[@id='password']/preceding::input[1]

//input[@id='password']/preceding-sibling::input[1]


//*[@class='login_wrapper-inner']/following-sibling::di v
//*[@data-test='password' and contains(@id, 'password')]
//*[@data-test='password' and contains(@id, 'password') and contains(@name, 'password')]

//img[@class="inventory_item_img"]/@src

//.inventory_item .inventory_item_img;

}
