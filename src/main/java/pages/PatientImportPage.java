package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PatientImportPage extends BasePage {

	public PatientImportPage(WebDriver driver) {
		super(driver);
	}
	
	//Page locators 
	private By hiddenUpload = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-patient-list-validate[@class='ng-star-inserted']/div[@class='m-patients-import']//ufc-file-upload[@name='file']/input[@type='file']");
    private By uploadPatient = By.cssSelector("");
    
    private By validate = By.cssSelector(".col-6.mb-20.mt-20.ng-star-inserted.text-center > dx-button[role='button']  span");
    private By finishImport = By.cssSelector(".dx-button-text");
    
    private By importSuccess = By.cssSelector("[class] .import-result:nth-of-type(1)");
    private By importOther = By.cssSelector("[class] .import-result:nth-of-type(3) .dx-button-text");
    
    //Relative path patient CSV file
    String filePath = "src/main/java/uploadDocuments/MyImport3333.csv";
    
    
    //Locator GET Methods
    public WebElement getHiddenUpload() {
    	return getElement(hiddenUpload);
    }
    
    public WebElement getUploadPatient() {
    	return getElement(uploadPatient);
    }
    
    public WebElement getValidate() {
    	return getElement(validate);
    }
    
    public WebElement getFinishImport() {
    	return getElement(finishImport);
    }
    
    public WebElement getImportSuccess() {
    	return getElement(importSuccess);
    }
    
    public WebElement getImportOther() {
    	return getElement(importOther);
    }
    
    //Page Navigation Methods
    public void uploadFile(String expected) {
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String basepath = new File(filePath).getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript(expected, getHiddenUpload());
        getHiddenUpload().sendKeys(basepath);
    }
    
    public void validateFile() {
    	getValidate().click();
    }
    
    public void finishImport() {
    	try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getFinishImport().click();
    }
    
    public void assertImport(String expected) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	Assert.assertEquals(getImportSuccess().getText(), expected);
    }

}
