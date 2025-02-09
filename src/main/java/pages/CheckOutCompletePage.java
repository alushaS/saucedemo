package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckOutCompletePage extends HeaderPage{

    public static By ORDER_SUCCESSFUL = By.xpath("//*[@data-test='complete-header']");

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulOrderText(){
        return driver.findElement(ORDER_SUCCESSFUL).getText();
    }
}
