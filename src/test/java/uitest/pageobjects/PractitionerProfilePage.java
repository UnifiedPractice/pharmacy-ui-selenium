// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;

import org.openqa.selenium.JavascriptExecutor;

import uitest.BasePage;

public class PractitionerProfilePage extends BasePage {
    public PractitionerProfilePage(WebDriver driver) {
        super(driver);
    }

    // Password
    @FindBy(css = "[type='normal'] .dx-button-text")
    WebElement changePass;
    @FindBy(css = ".dx-show-clear-button.ng-touched [type]")
    WebElement oldPass;
    @FindBy(css = ".user-profile .form-row:nth-of-type(3) [type='password']")
    WebElement newPass;
    @FindBy(css = ".dx-editor-underlined.dx-show-clear-button.dx-textbox.dx-texteditor.dx-texteditor-empty.dx-widget.ng-pristine.ng-touched.ng-valid  input[role='textbox']")
    WebElement confirmPass;

    // Confirm buttons
    @FindBy(css = "[class] .c-user-box:nth-child(3) .dx-button-content")
    WebElement save;

    // Logo
    // @FindBy(css = ".logo-link")
    @FindBy(linkText = "ADDLOGO")
    WebElement logo;
    @FindBy(css = "[name='logo'] [data-max-size]")
    WebElement logoInput;
    String filePath = "src/test/java/uitest/uploadimage/300x120.png";
    @FindBy(css = ".logo-undo-link.pull-right")
    WebElement undo;

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

    public void addLogo(String expected) {
        String basepath = new File(filePath).getAbsolutePath();
        waitElement(logo);
        ((JavascriptExecutor) driver).executeScript(expected, logoInput);
        writeText(logoInput, basepath);
    }

    public void saveLogo() {
        waitElement(undo);
        click(save);
    }

}
