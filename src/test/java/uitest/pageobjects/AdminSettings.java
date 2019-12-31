// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.io.File;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class AdminSettings extends BasePage {
    public AdminSettings(WebDriver driver) {
        super(driver);
    }

    // Settings + under settings menuuu
    @FindBy(css = "li:nth-of-type(3)  .material-icons.ng-star-inserted.site-menu-icon.sub-indicator")
    WebElement settings;

    @FindBy(css = ".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(2) .site-menu-title")
    WebElement userList;
    @FindBy(css = ".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(3) .site-menu-title")
    WebElement practitionerList;
    @FindBy(css = ".site-menu li:nth-of-type(3) .ng-star-inserted:nth-of-type(4) .site-menu-title")
    WebElement practitionerApplications;
    @FindBy(css = "li:nth-of-type(3) > .ng-star-inserted.site-menu-sub > li:nth-of-type(5) > .ng-star-inserted  .site-menu-title")
    WebElement pharmacySettings;

    public UserList enter_UserList() {
        waitElement(userList);
        click(userList);
        return new UserList(driver);
    }

    public PractitionerList enter_PractitionerList() {
        waitElement(practitionerList);
        click(practitionerList);
        return new PractitionerList(driver);
    }

    public AdminSettings enter_PractitionerApplications() {
        waitElement(practitionerApplications);
        click(practitionerApplications);
        return new AdminSettings(driver);
    }

    public PharmacySettings enter_PharmacySettings() {
        waitElement(pharmacySettings);
        click(pharmacySettings);
        return new PharmacySettings(driver);
    }

    public static class UserList extends AdminSettings {
        public UserList(WebDriver driver) {
            super(driver);
        }

        @FindBy(linkText = "Send User Invite")
        WebElement sendInvite;
        @FindBy(css = ".dx-editor-underlined.dx-show-clear-button.dx-textbox.dx-texteditor.dx-texteditor-empty.dx-widget.ng-invalid.ng-pristine.ng-touched.user-box__input  input[role='textbox']")
        WebElement firstName;
        @FindBy(css = "ufc-form-render .ng-touched:nth-of-type(2) [type]")
        WebElement lastName;
        @FindBy(css = "ufc-form-render .ng-touched:nth-of-type(3) [type]")
        WebElement email;
        @FindBy(css = ".dx-dropdowneditor-icon")
        WebElement role;
        @FindBy(css = ".dx-scrollview-content")
        List<WebElement> roleList;
        @FindBy(css = ".dx-button-text")
        WebElement send;

        public void sendInvitation(String expectedRole, String expectedEmail) {
            waitElement(sendInvite);
            click(sendInvite);
            waitElement(firstName);
            writeText(email, expectedEmail);
            randomName(firstName);
            randomName(lastName);
            click_element_from_dropdown(role, roleList, expectedRole);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(send);
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

        // Filters
        @FindBy(css = ".dx-selectbox-container .dx-dropdowneditor-icon")
        WebElement appStatus;
        @FindBy(css = "div:nth-of-type(2) > .dx-item-content.dx-list-item-content")
        WebElement newStatus;

        @FindBy(css = "[class] [class='col-3']:nth-of-type(2) [aria-haspopup]")
        WebElement startDate;
        @FindBy(css = "[class] [class='col-3']:nth-of-type(3) [aria-haspopup]")
        WebElement endDate;

        // Datagrid
        @FindBy(css = "tr:nth-of-type(1) > td:nth-of-type(1) > .dx-datagrid-group-closed")
        WebElement applicationDropdown;
        @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
        WebElement approve;
        @FindBy(css = "dx-button:nth-of-type(2)  .dx-button-text")
        WebElement reject;

        // Practitioner approval
        @FindBy(css = ".o-button.o-button--primary.o-button--small")
        WebElement yes;
        @FindBy(css = ".o-button.o-button--secondary.o-button--small")
        WebElement no;

        // Error messages
        @FindBy(css = "div#toast-container")
        WebElement approvalMessage;

        public void selectStatus_New() {
            waitElement(appStatus);
            click(appStatus);
            click(newStatus);
        }

        public void approve_application() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(applicationDropdown);
            click(approve);
            waitElement(yes);
            click(yes);
        }

        public void assert_approval(String expected) {
            Assert.assertEquals(readText(approvalMessage), expected);
        }

    }

    public static class PharmacySettings extends AdminSettings {
        public PharmacySettings(WebDriver driver) {
            super(driver);
        }

        // Main Pharmacy Settings tab
        @FindBy(css = "div[role='tablist'] > div > div:nth-of-type(1)  .dx-tab-text")
        WebElement general;
        @FindBy(css = "[aria-selected='true'] .dx-tab-text")
        WebElement pricing;
        @FindBy(css = "div:nth-of-type(3)  .dx-tab-text")
        WebElement shippingPayment;
        @FindBy(css = "div:nth-of-type(4)  .dx-tab-text")
        WebElement packaging;
        @FindBy(css = "div:nth-of-type(5)  .dx-tab-text")
        WebElement dispensary;
        @FindBy(css = "div:nth-of-type(6)  .dx-tab-text")
        WebElement order;
        @FindBy(css = "div:nth-of-type(7)  .dx-tab-text")
        WebElement ephedraProduct;

        public GeneralTab enter_GeneralTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(general);
            return new GeneralTab(driver);
        }

        public PricingTab enter_PricingTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(pricing);
            return new PricingTab(driver);
        }

        public ShippingPaymentTab enter_ShippingPaymentTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(shippingPayment);
            return new ShippingPaymentTab(driver);
        }

        public PackagingTab enter_PackagingTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(packaging);
            return new PackagingTab(driver);
        }

        public DispensaryTab enter_DispensaryTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(dispensary);
            return new DispensaryTab(driver);
        }

        public OrderTab enter_OrderTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(order);
            return new OrderTab(driver);
        }

        public EphedraProductTab enter_EphedraProductTab() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(ephedraProduct);
            return new EphedraProductTab(driver);
        }

        public static class GeneralTab extends PharmacySettings {
            public GeneralTab(WebDriver driver) {
                super(driver);
            }

            @FindBy(css = "ufc-file-upload[name='file'] > input[type='file']")
            WebElement hiddenUpload;
            @FindBy(css = "ufc-file-upload[name='logo'] > input[type='file']")
            WebElement hiddenLogo;
            @FindBy(linkText = "ADDLOGO")
            WebElement addLogo;
            @FindBy(css = ".dx-button-text")
            WebElement save;

            // Toast messages
            @FindBy(css = ".toast-message")
            WebElement toastMessage;

            String logoPath = "src/test/java/uitest/uploadDocuments/300x120.png";
            String termsPath = "src/test/java/uitest/uploadDocuments/chart.pdf";

            public void uploadLogo(String expected) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String basepath = new File(logoPath).getAbsolutePath();
                ((JavascriptExecutor) driver).executeScript(expected, hiddenLogo);
                writeText(hiddenLogo, basepath);
            }

            public void uploadTerms(String expected) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String basepath = new File(termsPath).getAbsolutePath();
                ((JavascriptExecutor) driver).executeScript(expected, hiddenUpload);
                writeText(hiddenUpload, basepath);
            }

            public void saveChanges() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                click(save);
            }

            public void assertUploads(String expected) {
                waitElement(toastMessage);
                Assert.assertEquals(readText(toastMessage), expected);
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

            // Shipping Payment Tab buttons + inputs
            @FindBy(css = ".clinic-settings-title .dx-button-content")
            WebElement addShipping;
            @FindBy(css = "td:nth-of-type(1) input[role='textbox']")
            WebElement methodNameInput;
            @FindBy(css = "ufc-settings-shipping dx-data-grid[role='presentation'] > div[role='grid'] > div:nth-of-type(6)  table[role='presentation'] > tbody[role='presentation'] > tr:nth-of-type(1) > td:nth-of-type(1)")
            WebElement methodName;
            @FindBy(css = ".dx-texteditor-empty [type='text']")
            WebElement methodPriceInput;
            @FindBy(css = "ufc-settings-shipping dx-data-grid[role='presentation'] > div[role='grid'] > div:nth-of-type(6)  table[role='presentation'] > tbody[role='presentation'] > tr:nth-of-type(1) > td:nth-of-type(2)")
            WebElement methodPrice;
            @FindBy(css = ".col-12.page-footer > dx-button[role='button']")
            WebElement save;
            @FindBy(css = "")
            WebElement deleteMethod;
            // Payment Methods
            @FindBy(css = ".dx-scrollview-content [role='option']:nth-of-type(1) .dx-checkbox-icon")
            WebElement collectionOutside;
            // Toast message
            @FindBy(css = ".toast-message")
            WebElement toastMessage;

            public void addShippingMethod() {
                waitElement(addShipping);
                click(addShipping);
                writeText(methodNameInput, "TestingMethod");
                click(methodPrice);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeText(methodPriceInput, "15");
                click(collectionOutside);
            }

            public void saveChanges() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                click(save);
            }

            public void assertChanges(String expected) {
                waitElement(toastMessage);
                Assert.assertEquals(readText(toastMessage), expected);
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

            @FindBy(css = ".dx-dropdowneditor-icon")
            WebElement loadProducts;
            @FindBy(css = ".dx-scrollview-content > div:nth-of-type(1) .col-4")
            WebElement product;
            @FindBy(css = "ufc-settings-ephedra-product .dx-button-text")
            WebElement save;
            @FindBy(css = ".c-user-box [data-max-size]")
            WebElement waiverInput;
            @FindBy(css = ".dx-show-clear-button.ng-touched [type='text']")
            WebElement normalThresh;
            @FindBy(css = "[class='col-6']:nth-of-type(2) [type='text']")
            WebElement maxThresh;
            @FindBy(css = ".toast-message")
            WebElement toastMessage;
            String filePath = "";

            public void selectProduct() {
                waitElement(loadProducts);
                click(loadProducts);
                waitElement(product);
                click(product);
            }

            public void setThresholds() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeText(normalThresh, "10");
                writeText(maxThresh, "20");
            }

            // test
            public void uploadWaiver(String expected) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String basepath = new File(filePath).getAbsolutePath();
                ((JavascriptExecutor) driver).executeScript(expected, waiverInput);
                writeText(waiverInput, basepath);
            }

            public void saveEphedra() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                click(save);
            }

            public void assertChanges(String expected) {
                waitElement(toastMessage);
                Assert.assertEquals(readText(toastMessage), expected);
            }
        }
    }
}
