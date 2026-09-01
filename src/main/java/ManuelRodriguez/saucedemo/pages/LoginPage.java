package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public InventoryPage login(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new InventoryPage(driver);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public boolean isLoginButtonDisplayed(){
        return isDisplayed(loginButton);
    }
}
