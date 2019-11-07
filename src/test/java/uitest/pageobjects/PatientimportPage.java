// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class PatientimportPage extends BasePage {
    public PatientimportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-patient-list-validate[@class='ng-star-inserted']/div[@class='m-patients-import']//ufc-file-upload[@name='file']/input[@type='file']")
    WebElement upload;

    @FindBy(css = ".col-6.mb-20.mt-20.ng-star-inserted.text-center > dx-button[role='button']  span")
    WebElement validate;

    @FindBy(css = ".dx-button-text")
    WebElement finishImport;

    String filePath = "C:/Users/Andrew/Desktop/MyImport3333.csv";

    public void uploadFile() {
        waitElement(upload);
        extracted();
    }

    private void extracted() {
        writeText(upload, filePath);
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
}
