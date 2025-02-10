package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HeaderPage{

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillCustomerInfo(String firstName, String lastName, String zipCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(zipCode);
    }

    public void openCheckoutPage(){
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
