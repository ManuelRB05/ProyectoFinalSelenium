package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    @FindBy(css = ".complete-header")
    private WebElement orderCompletedMessage;

    public CheckoutCompletePage (WebDriver driver){
        super(driver);
    }

    public boolean orderCompleteVerification (){
        return getText(orderCompletedMessage).equals("Thank you for your order!");
    }

    public String getCompleteMessage(){
        return getText(orderCompletedMessage);
    }
}
