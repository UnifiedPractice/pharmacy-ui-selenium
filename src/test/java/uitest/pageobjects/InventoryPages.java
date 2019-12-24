// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class InventoryPages extends BasePage {
    public InventoryPages(WebDriver driver) {
        super(driver);
    }

    // Inventory dropdown arrow
    @FindBy(css = ".site-menu li:nth-of-type(2) .material-icons.ng-star-inserted")
    WebElement inventory;
    // Inventory Drop-down buttons
    @FindBy(linkText = "Product Catalog")
    WebElement productCatalog;
    @FindBy(linkText = "Threshold Report")
    WebElement thresholdReport;
    @FindBy(linkText = "Medium Management")
    WebElement medium;
    @FindBy(linkText = "Expired Lot Number Report")
    WebElement lotNrReport;

    public ProductCatalog enter_ProductCatalog() {
        waitElement(inventory);
        click(inventory);
        waitElement(productCatalog);
        click(productCatalog);
        return new ProductCatalog(driver);
    }

    public ThresholdReport enter_ThresholdReport() {
        waitElement(inventory);
        click(inventory);
        waitElement(thresholdReport);
        click(thresholdReport);
        return new ThresholdReport(driver);
    }

    public MediumManagement enter_MediumManagement() {
        waitElement(inventory);
        click(inventory);
        waitElement(medium);
        click(medium);
        return new MediumManagement(driver);
    }

    public ExpiredLotNumber enter_ExpiredLotNumber() {
        waitElement(inventory);
        click(inventory);
        waitElement(lotNrReport);
        click(lotNrReport);
        return new ExpiredLotNumber(driver);
    }

    public static class ProductCatalog extends InventoryPages {

        public ProductCatalog(WebDriver driver) {
            super(driver);
        }

        // Adjust buttons
        @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
        WebElement adjust;
        @FindBy(css = "[displayexpr='itemName'] .dx-texteditor-buttons-container")
        WebElement adjustDropdown;
        @FindBy(css = ".dx-scrollview-content > div:nth-of-type(1) .col-4")
        WebElement adjustDropdownSelection;
        @FindBy(css = ".dx-buttongroup-wrapper [role='button']:nth-of-type(1) .dx-button-text")
        WebElement typeAdd;
        @FindBy(css = ".dx-buttongroup-wrapper [role='button']:nth-of-type(2) .dx-button-text")
        WebElement typeRemove;
        @FindBy(css = "[displayexpr='lotNumber'] .dx-dropdowneditor-icon")
        WebElement lotNumber;
        @FindBy(css = ".dx-scrollview-content > div:nth-of-type(1)  .lot-autocomplete__box-res")
        WebElement lotNumberSelection;
        @FindBy(css = "input[role='spinbutton']")
        WebElement lotQuantity;
        @FindBy(css = "[type] .dx-button-text")
        WebElement saveBtn;

        // Receive buttons
        @FindBy(css = "dx-button:nth-of-type(2)  .dx-button-text")
        WebElement receive;
        @FindBy(css = ".dx-dropdowneditor.dx-datebox-calendar [aria-haspopup]")
        WebElement expiryDate;
        // Notification
        @FindBy(xpath = "//div[@id='toast-container']//div[@role='alertdialog']")
        WebElement toastMessage;

        // Import Chinese Names
        @FindBy(linkText = "file_uploadImport Chinese Names")
        WebElement importChinese;
        @FindBy(xpath = "//body/ufc-names-import-modal/div/div//ufc-file-upload[@name='file']/input[@type='file']")
        WebElement hiddenUpload;
        @FindBy(xpath = "//body/ufc-names-import-modal/div/div/div[@class='modal-content']//div[@class='col-12 import-results']/span[@class='ng-star-inserted']")
        WebElement successMessage;
        @FindBy(css = ".col-12.text-right > dx-button[role='button']  span")
        WebElement importCSV;
        String filePath = "src/test/java/uitest/uploadDocuments/import chinese names.csv";

        public void startAdjust() {
            waitElement(adjust);
            click(adjust);
        }

        public void startReceive() {
            waitElement(receive);
            click(receive);
        }

        public void selectItem() {
            waitElement(adjustDropdown);
            click(adjustDropdown);
            waitElement(adjustDropdownSelection);
            click(adjustDropdownSelection);
        }

        public void quantityAddition(String expectedText) {
            waitElement(typeAdd);
            click(typeAdd);
            click(lotNumber);
            waitElement(lotNumberSelection);
            click(lotNumberSelection);
            writeText(lotQuantity, expectedText);
            click(saveBtn);
        }

        public void quantityRemoval(String expectedText) {
            waitElement(typeRemove);
            click(typeRemove);
            click(lotNumber);
            waitElement(lotNumberSelection);
            click(lotNumberSelection);
            writeText(lotQuantity, expectedText);
            click(saveBtn);
        }

        public void quantityReceival(String lotQ, String expiryD) {
            waitElement(lotNumber);
            writeText(lotQuantity, lotQ);
            writeText(expiryDate, expiryD);
            click(lotNumber);
            waitElement(lotNumberSelection);
            click(lotNumberSelection);
            click(saveBtn);
        }

        public void uploadFile(String expected) throws InterruptedException {
            Thread.sleep(2000);
            click(importChinese);
            Thread.sleep(1500);
            String basepath = new File(filePath).getAbsolutePath();
            ((JavascriptExecutor) driver).executeScript(expected, hiddenUpload);
            writeText(hiddenUpload, basepath);
            Thread.sleep(1500);
            click(importCSV);
        }

        public void assertImport(String expected) {
            waitElement(successMessage);
            Assert.assertEquals(readText(successMessage), expected);
        }

        public void assertChange(String expectedText) {
            waitElement(toastMessage);
            System.out.println("Toast message text is: " + readText(toastMessage));
            Assert.assertEquals(readText(toastMessage), expectedText);
        }

    }

    public static class ThresholdReport extends InventoryPages {
        public ThresholdReport(WebDriver driver) {
            super(driver);
        }

        // Main Page Buttons
        @FindBy(xpath = "//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']/div[@class='m-threshold-report-page']//ufc-location-select-box//dx-select-box//div[@role='button']//div[@class='dx-dropdowneditor-icon']")
        WebElement inventoryLocation;
        @FindBy(xpath = "//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']/div[@class='m-threshold-report-page']/div[@class='panel']//dx-drop-down-box//dx-text-box//div[@role='button']//i[@class='material-icons']")
        WebElement language;
        @FindBy(xpath = "//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']//dx-button[@role='button']//span[@class='dx-button-text']")
        WebElement generateList;
        @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody/tr[1]/td[10]")
        WebElement requestedQ1;
        @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td[10]//input[@role='spinbutton']")
        WebElement requestedQ1Input;
        @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody/tr[2]/td[10]")
        WebElement requestedQ2;
        @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody[@role='presentation']/tr[2]/td[10]//input[@role='spinbutton']")
        WebElement requestedQ2Input;

        // PopUp buttons
        @FindBy(xpath = "//body/ufc-threshold-items-modal/div/div[@class='modal-dialog threshold-items-modal-dialog']//dx-button[@role='button']//span[@class='dx-button-text']")
        WebElement sendList;
        @FindBy(xpath = "//body/ufc-threshold-items-modal/div/div[@class='modal-dialog threshold-items-modal-dialog']//a[@href='javascript:void(0)']/span[.='Export CSV']")
        WebElement exportCSV;

        public void generateExportList() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            click(requestedQ1Input);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            writeText(requestedQ1Input, "123");
            click(requestedQ2);
            writeText(requestedQ2Input, "123");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(generateList);
            waitElement(exportCSV);
            click(exportCSV);
        }

        public void asserExport(String fileName) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertDownload(fileName);
        }

    }

    public static class MediumManagement extends InventoryPages {
        public MediumManagement(WebDriver driver) {
            super(driver);
        }

        // Available buttons
        @FindBy(css = "[class='col-xl-6  col-lg-12 medium-management__grid-title'] .dx-button-text")
        WebElement addMedium;
        @FindBy(css = ".col-12.page-footer > dx-button[role='button']  .dx-button-text")
        WebElement save;
        @FindBy(css = "input")
        WebElement addedMedium;

        // Notification
        @FindBy(css = ".toast-message")
        WebElement successNotification;

        public void addMedium() { //pending implementation
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // waitElement(addMedium);
            click(addMedium);
            // waitElement(addedMedium);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            click(addedMedium);
            writeText(addedMedium, "MediumTest");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            click("[role] [role='presentation']:nth-of-type(5) tbody [role='presentation']");
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].removeAttribute('disabled','disabled')",
            // save);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(save);
        }

        public void assertMedium() {
            waitElement(successNotification);
            Assert.assertEquals(readText(successNotification), "Medium saved successfully");
        }
    }

    public static class ExpiredLotNumber extends InventoryPages {
        public ExpiredLotNumber(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = "[class='col-sm-6  col-xs-12  text-right  expired-lot-report__export'] span")
        WebElement exportCSV;
        @FindBy(css = "input[role='textbox']")
        WebElement searchBar;

        public void exportFile() {
            waitElement(exportCSV);
            click(exportCSV);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void assertExport(String fileName) {
            assertDownload(fileName);
        }
    }

}
