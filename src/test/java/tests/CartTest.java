package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest extends BaseTest{

    @Test (description = "QA-3 Product can be removed from page test")
    public void removeProductTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME,PASSWORD);
        productsPage.addProductToCart(ProductsPage.BOLT_T_SHIRT_ID);
        productsPage.clickCartButton();
        cartPage.removeProduct(CartPage.REMOVE_BOLT_T_SHIRT);
        Assert.assertTrue(cartPage.getProducts().isEmpty());
    }

    @Test (description = "QA-4 Continue Shopping button navigates to products page test")
    public void continueShoppingButtonTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME,PASSWORD);
        productsPage.addProductToCart(ProductsPage.BOLT_T_SHIRT_ID);
        productsPage.clickCartButton();
        cartPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),PRODUCTS_PAGE_URL);
    }
}
