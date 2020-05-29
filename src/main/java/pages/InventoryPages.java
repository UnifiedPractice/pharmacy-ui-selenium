package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InventoryPages extends BasePage {

	public InventoryPages(WebDriver driver) {
		super(driver);
	}

	// Page locators
	private By inventoryDropdown = By.cssSelector(".site-menu li:nth-of-type(2) .material-icons.ng-star-inserted");
	private By productCatalog = By.linkText("Product Catalog");
	private By thresholdReport = By.linkText("Threshold Report");
	private By medium = By.linkText("Medium Management");
	private By lotNrReport = By.linkText("Expired Lot Number Report");

	// Get methods
	public WebElement getInventoryDropdown() {
		return getElement(inventoryDropdown);
	}

	public WebElement getProductCatalog() {
		return getElement(productCatalog);
	}

	public WebElement getThresholdReport() {
		return getElement(thresholdReport);
	}

	public WebElement getMedium() {
		return getElement(medium);
	}

	public WebElement getLotNrReport() {
		return getElement(lotNrReport);
	}
	
	
	// Methods
	public ProductCatalog enter_ProductCatalog() {
		getInventoryDropdown().click();
		getProductCatalog().click();
		return getInstance(ProductCatalog.class);
	}

	public ThresholdReport enter_ThresholdReport() {
		getInventoryDropdown().click();
		getThresholdReport().click();
		return getInstance(ThresholdReport.class);
	}

	public MediumManagement enter_MediumManagement() {
		getInventoryDropdown().click();
		getMedium().click();
		return getInstance(MediumManagement.class);
	}

	public ExpiredLotNumber enter_ExpiredLotNumber() {
		getInventoryDropdown().click();
		getLotNrReport().click();
		return getInstance(ExpiredLotNumber.class);
	}

	public static class ProductCatalog extends InventoryPages {

		public ProductCatalog(WebDriver driver) {
			super(driver);
		}

		// Page locators - Adjust buttons
		private By adjust = By.cssSelector("dx-button:nth-of-type(1)  .dx-button-text");
		private By adjustDropdown = By.cssSelector("[displayexpr='itemName'] .dx-texteditor-buttons-container");
		private By adjustDropdownSelection = By.cssSelector(".dx-scrollview-content > div:nth-of-type(1) .col-4");
		private By typeAdd = By.cssSelector(".dx-buttongroup-wrapper [role='button']:nth-of-type(1) .dx-button-text");
		private By typeRemove = By
				.cssSelector(".dx-buttongroup-wrapper [role='button']:nth-of-type(2) .dx-button-text");
		private By lotNumber = By.cssSelector("[displayexpr='lotNumber'] .dx-dropdowneditor-icon");
		private By lotNumberSelection = By
				.cssSelector(".dx-scrollview-content > div:nth-of-type(1)  .lot-autocomplete__box-res");
		private By lotQuantity = By.cssSelector("input[role='spinbutton']");
		private By saveBtn = By.cssSelector("[type] .dx-button-text");

		// Page locators - Receive buttons
		private By receive = By.cssSelector("dx-button:nth-of-type(2)  .dx-button-text");
		private By expiryDate = By.cssSelector(".dx-dropdowneditor.dx-datebox-calendar [aria-haspopup]");

		// Page locators - Import Chinese Names
		private By importChinese = By.linkText("file_uploadImport Chinese Names");
		private By hiddenUpload = By
				.cssSelector("ufc-file-upload[name='file'] > input[type='file']");
		private By successMessage = By.xpath(
				"//body/ufc-names-import-modal/div/div/div[@class='modal-content']//div[@class='col-12 import-results']/span[@class='ng-star-inserted']");
		private By toastMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']");
		private By importCSV = By.cssSelector(".col-12.text-right > dx-button[role='button']  span");
		
		private By chineseImportMessage = By.cssSelector("[class='col-12 import-results'] .ng-star-inserted");
		// Upload path for Import Chinese Names
		String filePath = "src/main/java/uploadDocuments/import chinese names.csv";

		// Get locators Methods
		public WebElement getAdjust() {
			return getElement(adjust);
		}

		public WebElement getAdjustDropdown() {
			return getElement(adjustDropdown);
		}

		public WebElement getAdjustDropdownSelection() {
			return getElement(adjustDropdownSelection);
		}

		public WebElement getTypeAdd() {
			return getElement(typeAdd);
		}

		public WebElement getTypeRemove() {
			return getElement(typeRemove);
		}

		public WebElement getLotNumber() {
			return getElement(lotNumber);
		}

		public WebElement getLotNumberSelection() {
			return getElement(lotNumberSelection);
		}

		public WebElement getLotQuantity() {
			return getElement(lotQuantity);
		}

		public WebElement getSaveBtn() {
			return getElement(saveBtn);
		}

		public WebElement getReceive() {
			return getElement(receive);
		}

		public WebElement getExpiryDate() {
			return getElement(expiryDate);
		}

		public WebElement getImportChinese() {
			return getElement(importChinese);
		}

		public WebElement getHiddenUpload() {
			return getElement(hiddenUpload);
		}

		public WebElement getSuccessMessage() {
			return getElement(successMessage);
		}

		public WebElement getToastMessage() {
			return getElement(toastMessage);
		}

		public WebElement getImportCSV() {
			return getElement(importCSV);
		}
		
		public WebElement getChineseImportMessage() {
		return getElement(chineseImportMessage);
		}

		// Methods
		public void startAdjust() {
			getAdjust().click();
		}

		public void startReceive() {
			getReceive().click();
		}

		public void selectItem() {
			getAdjustDropdown().click();
			getAdjustDropdownSelection().click();
		}

		public void quantityAddition(String expected) {
			getTypeAdd().click();
			getLotNumber().click();
			getLotNumberSelection().click();
			getLotQuantity().sendKeys(expected);// expected text to get completed (LOT QUANTITY)
			getSaveBtn().click();
		}

		public void quantityRemoval(String expected) {
			getTypeRemove().click();
			getLotNumber().click();
			getLotNumberSelection().click();
			getLotQuantity().sendKeys(expected);// expected text to get completed (LOT QUANTITY)
			getSaveBtn().click();
		}

		public void quantityReceival(String quantity, String date) {
			getLotQuantity().sendKeys(quantity);// quantity to be added
			getExpiryDate().sendKeys(date);// to set expiry date
			getLotNumber().click();
			getLotNumberSelection().click();
			getSaveBtn().click();
		}
		
		public void uploadFile(String expected) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getImportChinese().click();
			String basepath = new File(filePath).getAbsolutePath();
			((JavascriptExecutor) driver).executeScript(expected, getHiddenUpload());
			getHiddenUpload().sendKeys(basepath);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getImportCSV().click();
		}

		public void assertImport(String expected) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(getToastMessage().getText(), expected);
		}

		public void assert_ImportChineseNames(String expected) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(getSuccessMessage().getText(), expected);
		}
		
		public void assertAdjustment(String expected) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(getToastMessage().getText(), expected);
		}
	}

	public static class ThresholdReport extends InventoryPages {

		public ThresholdReport(WebDriver driver) {
			super(driver);
		}

		// Page Locators - Main Page buttons
		private By inventoryLocation = By.xpath(
				"//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']/div[@class='m-threshold-report-page']//ufc-location-select-box//dx-select-box//div[@role='button']//div[@class='dx-dropdowneditor-icon']");

		private By language = By.xpath(
				"//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']/div[@class='m-threshold-report-page']/div[@class='panel']//dx-drop-down-box//dx-text-box//div[@role='button']//i[@class='material-icons']");

		private By generateList = By.xpath(
				"//body/up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-threshold-report-page[@class='ng-star-inserted']//dx-button[@role='button']//span[@class='dx-button-text']");

		private By requestedQ1 = By.xpath(
				"//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody/tr[1]/td[10]");

		private By requestedQ1Input = By.xpath(
				"//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td[10]//input[@role='spinbutton']");

		private By requestedQ2 = By.xpath(
				"//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody/tr[2]/td[10]");

		private By requestedQ2Input = By.xpath(
				"//up-root/up-container[@class='ng-star-inserted']//ufc-threshold-report-page[@class='ng-star-inserted']//dx-data-grid[@role='presentation']/div[@role='grid']/div[6]//table[@role='presentation']/tbody[@role='presentation']/tr[2]/td[10]//input[@role='spinbutton']");

		// Page locators - pop-up buttons
		private By sendList = By.xpath(
				"//body/ufc-threshold-items-modal/div/div[@class='modal-dialog threshold-items-modal-dialog']//dx-button[@role='button']//span[@class='dx-button-text']");

		private By exportCSV = By.xpath(
				"//body/ufc-threshold-items-modal/div/div[@class='modal-dialog threshold-items-modal-dialog']//a[@href='javascript:void(0)']/span[.='Export CSV']");

		// Locator GET Methods
		public WebElement getInventoryLocation() {
			return getElement(inventoryLocation);
		}

		public WebElement getLanguage() {
			return getElement(language);
		}

		public WebElement getGenerateList() {
			return getElement(generateList);
		}

		public WebElement getRequestedQ1() {
			return getElement(requestedQ1);
		}

		public WebElement getRequestedQ1Input() {
			return getElement(requestedQ1Input);
		}

		public WebElement getRequestedQ2() {
			return getElement(requestedQ2);
		}

		public WebElement getRequestedQ2Input() {
			return getElement(requestedQ2Input);
		}

		public WebElement getSendList() {
			return getElement(sendList);
		}

		public WebElement getExportCSV() {
			return getElement(exportCSV);
		}

		// Page Navigation Methods
		public void generateExportList() {
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			getRequestedQ1Input().click();
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			getRequestedQ1Input().sendKeys("123");
			getRequestedQ2Input().click();
			getRequestedQ2Input().sendKeys("123");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getGenerateList().click();
			getExportCSV().click();
		}

		public void assertExport() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// assertDownload(fileName);
		}
	}

	public static class MediumManagement extends InventoryPages {

		public MediumManagement(WebDriver driver) {
			super(driver);
		}

		// Available buttons
		private By addMedium = By
				.cssSelector("[class='col-xl-6  col-lg-12 medium-management__grid-title'] .dx-button-text");
		private By save = By.cssSelector(".col-12.page-footer > dx-button[role='button']  .dx-button-text");
		private By firstMedium = By.cssSelector("input");
		private By secondMedium = By.cssSelector("tr:nth-of-type(2) > td[role='gridcell']");
		// Notification
		private By toastMessage = By.cssSelector(".toast-message");

		// Get locator methods
		public WebElement getAddMedium() {
			return getElement(addMedium);
		}

		public WebElement getSave() {
			return getElement(save);
		}

		public WebElement getFirstMedium() {
			return getElement(firstMedium);
		}

		public WebElement getSecondMedium() {
			return getElement(secondMedium);
		}

		public WebElement getToastMessage() {
			return getElement(toastMessage);
		}

		// Methods
		public void addMedium(String expected) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getAddMedium().click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getFirstMedium().sendKeys(expected);
			getSecondMedium().click();
			getSave().click();
		}

		public void assertMedium(String expected) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(getToastMessage().getText(), expected);
		}
	}

	public static class ExpiredLotNumber extends InventoryPages {

		public ExpiredLotNumber(WebDriver driver) {
			super(driver);
		}

		// Page locators
		private By exportCSV = By
				.cssSelector("[class='col-sm-6  col-xs-12  text-right  expired-lot-report__export'] span");
		private By searchBar = By.cssSelector("input[role='textbox']");

		// Get Methods
		public WebElement getExportCSV() {
			return getElement(exportCSV);
		}

		public WebElement getSearchBar() {
			return getElement(searchBar);
		}

		public void exportFile() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getExportCSV().click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void assertExport() {
			// pending implementation (assertDownload)
		}
	}

}
