package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends Preconditions{

    @Test (description = "QA-3 Product can be removed from page test")
    public void removeProductTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.removeProductFromCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(cartPage.getProducts().isEmpty());
    }

    @Test (description = "Remove item from cart test")
    public void removeItemFromCartTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BACKPACK);
        cartSteps.removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test (description = "QA-4 Continue Shopping button navigates to products page test")
    public void continueShoppingButtonTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.removeProductFromCart(SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openCart()
                .clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }
}
