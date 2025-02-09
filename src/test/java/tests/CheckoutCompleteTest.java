package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class CheckoutCompleteTest extends BaseTest{

    @Test(description = "QA-5 Successful purchase test")
    public void checkoutCompleteTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME,PASSWORD);
        productsPage.addProductToCart(ProductsPage.BOLT_T_SHIRT_ID);
        productsPage.clickCartButton();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.fillCustomerInfo();
        checkoutStepOnePage.clickContinueButton();
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertEquals(checkOutCompletePage.getSuccessfulOrderText(),SUCCESSFUL_ORDER_TEXT);

    }
}
