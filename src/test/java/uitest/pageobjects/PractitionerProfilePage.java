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
    @FindBy(css = "div:nth-of-type(1) > .c-user-box > dx-button[role='button']")
    WebElement save1;
    @FindBy(css = ".c-user-box.ng-star-inserted [type='default'] .dx-button-content")
    WebElement save2;
    @FindBy(css = "[class] .c-user-box:nth-child(3) .dx-button-content")
    WebElement save3;

    // Logo
    @FindBy(linkText = "ADDLOGO")
    WebElement logo;
    @FindBy(css = "[name='logo'] [data-max-size]")
    WebElement logoInput;

    String imgPath = "src/test/java/uitest/uploadimage/300x120.png";

    @FindBy(css = ".logo-undo-link.pull-right")
    WebElement undo;

    // Upload Certificate
    @FindBy(css = "[name='file'] [data-max-size]")
    WebElement uploadInput;

    //
    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/up-user-profile[@class='ng-star-inserted']/div/div[1]/form/ufc-form-render/div[7]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement license;
    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/up-user-profile[@class='ng-star-inserted']/div/div[1]/form/ufc-form-render/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement firstName;

    //
    String filePath = "src/test/java/uitest/uploadDocuments/chart.pdf";

    public void enterPassword() {
        waitElement(changePass);
        click(changePass);
        waitElement(oldPass);
        writeText(oldPass, "");
        writeText(newPass, "");
        writeText(confirmPass, "");
    }

    public void changePassword() {
        click(save2);
    }

    public void complete_userProfile() throws InterruptedException {
        Thread.sleep(2000);
        writeText(license, "123");
    }

    public void uploadCertificate(String expected) throws InterruptedException {

        Thread.sleep(3500);

        String basepath = new File(filePath).getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript(expected, uploadInput);
        writeText(uploadInput, basepath);
    }

    public void uploadLogo(String expected) {
        String basepath = new File(imgPath).getAbsolutePath();
        waitElement(logo);
        ((JavascriptExecutor) driver).executeScript(expected, logoInput);
        writeText(logoInput, basepath);
    }

    public void saveLogo() {
        waitElement(undo);
        click(save3);
    }

    public void saveCertificate() throws InterruptedException {
        waitElement(firstName);
        writeText(firstName, "test");
        Thread.sleep(4000);
        click(save1);
    }

}
