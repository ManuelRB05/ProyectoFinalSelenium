package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {
    @FindBy(css = "button[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void addRandomProductToCart(){
        int randomIndex = new Random().nextInt(addToCartButtons.size());
        click(addToCartButtons.get(randomIndex));
    }

    public void addProductsToCart(int quantity){
        for (int i = 0; i < quantity; i++){
            click(addToCartButtons.get(0));
        }
    }

    public int getCartItemCount(){
        if (!isDisplayed(shoppingCartBadge)){
            return 0;
        }
        return Integer.parseInt(getText(shoppingCartBadge));
    }

    public NavBarPage getNavBar(){
        return new NavBarPage(driver);
    }

    public CartPage goToCart(){
        click(shoppingCartLink);
        return new CartPage(driver);
    }

    public boolean isPageDisplayed(){
        return isDisplayed(pageTitle);
    }
}
