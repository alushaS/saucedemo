package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends HeaderPage{
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public static final By FINISH_BUTTON = By.id("finish");

    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }
}
