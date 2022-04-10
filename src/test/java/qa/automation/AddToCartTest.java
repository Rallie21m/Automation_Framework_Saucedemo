package qa.automation;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest extends TestUtil {

    @Test
    public void addItemToTheCart(){
        String product1 = "onesie";
        String product2 = "backpack";
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isUserAllPagesBtnShown(), "Wrong product page!");

        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        Assert.assertEquals(productsPage.getItemInTheCart(),2);

        productsPage.shoppingCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCheckoutBtnShown(), "Wrong cart page!");
        Assert.assertTrue(cartPage.isItemInTheCart(product1),"Item is not in the cart!");
        Assert.assertTrue(cartPage.isItemInTheCart(product2), "Item is not in the cart!");
    }

}
