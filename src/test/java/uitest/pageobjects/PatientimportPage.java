// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class PatientimportPage extends BasePage {
    public PatientimportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-patient-list-validate[@class='ng-star-inserted']/div[@class='m-patients-import']//ufc-file-upload[@name='file']/input[@type='file']")
    WebElement hiddenUpload;
    @FindBy(css = "")
    WebElement uploadPatient;

    @FindBy(css = ".col-6.mb-20.mt-20.ng-star-inserted.text-center > dx-button[role='button']  span")
    WebElement validate;;

    @FindBy(css = ".dx-button-text")
    WebElement finishImport;

    @FindBy(css = "[class] .import-result:nth-of-type(1)")
    WebElement importSuccess;
    @FindBy(css = "[class] .import-result:nth-of-type(3) .dx-button-text")
    WebElement importOther;
    String filePath = "src/test/java/uitest/uploadDocuments/MyImport3333.csv";

    public void uploadFile(String expected) throws InterruptedException {
        Thread.sleep(2000);
        String basepath = new File(filePath).getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript(expected, hiddenUpload);
        writeText(hiddenUpload, basepath);
    }//

    public void validateFile() {
        if (validate.isDisplayed()) {
            click(validate);
        } else {
            waitElement(validate);
            click(validate);
        }
    }

    public void finishImport() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(finishImport);
    }

    public void assertImport(String expected) {
        waitElement(importOther);
        Assert.assertEquals(readText(importSuccess), expected);
    }
}
