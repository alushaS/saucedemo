package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends Preconditions{

    @Test(description = "QA-5 Successful purchase test")
    public void checkoutCompleteTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.openCartAndFinishPurchase(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, ZIP_CODE);
        Assert.assertEquals(checkoutCompletePage.getSuccessfulOrderText(),SUCCESSFUL_ORDER_TEXT);
    }
}
