package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends HeaderPage{

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    String CUSTOMER_FIRST_NAME = "John";
    String CUSTOMER_LAST_NAME = "Doe";
    String ZIP_CODE = "12345";


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }


    public void fillCustomerInfo(){
        driver.findElement(FIRST_NAME).sendKeys(CUSTOMER_FIRST_NAME);
        driver.findElement(LAST_NAME).sendKeys(CUSTOMER_LAST_NAME);
        driver.findElement(POSTAL_CODE).sendKeys(ZIP_CODE);
    }

    public void clickContinueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
