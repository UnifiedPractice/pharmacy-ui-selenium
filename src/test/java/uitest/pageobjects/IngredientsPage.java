// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class IngredientsPage extends BasePage {

    public IngredientsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dx-scrollable-content [role='row']:nth-of-type(4) .material-icons")
    WebElement addIngredient;

    @FindBy(css = "[tabindex='-1']:nth-of-type(2) span")
    WebElement roundUp;

    @FindBy(css = ".draft-order__actions [tabindex='0']:nth-of-type(2)")
    WebElement checkoutOrder;

    @FindBy(css = "dx-number-box [type='text']")
    WebElement setQ;

    public void addIngredients() {
        waitElement(addIngredient);
        click(addIngredient);
    }

    public void roundupIngredients() {
        writeText(setQ, "1");
    }

    public PlaceOrderPage checkoutOrder() {
        if (checkoutOrder.isDisplayed()) {
            click(checkoutOrder);
        } else {
            waitElement(checkoutOrder);
            click(checkoutOrder);
        }
        return new PlaceOrderPage(driver);
    }

}
