package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminSettings extends BasePage {

	public AdminSettings(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators - left-side menu
	private By settings = By.cssSelector("li:nth-of-type(3)  .material-icons.ng-star-inserted.site-menu-icon.sub-indicator");
    
	private By userList = By.cssSelector(".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(2) .site-menu-title");
    private By practitionerList = By.cssSelector(".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(3) .site-menu-title");
    private By practitionerApplications = By.cssSelector(".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(4) .site-menu-title");
    private By pharmacySettings = By.cssSelector("li:nth-of-type(3) > .ng-star-inserted.site-menu-sub > li:nth-of-type(5) > .ng-star-inserted  .site-menu-title");
    
    //Locator GET Methods
    public WebElement getSettings() {
    	return getElement(settings);
    }
    
    public WebElement getUserList() {
    	return getElement(userList);
    }
    
    public WebElement getPractitionerList() {
    	return getElement(practitionerList);
    }
    
    public WebElement getPractitionerApplications() {
    	return getElement(practitionerApplications);
    }
    
    public WebElement getPharmacySettings() {
    	return getElement(pharmacySettings);
	}
    
    //Page Navigation Methods
    public UserList enter_UserList() {
    	//getSettings().click(); - to be reimplemented after PHA-751 is pushed to master - this is a set HomePage bug
    	getUserList().click();
    	return getInstance(UserList.class);
    }
    
    public PractitionerList enter_PractitionerList() {
    	//getSettings().click(); - to be reimplemented after PHA-751 is pushed to master - this is a set HomePage bug
    	getPractitionerList().click();
    	return getInstance(PractitionerList.class);
    }
    
    public PractitionerApplications enter_PractitionerApplications() {
    	//getSettings().click(); - to be reimplemented after PHA-751 is pushed to master - this is a set HomePage bug
    	getPractitionerApplications().click();
    	return getInstance(PractitionerApplications.class);
    }
    
    public PharmacySettings enter_PharmacySettings() {
    	//getSettings().click(); - to be reimplemented after PHA-751 is pushed to master - this is a set HomePage bug
    	getPharmacySettings().click();
    	return getInstance(PharmacySettings.class);
    }
    
    public static class UserList extends AdminSettings {

		public UserList(WebDriver driver) {
			super(driver);
		}
		
		//Page Locators - User List page
		private By sendInvite = By.linkText("Send User Invite");
        private By firstName = By.xpath("//div[@id='#invitationPopup']/div[@class='row']/form/ufc-form-render/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By lastName = By.xpath("//div[@id='#invitationPopup']/div[@class='row']/form/ufc-form-render/div[2]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        private By email = By.xpath("//div[@id='#invitationPopup']/div[@class='row']/form/ufc-form-render/div[3]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
        //private By roleList = By.xpath("//body/div[2]/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']");
        private By send = By.cssSelector(".dx-button-text");
        //LIST = roleList 
        //Page Locators - Role
        private By role = By.cssSelector(".dx-dropdowneditor-icon");
        private By CSR = By.xpath("//body/div[2]/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[1]/div[@class='dx-item-content dx-list-item-content']");
        private By compounder = By.xpath("//body/div[2]/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[2]/div[@class='dx-item-content dx-list-item-content']");
        private By admin = By.xpath("//body/div[2]/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[3]/div[@class='dx-item-content dx-list-item-content']");
        
        //Page Locators - notification locator
        private By toastMessage = By.cssSelector(".toast-message");
        
        // Locator GET methods
        public WebElement getSendInvite() {
        	return getElement(sendInvite);
        }
        
        public WebElement getFirstName() {
        	return getElement(firstName);
        }
        
        public WebElement getLastName() {
        	return getElement(lastName);
        }
        
        public WebElement getEmail() {
        	return getElement(email);
        }
        
        /*public List<WebElement> getRoleList() {
        	return getElement(roleList);
        }*/
        
        public WebElement getSend() {
        	return getElement(send);
        }
        
        public WebElement getRole() {
        	return getElement(role);
        }
        
        public WebElement getCSR() {
        	return getElement(CSR);
        }
        
        public WebElement getCompounder() {
        	return getElement(compounder);
        }
        
        public WebElement getAdmin() {
        	return getElement(admin);
        }
        
        public WebElement getToastMessage() {
        	return getElement(toastMessage);
        }
        
        //Page Navigation Methods
        public void send_CSR_Invitation() {
        	getSendInvite().click();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getEmail().sendKeys("claudiu.maxim93@gmail.com");
        	getFirstName().sendKeys(generateName());
        	getLastName().sendKeys(generateName());
        	getRole().click();
        	getCSR().click();
        	try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getSend().click();
        }
        
        public void send_Compounder_Invitation() {
        	getSendInvite().click();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getEmail().sendKeys("claudiu.maxim@it-teams.com");
        	getFirstName().sendKeys(generateName());
        	getLastName().sendKeys(generateName());
        	getRole().click();
        	getCompounder().click();
        	try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getSend().click();
        }
        
        public void send_Admin_Invitation() {
        	getSendInvite().click();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getEmail().sendKeys("claudiu.maxim@omnisourcetech.com");
        	getFirstName().sendKeys(generateName());
        	getLastName().sendKeys(generateName());
        	getRole().click();
        	getAdmin().click();
        	try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getSend().click();
        }
        
        public void assert_sentInvitation(String expected) {
        	Assert.assertEquals(getToastMessage().getText(), expected);
        }
        
        
    }
    
    public static class PractitionerList extends AdminSettings {

		public PractitionerList(WebDriver driver) {
			super(driver);
		}
    	
    }
    
    public static class PractitionerApplications extends AdminSettings {

		public PractitionerApplications(WebDriver driver) {
			super(driver);
		}
		
		// Page Locators - Filters
		private By appStatus = By.cssSelector(".dx-selectbox-container .dx-dropdowneditor-icon");
        private By newStatus = By.cssSelector("div:nth-of-type(2) > .dx-item-content.dx-list-item-content");
        
        private By startDate = By.cssSelector("[class] [class='col-3']:nth-of-type(2) [aria-haspopup]");
        private By endDate = By.cssSelector("[class] [class='col-3']:nth-of-type(3) [aria-haspopup]");
        
        // Page locators - Datagrid(modal)
        private By applicationDropdown = By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(1) > .dx-datagrid-group-closed");
        private By approve = By.cssSelector("dx-button:nth-of-type(1)  .dx-button-text");
        private By reject = By.cssSelector("dx-button:nth-of-type(2)  .dx-button-text");
        
        // Page locators - Practitioner approval
        private By yes = By.cssSelector(".o-button.o-button--primary.o-button--small");
        private By no = By.cssSelector(".o-button.o-button--secondary.o-button--small");
        
        //Page locators - toast messages
        private By approvalMessage = By.cssSelector("div#toast-container");
        
        
        //Locator GET methods
        public WebElement getAppStatus() {
        	return getElement(appStatus);
        }
        
        public WebElement getNewStatus() {
        	return getElement(newStatus);
        }
        
        public WebElement getStartDate() {
        	return getElement(startDate);
        }
        
        public WebElement getEndDate() {
        	return getElement(endDate);
        }
        
        public WebElement getApplicationDropdown() {
        	return getElement(applicationDropdown);
        }
        
        public WebElement getApprove() {
        	return getElement(approve);
        }
        
        public WebElement getReject() {
        	return getElement(reject);
        }
        
        public WebElement getYes() {
        	return getElement(yes);
        }
        
        public WebElement getNo() {
        	return getElement(no);
        }
        
        public WebElement getApprovalMessage() {
        	return getElement(approvalMessage);
        }
        
        //Page navigation methods
        public void selectStatus_New() {
        	getAppStatus().click();
        	getNewStatus().click();
        }
        
        public void approve_application() {
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	getApplicationDropdown().click();
        	getApprove().click();
        	getYes().click();
        }

        public void assertApproval(String expected) {
        	Assert.assertEquals(getApprovalMessage().getText(), expected);
        }
       
        
        
    }
    
    public static class PharmacySettings extends AdminSettings {

		public PharmacySettings(WebDriver driver) {
			super(driver);
		}
		
		//Page Locators - Main view (the one with tabs)
		private By general = By.cssSelector("div[role='tablist'] > div > div:nth-of-type(1)  .dx-tab-text");
        private By pricing = By.cssSelector("[aria-selected='true'] .dx-tab-text");
        private By shippingPayment = By.cssSelector("div:nth-of-type(3)  .dx-tab-text");
        private By packaging = By.cssSelector("div:nth-of-type(4)  .dx-tab-text");
        private By dispensary = By.cssSelector("div:nth-of-type(5)  .dx-tab-text");
        private By order = By.cssSelector("div:nth-of-type(6)  .dx-tab-text");
        private By ephedraProduct = By.cssSelector("div:nth-of-type(7)  .dx-tab-text");
        
        //Locator GET methods
        public WebElement getGeneral() {
        	return getElement(general);
        }
        
        public WebElement getPricing() {
        	return getElement(pricing);
        }
        
        public WebElement getShippingPayment() {
        	return getElement(shippingPayment);
        }
        
        public WebElement getPackaging() {
        	return getElement(packaging);
        }
        
        public WebElement getDispensary() {
        	return getElement(dispensary);
        }
        
        public WebElement getOrder() {
        	return getElement(order);
        }
        
        public WebElement getEphedraProduct() {
        	return getElement(ephedraProduct);
        }
        
        //Page Navigation Methods
        public GeneralTab enter_GeneralTab() {
        	try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getGeneral().click();
        	return getInstance(GeneralTab.class);
        }
        
        public PricingTab enter_PricingTab() {
        	try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getPricing().click();
        	return getInstance(PricingTab.class);
        }
        
        public ShippingPaymentTab enter_ShippingPaymentTab() {
        	try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getShippingPayment().click();
        	return getInstance(ShippingPaymentTab.class);
        }
        
        public PackagingTab enter_PackagingTab() {
        	try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	getPackaging().click();
        	return getInstance(PackagingTab.class);
        }
        
        public DispensaryTab enter_DispensaryTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDispensary().click();
            return getInstance(DispensaryTab.class);
        }
        
        public OrderTab enter_OrderTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getOrder().click();
            return getInstance(OrderTab.class);
        }
        
        public EphedraProductTab enter_EphedraProductTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getEphedraProduct().click();
            return getInstance(EphedraProductTab.class);
        }
        
        public static class GeneralTab extends PharmacySettings {

			public GeneralTab(WebDriver driver) {
				super(driver);
			}
			
			//Page Locators - general tab main view
			private By hiddenUpload = By.cssSelector("ufc-file-upload[name='file'] > input[type='file']");
            private By hiddenLogo = By.cssSelector("ufc-file-upload[name='logo'] > input[type='file']");
            private By addLogo = By.linkText("ADDLOGO");
            private By save = By.cssSelector(".dx-button-text");
            
            // Toast message
			private By toastMessage = By.cssSelector(".toast-message");
			
            //Upload files relative paths
			String logoPath = "src/main/java/uploadDocuments/300x120.png";
            String termsPath = "src/main/java/uploadDocuments/chart.pdf";
            
            //Locator GET Methods
            public WebElement getHiddenUpload() {
            	return getElement(hiddenUpload);
            }
            
            public WebElement getHiddenLogo() {
            	return getElement(hiddenLogo);
            }
            
            public WebElement getAddLogo() {
            	return getElement(addLogo);
            }
            
            public WebElement getSave() {
            	return getElement(save);
            }
            
            public WebElement getToastMessage() {
            	return getElement(toastMessage);
            }
            
            // Page navigation methods
            public void uploadLogo(String expected) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String basePath = new File(logoPath).getAbsolutePath();
                ((JavascriptExecutor) driver).executeScript(expected, getHiddenLogo());
                getHiddenLogo().sendKeys(basePath);
            }
            
            public void uploadTerms(String expected) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String basePath = new File(termsPath).getAbsolutePath();
                ((JavascriptExecutor) driver).executeScript(expected, getHiddenUpload());
                getHiddenUpload().sendKeys(basePath);
            }
            
            public void saveChanges() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getSave().click();
            }
            
            public void assertUpload(String expected) {
            	Assert.assertEquals(getToastMessage().getText(), expected);
            }
        }
        
        public static class PricingTab extends PharmacySettings {

			public PricingTab(WebDriver driver) {
				super(driver);
			}
		}
        
        public static class ShippingPaymentTab extends PharmacySettings {

			public ShippingPaymentTab(WebDriver driver) {
				super(driver);
			}
			
			//Page Locators - Shipping Payment Tab buttons & inputs
			private By addShipping = By.cssSelector(".clinic-settings-title .dx-button-content");
            private By methodNameInput = By.cssSelector("td:nth-of-type(1) input[role='textbox']");
            private By methodName = By.cssSelector("ufc-settings-shipping dx-data-grid[role='presentation'] > div[role='grid'] > div:nth-of-type(6)  table[role='presentation'] > tbody[role='presentation'] > tr:nth-of-type(1) > td:nth-of-type(1)");
            private By methodPriceInput = By.cssSelector(".dx-texteditor-empty [type='text']");
            private By methodPrice = By.cssSelector("ufc-settings-shipping dx-data-grid[role='presentation'] > div[role='grid'] > div:nth-of-type(6)  table[role='presentation'] > tbody[role='presentation'] > tr:nth-of-type(1) > td:nth-of-type(2)");
            private By save = By.cssSelector(".col-12.page-footer > dx-button[role='button']");
            private By deleteMethod = By.cssSelector("");
            
            //Page Locators - Shipping Payment tab - Payment methods
            private By collectionOutside = By.cssSelector(".dx-scrollview-content [role='option']:nth-of-type(1) .dx-checkbox-icon");
            
            //Page Locators - Toast Message;
            private By toastMessage = By.cssSelector(".toast-message");
            
            
            //Locator GET Methods
            public WebElement getAddShipping() {
            	return getElement(addShipping);
            }
            
            public WebElement getMethodNameInput() {
            	return getElement(methodNameInput);
            }
            
            public WebElement getMethodName() {
            	return getElement(methodName);
            }
            
            public WebElement getMethodPriceInput() {
            	return getElement(methodPriceInput);
            }
            
            public WebElement getMethodPrice() {
            	return getElement(methodPrice);
            }
            
            public WebElement getSave() {
            	return getElement(save);
            }
            
            public WebElement getDeleteMethod() {
            	return getElement(deleteMethod);
            }
            
            public WebElement getCollectionOutside() {
            	return getElement(collectionOutside);
            }
            
            public WebElement getToastMessage() {
            	return getElement(toastMessage);
            }
            
            //Page navigation methods
            public void addShippingMethod() {
            	getAddShipping().click();
            	getMethodNameInput().sendKeys(""); // "testing method" name of method to be added
            	getMethodPrice().click();
            	try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	getMethodPriceInput().sendKeys("");//"15" integer for the method price
            	getCollectionOutside().click();
            }
            
            public void saveChanges() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getSave().click();
            }
            
            public void assert_ShippingMethod_addition(String expected) {
            	Assert.assertEquals(getToastMessage().getText(), expected);
            }
            
            
            
        }
        
        public static class PackagingTab extends PharmacySettings {

			public PackagingTab(WebDriver driver) {
				super(driver);
			}
        	
        }
        
        public static class DispensaryTab extends PharmacySettings {
        	
            public DispensaryTab(WebDriver driver) {
                super(driver);
            }
            
        }
        
        public static class OrderTab extends PharmacySettings {
        	
            public OrderTab(WebDriver driver) {
                super(driver);
            }
            
        }
        
        public static class EphedraProductTab extends PharmacySettings {

			public EphedraProductTab(WebDriver driver) {
				super(driver);
			}
        	
        }
    }
}
