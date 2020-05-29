package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PractitionerProfilePage extends BasePage {

	public PractitionerProfilePage(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators - Confirmation buttons (SAVE)
	private By save1 = By.cssSelector("div:nth-of-type(1) > .c-user-box > dx-button[role='button']");
    private By save2 = By.cssSelector(".c-user-box.ng-star-inserted [type='default'] .dx-button-content");
    private By save3 = By.cssSelector("[class] .c-user-box:nth-child(3) .dx-button-content");
    
    //Page Locators - Logo upload buttons
    private By logo = By.cssSelector(".logo-preview-upload > .logo-preview.ng-star-inserted");
    private By logoInput = By.cssSelector("[name='logo'] [data-max-size]");// invisible button
    
    // Page Locators - Upload Certificate button
    private By uploadInput = By.cssSelector("[name='file'] [data-max-size]");
    
    //Page Locators - Image to be uploaded (relative path)
	String imgPath = "src/main/java/uploadImage/300x120.png";
	String filePath = "src/main/java/uploadDocuments/chart.pdf";
	
	//Page Locators - undo buttons
	private By undo = By.cssSelector(".logo-undo-link.pull-right");
	
	//Page locators - license button
	private By license = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/up-user-profile[@class='ng-star-inserted']/div/div[1]/form/ufc-form-render/div[7]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
	private By firstName = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/up-user-profile[@class='ng-star-inserted']/div/div[1]/form/ufc-form-render/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
   
	//Page Locators - error message locator
	private By successMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']");
 
	
	//Get functions
	public WebElement getSave1() {
		return getElement(save1);
	}
	
	public WebElement getSave2() {
		return getElement(save2);
	}
	
	public WebElement getSave3() {
		return getElement(save3);
	}
	
	public WebElement getLogo() {
		return getElement(logo);
	}
	
	public WebElement getLogoInput() {
		return getElement(logoInput);
	}
	
	public WebElement getUploadInput() {
		return getElement(uploadInput);
	}
	
	public WebElement getUndo() {
		return getElement(undo);
	}
	
	public WebElement getSuccessMessage() {
		return getElement(successMessage);
	}
	
	public WebElement getLicense() {
		return getElement(license);
	}
	
	public WebElement getFirstName() {
		return getElement(firstName);
	}
	
	//Page navigation Methods
	public void complete_userProfile() {
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        getLicense().sendKeys("1");
    }
	
	public void uploadCertificate(String expected) {
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String basepath = new File(filePath).getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript(expected, getUploadInput());
        getUploadInput().sendKeys(basepath);
     }
	
	public void uploadLogo(String expected) {
        String basepath = new File(imgPath).getAbsolutePath();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript(expected, getLogoInput());
        getLogoInput().sendKeys(basepath);
    }
	
	public void saveLogo() {
         getSave3().click();
	}
	
	public void saveCertificate() {
        getFirstName().sendKeys("James"); // random nameFunction to be implemented
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        getSave1().click();
    }
	
	public void assertUpload(String expected) {
		Assert.assertEquals(getSuccessMessage().getText(), expected);
	}
	
	//////pending assertions////////////////////////////////////
	///////////////////////////////////////////////////////////
	
}
