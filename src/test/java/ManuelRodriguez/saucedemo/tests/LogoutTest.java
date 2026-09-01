package ManuelRodriguez.saucedemo.tests;

import ManuelRodriguez.saucedemo.pages.InventoryPage;
import ManuelRodriguez.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ManuelRodriguez.saucedemo.utils.Constants;

public class LogoutTest extends BaseTest{
    @Test(description = "Log out and verify the user is redirected to the login page")
    public void logoutTest(){
        LoginPage loginPage = getLoginPage();
        InventoryPage inventoryPage =loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LoginPage loginPageAfterLogout = inventoryPage.getNavBar().logout();

        Assert.assertTrue(loginPageAfterLogout.isLoginButtonDisplayed(),
                "The login button should be displayed after logging out");
        Assert.assertEquals(loginPageAfterLogout.getCurrentUrl(), Constants.BASE_URL, "The user was not redirected to the login page");
    }
}
