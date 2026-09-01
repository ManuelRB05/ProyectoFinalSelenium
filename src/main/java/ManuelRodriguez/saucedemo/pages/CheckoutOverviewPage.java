package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public CheckoutOverviewPage (WebDriver driver){
        super(driver);
    }

    public CheckoutCompletePage goToCheckoutCompletePage(){
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }

    public boolean isPageDisplayed(){
        return isDisplayed(pageTitle);
    }
}
