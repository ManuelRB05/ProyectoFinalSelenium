package ManuelRodriguez.saucedemo.pages;

import ManuelRodriguez.saucedemo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public CheckoutInfoPage(WebDriver driver){
        super(driver);
    }

    public CheckoutOverviewPage fillInformation(String firstName, String lastName, String postalCode){
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }

    public boolean isPageDisplayed(){
        return isDisplayed(pageTitle);
    }
}
