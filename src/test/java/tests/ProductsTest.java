package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{
    //loginPage.openPage()
    //loginPage.login(userName, password)
    //productsPage.addToCart("productName")
    //cartPage.openPage()
    //cartPage.getQuantity("productName")
    //cartPage.getPrice("productName")
    //Assertions

    @Test (description = "QA-1 Add product to cart test")
    public void addProductToCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME,PASSWORD);
        productsPage.addProductToCart(ProductsPage.BOLT_T_SHIRT_ID);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductName(), SAUCE_LABS_BOLT_T_SHIRT);
    }

    @Test (description = "QA-2 Product filter from low to high test")
    public void productFilterLowToHighTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USER_NAME,PASSWORD);
        productsPage.setPricesFromHighToLow();
        Assert.assertEquals(productsPage.getLowestPrice(), LOWEST_PRODUCT_PRICE);

    }
}
