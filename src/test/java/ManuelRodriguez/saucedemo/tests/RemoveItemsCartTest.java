package ManuelRodriguez.saucedemo.tests;

import ManuelRodriguez.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ManuelRodriguez.saucedemo.utils.Constants;

public class RemoveItemsCartTest extends BaseTest{
    @Test(description = "Add 3 elements to the cart, remove them and check if it is empty")
    public void removeItemsFromCartTest(){
        LoginPage loginPage = getLoginPage();
        InventoryPage inventoryPage = loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue(inventoryPage.isPageDisplayed(), "The inventory page was not displayed");

        inventoryPage.addRandomProductToCart();
        inventoryPage.addRandomProductToCart();
        inventoryPage.addRandomProductToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 3, "The shopping cart does not have 3 products in it");

        CartPage cartPage = inventoryPage.goToCart();
        cartPage.removeItem();
        Assert.assertEquals(cartPage.getItemCount(), 0, "The shopping cart still have products in it");
    }
}
