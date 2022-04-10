package qa.automation;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends TestUtil {

    @Test
    public void checkoutTest(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage=loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isUserAllPagesBtnShown(), "Wrong product page!");

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals(productsPage.getItemInTheCart(), 1);

        productsPage.shoppingCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCheckoutBtnShown(), "Wrong cart page!");
        Assert.assertTrue(cartPage.isItemInTheCart("bike-light"), "Item is not in the cart!");

        CheckoutInfoPage checkoutInfoPage = cartPage.checkout();
        Assert.assertTrue(checkoutInfoPage.isContinueBtnShown(), "Wrong Info page!");

        CheckoutStepTwoPage checkoutStepTwoPage = checkoutInfoPage.loginInput("Ralitsa","Markova", "1233" );
        Assert.assertTrue(checkoutStepTwoPage.isFinishBtnShown(), "Wrong page!");

        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.checkoutFinal();
        Assert.assertTrue(checkoutCompletePage.isBackHomeBtnShown(), "Finished!");
    }
}
