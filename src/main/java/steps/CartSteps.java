package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;

public class CartSteps {

    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    @Step ("Remove product from cart")
    public CartSteps removeProductFromCart(String productName) {
        cartPage.openCart();
        cartPage.removeProductFromCart(productName);
        return this;
    }

    @Step ("Open cart and finish purchase")
    public CartSteps openCartAndFinishPurchase(String firstName, String lastName, String zipCode) {
        cartPage.openCart()
                .clickCheckoutButton()
                .fillCustomerInfo(firstName, lastName,zipCode)
                .openCheckoutPage()
                .openCheckoutCompletePage();
        return this;
    }
}
