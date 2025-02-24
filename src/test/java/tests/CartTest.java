package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends Preconditions{

    @Test (description = "QA-3 Product can be removed from page test")
    public void removeProductTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithCorrectCredentials)
                .addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openCart();
        cartPage.removeProductFromCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(cartPage.getProducts().isEmpty());
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userWithCorrectCredentials)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openCart();
        cartPage.removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }


    @Test (description = "QA-4 Continue Shopping button navigates to products page test")
    public void continueShoppingButtonTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userWithCorrectCredentials);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openCart();
        cartPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }
}
