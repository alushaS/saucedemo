package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends HeaderPage{
    public static final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public void openCheckoutCompletePage(){
        driver.findElement(FINISH_BUTTON).click();
    }
}
