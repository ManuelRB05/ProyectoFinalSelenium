package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(css = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public NavBarPage(WebDriver driver){
        super(driver);
    }

    public LoginPage logout(){
        click(burgerMenuButton);
        click(logoutLink);
        return new LoginPage(driver);
    }

    public CartPage goToCart(){
        click(shoppingCartLink);
        return new CartPage(driver);
    }
}
