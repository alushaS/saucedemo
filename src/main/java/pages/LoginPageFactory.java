package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.LoginPage.LOGIN_BUTTON;

/**
 * The type Login page factory.
 */
public class LoginPageFactory extends BasePage{

    /**
     * The UserName input.
     */
    @FindBy(xpath = "//*[@data-test='username']")
    WebElement userNameInput;

    /**
     * The Password input.
     */
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    /**
     * The Login button.
     */
    @FindBy(id = "login-button")
    WebElement loginButton;

    /**
     * The Error message.
     */
    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    /**
     * The Add button.
     */
    @Getter
    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    /**
     * The Delete button.
     */
    @Getter
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    /**
     * Instantiates a new Login page factory.
     *
     * @param driver the driver
     */
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    /**
     * Login.
     *
     * @param userName the userName
     * @param password the password
     */
    public void login(String userName, String password) {
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Wait for page opened login page factory.
     *
     * @return the login page factory
     */
    public LoginPageFactory waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }
}
