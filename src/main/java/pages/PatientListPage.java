package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PatientListPage extends BasePage {

	public PatientListPage(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators - Add Patient Button
	private By addPatient = By.cssSelector("dx-button.patients-page__addpatient");
	
    //Page Locators - Add Patient window
	private By firstName = By.xpath("/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[1]/div[1]/div/dx-text-box/div/input");
    private By lastName = By.xpath("/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[3]/div[1]/div/dx-text-box/div/input");
    private By birthDate = By.cssSelector(".dx-visibility-change-handler.dx-dropdowneditor [aria-haspopup]");
    private By genderDropdown = By.xpath("/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[5]/div/div/ufc-gender-input/div/div/dx-select-box/div/div/div[2]/div/div/div");
    private By genderSelect = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[1]");
    private By phoneNumber = By.xpath("/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[6]/div/div/ufc-phone-input/form/div/div[1]/dx-text-box/div/input");
    private By phoneNumberDropdown = By.xpath("/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[6]/div[1]/div/ufc-phone-input/form/div/div[2]/dx-select-box/div[1]/div/div[2]/div");
    private By phoneNumberSelect = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[1]");
    private By emailAddress = By.cssSelector("body > ufc-add-edit-patient-modal > div > div > div > div.modal-body > div:nth-child(1) > form > ufc-form-render > div:nth-child(7) > div.c-user-box > div > dx-text-box > div > input");
    
    //Page Locators - Add Patient Window - United States state selection
    private By countryDropdown = By.cssSelector("[displayexpr='name'] .dx-dropdowneditor-icon");
    private By countrySelect = By.cssSelector("[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content");
    private By stateDropdown = By.cssSelector("ufc-country-state [class='col-6']:nth-of-type(2) .dx-dropdowneditor-icon");
    
    //Page Locators - Add Patient Window - Colorado Country selection
    private By stateSelect = By.cssSelector("[data-bind] [role='option']:nth-of-type(6) .dx-list-item-content");
    
    private By saveButton = By.cssSelector("dx-button:nth-of-type(1)  .dx-button-text");
    private By patientListBtn = By.cssSelector(".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title");
   
    //Page Locators - Start ORDER and SEARCH BAR
    private By startOrder = By.cssSelector(".dx-scrollview-content [role='option']:nth-of-type(1) .patients-row__action");
    private By searchBar = By.cssSelector(".dx-texteditor-container [type]");
    
    //Page Locators - Finished order confirmation modal
    private By orderSent = By.cssSelector(".modal-title");
    private By orderNumber = By.cssSelector(".order-sent-modal__info");
    private By orderDetails = By.cssSelector(".modal-footer [type='button']:nth-of-type(1)");
    
    //Page Locators -  Top right logout dropdown buttons
    private By logDrop = By.cssSelector(".md-chevron-down");
    private By logout = By.cssSelector("li:nth-of-type(2) [role] [role='menuitem']:nth-child(3)");
    private By xMark = By.cssSelector(".close > span");
    
    
    //Locator GET Methods
    public WebElement getAddPatient() {
    	return getElement(addPatient);
    }
    
    public WebElement getFirstName() {
    	return getElement(firstName);
    }
    
    public WebElement getLastName() {
    	return getElement(lastName);
    }
    
    public WebElement getBirthdate() {
    	return getElement(birthDate);
    }
    
    public WebElement getGenderDropdown() {
    	return getElement(genderDropdown);
    }
    
    public WebElement getGenderSelect() {
    	return getElement(genderSelect);
    }
    
    public WebElement getPhoneNumber() {
    	return getElement(phoneNumber);
    }
    
    public WebElement getPhoneNumberDropdown() {
    	return getElement(phoneNumberDropdown);
    }
    
    public WebElement getPhoneNumberSelect() {
    	return getElement(phoneNumberSelect);
    }
    
    public WebElement getEmailAddress() {
    	return getElement(emailAddress);
    }
    
    public WebElement getCountryDropdown() {
    	return getElement(countryDropdown);
    }
    
    public WebElement getCountrySelect() {
    	return getElement(countrySelect);
    }
    
    public WebElement getStateDropdown() {
    	return getElement(stateDropdown);
    }
    
    public WebElement getStateSelect() {
    	return getElement(stateSelect);
    }
    
    public WebElement getSaveButton() {
    	return getElement(saveButton);
    }
    
    public WebElement getPatientListBtn() {
    	return getElement(patientListBtn);
    }
    
    public WebElement getStartOrder() {
    	return getElement(startOrder);
    }
    
    public WebElement getSearchBar() {
    	return getElement(searchBar);
    }
    
    public WebElement getOrderSent() {
    	return getElement(orderSent);
    }
    
    public WebElement getOrderNumber() {
    	return getElement(orderNumber);
    }
    
    public WebElement getOrderDetails() {
    	return getElement(orderDetails);
    }
    
    public WebElement getLogDrop() {
    	return getElement(logDrop);
    }
    
    public WebElement getLogout() {
    	return getElement(logout);
    }
    
    public WebElement getXmark() {
    	return getElement(xMark);
    }
    
   
    
    //Page Navigation methods
    public IngredientsPage startOrder() {
    	getStartOrder().click();
    	return getInstance(IngredientsPage.class);
    }
    
    public void completeCredentials(String emailAddresss, String firstNamee, String lastNamee, String birthdayy,
            String phoneNumberr) {
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getAddPatient().click();
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getEmailAddress().sendKeys(emailAddresss);
    	getFirstName().sendKeys(firstNamee);
    	getLastName().sendKeys(lastNamee);
    	getBirthdate().sendKeys(birthdayy);
    	getGenderDropdown().click();
    	getGenderSelect().click();
    	
    	getPhoneNumber().sendKeys(phoneNumberr);
    	getLastName().click();
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getPhoneNumberDropdown().click();
    	getPhoneNumberSelect().click();
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getCountryDropdown().click();
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getCountrySelect().click();
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getStateDropdown().click();
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getStateSelect().click();
    }
    
    public void savePatient() {
        getSaveButton().click();
    }
    
    public void get_orderDetails() {
        getOrderDetails().click();
    }
    
    private String get_orderName() {
        // Get Sentence
        String order = getOrderNumber().getText();
        // Split sentence words
        String[] words = order.split("\\s+");
        // Replace special character of the 2nd word
        String orderNumber = words[1].replace("#", "");
        System.out.println("This is the extracted word: " + orderNumber);
        return orderNumber.toString();
    }
    
    public void assertOrder(String expected) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	Assert.assertEquals(getOrderSent().getText(), expected);
    }
    
    public LoginPage logout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLogDrop().click();
        getLogout().click();
        return getInstance(LoginPage.class);
    }
    
    public void closeSentOrder() {
    	try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	getXmark().click();
    }
    
    public static class IngredientsPage extends PatientListPage {

		public IngredientsPage(WebDriver driver) {
			super(driver);
		}
		
		//Page Locators - Main Page Locators
		private By addIngredient = By.cssSelector(".dx-scrollable-content [role='row']:nth-of-type(4) .material-icons");
        private By roundUp = By.cssSelector("[tabindex='-1']:nth-of-type(2) span");
        private By checkoutOrder = By.cssSelector(".draft-order__actions [tabindex='0']:nth-of-type(2)");
        private By setQ = By.cssSelector("dx-number-box [type='text']");
        private By addToRx = By.cssSelector("[class='col-6 alert__button-container'] .dx-button-text");
        
        //Locator GET Methods
        public WebElement getAddIngredient() {
        	return getElement(addIngredient);
        }
        
        public WebElement getRoundUp() {
        	return getElement(roundUp);
        }
        
        public WebElement getCheckoutOrder() {
        	return getElement(checkoutOrder);
        }
        
        public WebElement getSetQ() {
        	return getElement(setQ);
        }
        
        public WebElement getAddToRX() {
        	return getElement(addToRx);
        }
        
        //Page Navigation Methods
        public void addIngredients() {
        	getAddIngredient().click();
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	if(getAddToRX() != null ) {
        		getAddToRX().click();
        	} else {
        		System.out.println("Medium is not different");
        	}
        }
        
        public void roundupIngredients(String quantity) {
        	getSetQ().sendKeys(quantity);
        }
        
        public PlaceOrderPage checkoutOrder() {
        	getCheckoutOrder().click();
        	return getInstance(PlaceOrderPage.class);
        }
        
    }
    
    public static class PlaceOrderPage extends PatientListPage {

		public PlaceOrderPage(WebDriver driver) {
			super(driver);
		}
		
		//Page Locators - Is order a drop-ship yes/no
		private By yesDropship = By.cssSelector("input#radioButtonDropshipYes");
		private By noDropship = By.cssSelector("input#radioButtonDropshipNo");
        
		//Page Locators - Shipping Method
		private By amazon = By.cssSelector(".shipping-details__box .ng-star-inserted:nth-child(2) [name='shipping']");
        
		//Page Locators - Payment Method 
		private By clinicPay = By.cssSelector(".shipping-details__box .ng-star-inserted:nth-child(2) [name='payment']");
        private By onlinePay = By.cssSelector("div:nth-of-type(2) > .radio-custom > input[name='payment']");
        
        //Page Locators - Terms and Conditions
        private By termsAgreement = By.cssSelector(".summary-page__orderbox-send input");
        private By sendOrder = By.cssSelector(".summary-page__orderbox-send .dx-button-content");
        
        //Page Locators - Delivery address - Modal in Place Order Page
        private By firstName = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By lastName = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[2]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By address = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[4]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By city = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[6]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By zipcode = By.xpath("//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[7]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        
        private By country = By.cssSelector("[displayexpr='name'] .dx-dropdowneditor-icon");
        private By countrySelection = By.cssSelector("div:nth-of-type(1) > .dx-item-content.dx-list-item-content");
        
        private By state = By.cssSelector(".ng-untouched.ng-invalid [class='col-6']:nth-of-type(2) .dx-dropdowneditor-icon");
        private By stateSelection = By.cssSelector("[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content");
        
        //Page Locators - Coupon input
        private By couponInput = By.cssSelector("input[role='textbox']");
        private By applyCoupon = By.cssSelector(".apply-coupon__butcontainer .dx-button-text");
        
        
        //Locator GET Methods
        public WebElement getYesDropship() {
        	return getElement(yesDropship);
        }
        
        public WebElement getNoDropship() {
        	return getElement(noDropship);
        }
        
        public WebElement getAmazon() {
        	return getElement(amazon);
        }
        
        public WebElement getClinicPay() {
        	return getElement(clinicPay);
        }
        
        public WebElement getOnlinePay() {
        	return getElement(onlinePay);
        }
        
        public WebElement getTermsAgreement() {
        	return getElement(termsAgreement);
        }
        
        public WebElement getSendOrder() {
        	return getElement(sendOrder);
        }
        
        public WebElement getFirstName() {
        	return getElement(firstName);
        }
        
        public WebElement getLastName() {
        	return getElement(lastName);
        }
        
        public WebElement getAddress() {
        	return getElement(address);
        }
        
        public WebElement getCity() {
        	return getElement(city);
        }
        
        public WebElement getZipCode() {
        	return getElement(zipcode);
        }
        
        public WebElement getCountry() {
        	return getElement(country);
        }
        
        public WebElement getCountrySelection() {
        	return getElement(countrySelection);
        }
        
        public WebElement getState() {
        	return getElement(state);
        }
        
        public WebElement getStateSelection() {
        	return getElement(stateSelection);
        }
        
        public WebElement getCouponInput() {
        	return getElement(couponInput);
        }
        
        public WebElement getApplyCoupon() {
        	return getElement(applyCoupon);
        }
        
        //Page Navigation methods
        public void placeOrder() {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        	getYesDropship().click();
        	try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getAmazon().click();
        	getClinicPay().click();
        	try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getTermsAgreement().click();
        	try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getSendOrder().click();
        }
        
        public void apply_coupon(String expected) {
        	try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getCouponInput().sendKeys(expected);
        	try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getApplyCoupon().click();
        }
    }
}
