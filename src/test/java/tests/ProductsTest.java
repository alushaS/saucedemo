package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends Preconditions{
    private static final Logger log = LoggerFactory.getLogger(ProductsTest.class);
    //loginPage.openPage()
    //loginPage.login(userName, password)
    //productsPage.addToCart("productName")
    //cartPage.openPage()
    //cartPage.getQuantity("productName")
    //cartPage.getPrice("productName")
    //Assertions

    @Test (description = "Add to cart button is displayed test")
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(userWithCorrectCredentials);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test (description = "Remove from cart button is displayed test")
    public void isRemoveToCartButtonDisplayedTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test (description = "QA-1 Add product to cart test")
    public void addProductToCartTest() {
        productSteps.loginAndAddProductToCart(userWithCorrectCredentials, SAUCE_LABS_BOLT_T_SHIRT);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductName(), SAUCE_LABS_BOLT_T_SHIRT);
    }

    @Test (description = "QA-2 Product filter from low to high test")
    public void productFilterLowToHighTest() {
        loginSteps.loginAndWaitForPageOpened(userWithCorrectCredentials);
        productsPage.setPricesFromHighToLow();
        Assert.assertEquals(productsPage.getLowestPrice(), LOWEST_PRODUCT_PRICE);
    }
}
