package steps;

import constants.IConstants;
import entity.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

//    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
//        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
//        loginPage
//                .waitForPageOpened()
//                .login(username, password);
//        return this;
//    }

    public LoginSteps loginAndWaitForPageOpened(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(user);
        return this;
    }
}