package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends HeaderPage{

    public static By ORDER_SUCCESSFUL = By.xpath("//*[@data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulOrderText(){
        return driver.findElement(ORDER_SUCCESSFUL).getText();
    }
}
