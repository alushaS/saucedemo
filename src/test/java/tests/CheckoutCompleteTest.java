package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends BaseTest{

    @Test(description = "QA-5 Successful purchase test")
    public void checkoutCompleteTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        productsPage.openCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillCustomerInfo(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, ZIP_CODE);
        checkoutPage.openCheckoutPage();
        checkoutOverviewPage.openCheckoutCompletePage();
        Assert.assertEquals(checkoutCompletePage.getSuccessfulOrderText(),SUCCESSFUL_ORDER_TEXT);
    }
}
