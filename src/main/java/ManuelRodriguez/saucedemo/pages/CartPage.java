package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(css = "button[data-test^='remove']")
    private List<WebElement> deleteCartItemsButton;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void removeItem(){
        while (cartItems.size() > 0){
            click(deleteCartItemsButton.get(0));
        }
    }

    public int getItemCount(){
        return cartItems.size();
    }

    public boolean isCartEmpty(){
        return cartItems.isEmpty();
    }

    public CheckoutInfoPage goToInfoPage(){
        click(checkoutButton);
        return new CheckoutInfoPage(driver);
    }

    public boolean isPageDisplayed(){
        return isDisplayed(pageTitle);
    }
}
