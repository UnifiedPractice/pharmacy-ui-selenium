// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class PractitionerProfilePage extends BasePage {
    public PractitionerProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[type='normal'] .dx-button-text")
    WebElement changePass;
    @FindBy(css = ".dx-show-clear-button.ng-touched [type]")
    WebElement oldPass;
    @FindBy(css = ".user-profile .form-row:nth-of-type(3) [type='password']")
    WebElement newPass;
    @FindBy(css = ".dx-editor-underlined.dx-show-clear-button.dx-textbox.dx-texteditor.dx-texteditor-empty.dx-widget.ng-pristine.ng-touched.ng-valid  input[role='textbox']")
    WebElement confirmPass;
    @FindBy(css = ".c-user-box.ng-star-inserted [type='default'] .dx-button-text")
    WebElement save;

    public void enterPassword() {
        waitElement(changePass);
        click(changePass);
        waitElement(oldPass);
        writeText(oldPass, "");
        writeText(newPass, "");
        writeText(confirmPass, "");
    }

    public void changePassword() {
        click(save);
    }

}
