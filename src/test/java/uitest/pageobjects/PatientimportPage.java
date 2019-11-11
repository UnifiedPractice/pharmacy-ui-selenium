// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import uitest.BasePage;
import uitest.Variables;

public class PatientimportPage extends BasePage {
    public PatientimportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-patient-list-validate[@class='ng-star-inserted']/div[@class='m-patients-import']//ufc-file-upload[@name='file']/input[@type='file']")
    WebElement hiddenUpload;
    @FindBy(css = "")
    WebElement uploadPatient;

    @FindBy(css = ".col-6.mb-20.mt-20.ng-star-inserted.text-center > dx-button[role='button']  span")
    WebElement validate;

    @FindBy(css = ".dx-button-text")
    WebElement finishImport;

    @FindBy(css = "[class] .import-result:nth-of-type(1)")
    WebElement importSuccess;
    String filePath = "C:/Users/Andrew/Desktop/MyImport3333.csv";

    public void uploadFile() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript(Variables.uploadJS, hiddenUpload);
        writeText(hiddenUpload, filePath);
    }

    public void validateFile() {
        if (validate.isDisplayed()) {
            click(validate);
        } else {
            waitElement(validate);
            click(validate);
        }
    }

    public void finishImport() {
        waitElement(finishImport);
        click(finishImport);
    }

    public void assertImport(String expected) {
        waitElement(importSuccess);
        Assert.assertEquals(readText(importSuccess), expected);
    }
}
