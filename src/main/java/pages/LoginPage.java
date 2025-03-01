package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Login page.
 */
@Log4j2
public class LoginPage extends BasePage{

    /**
     * The constant USERNAME_INPUT.
     */
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    /**
     * The constant PASSWORD_INPUT.
     */
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    /**
     * The constant LOGIN_BUTTON.
     */
    public static final By LOGIN_BUTTON = By.id("login-button");
    /**
     * The constant ERROR_MESSAGE.
     */
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login products page.
     *
     * @param user the user
     * @return the products page
     */
    public ProductsPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUserName());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info(String.format("User logged in successfully with username "+ user.getUserName()));
        return new ProductsPage(driver);
    }

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        log.info("Error message displayed: " + driver.findElement(ERROR_MESSAGE).getText());
        return driver.findElement(ERROR_MESSAGE).getText();
     }

    /**
     * Wait for page opened login page.
     *
     * @return the login page
     */
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }
}