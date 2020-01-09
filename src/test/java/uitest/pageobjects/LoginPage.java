// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;
import uitest.Variables;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[type='email']")
    WebElement username;

    @FindBy(css = "[type='password']")
    WebElement password;

    @FindBy(css = "form [class='col-12 form-row']:nth-of-type(3) .c-user-box")
    WebElement loginButton;

    @FindBy(css = ".error")
    WebElement credentialError;

    // New Account Registration
    @FindBy(css = "[tabindex='5']")
    WebElement newAccount;

    public void openHelioscript() {
        driver.get(Variables.helioUrl);
    }

    public PractitionerHomePage login(String user, String pass) {
        waitElement(username);
        writeText(username, user);
        writeText(password, pass);
        click(loginButton);

        return new PractitionerHomePage(driver);
    }

    public void assert_wrongUser_errorMessage(String expected) throws InterruptedException {
        waitElement(credentialError);
        Assert.assertEquals(readText(credentialError), expected);
    }

    public RegistrationPage enter_Registration() {
        waitElement(newAccount);
        click(newAccount);
        return new RegistrationPage(driver);
    }
}
