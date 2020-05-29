package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.BasePage;

public class LoginPage extends BasePage {

	
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    //Page Locators
    private By username = By.cssSelector("[type='email']");
    private By password = By.cssSelector("[type='password']");
    private By loginBtn = By.xpath("//up-root/up-user-login/div[@class='user-page-full']/div[@class='user-login']/div//up-login-box//form//dx-button[@role='button']/div[@class='dx-button-content']");
    private By header = By.xpath("xpathExpression");
    private By credentialError = By.cssSelector(".error");
    
    private By newAccount = By.cssSelector("[tabindex='5']");
    
    
    	//Get functions
	    public WebElement getUsername() {
	        return getElement(username);
	    }
	
	    public WebElement getPassword() {
	        return getElement(password);
	    }
	
	    public WebElement getLoginBtn() {
	        return getElement(loginBtn);
	    }
	
	    public WebElement getHeader() {
	        return getElement(header);
	    }
	    
	    public WebElement getNewAccount() {
	    	return getElement(newAccount);
	    }
	    
	    public WebElement getCredentialError() {
	    	return getElement(credentialError);
	    }
	
	    public String getLoginPageTitle() {
	        return getPageTitle();
	    }
	
	    public void getLoginPageHeader() {
	        getPageHeader(header);
	    }
	    
	    //Methods - page navigation functions
	    public PractitionerHomePage login(String username, String password) {

	    	getUsername().sendKeys(username);
	        getPassword().sendKeys(password);
	        getLoginBtn().click();
	        return getInstance(PractitionerHomePage.class);
	    }
	    
	    public RegistrationPage enter_Registration() {

	    	getNewAccount().click();
	    	return getInstance(RegistrationPage.class);
	    }
	    
	    public void assert_wrongUser_errorMessage(String expected) {

	    	Assert.assertEquals(getCredentialError().getText(), expected);
	    }
    
   

}
