package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutCompletePage extends HeaderPage{
    public static final By ORDER_SUCCESSFUL = By.xpath("//*[@data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets successful order text.
     *
     * @return the successful order text
     */
    public String getSuccessfulOrderText() {
        log.info("Message displayed: " + driver.findElement(ORDER_SUCCESSFUL).getText());
        return driver.findElement(ORDER_SUCCESSFUL).getText();
    }
}
