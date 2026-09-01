package ManuelRodriguez.saucedemo.tests;

import ManuelRodriguez.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ManuelRodriguez.saucedemo.utils.Constants;

public class PurchaseTest extends BaseTest{

    @Test(description = "Complete the buy flow and reach the order confirmation page")
    public void purchaseProductTest(){
        LoginPage loginPage = getLoginPage();
        InventoryPage inventoryPage = loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue(inventoryPage.isPageDisplayed(), "The inventory page was not displayed");

        inventoryPage.addRandomProductToCart();
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1, "The cart should contain one product");

        CartPage cartPage = inventoryPage.goToCart();
        CheckoutInfoPage checkoutInfoPage = cartPage.goToInfoPage();

        CheckoutOverviewPage overviewPage = checkoutInfoPage.fillInformation(
                Constants.FIRST_NAME, Constants.LAST_NAME, Constants.POSTAL_CODE);

        CheckoutCompletePage completePage = overviewPage.goToCheckoutCompletePage();
        Assert.assertEquals(completePage.getCompleteMessage(),
                Constants.ORDER_COMPLETE_MESSAGE,
                "The order confirmation message did not match");
    }
}
