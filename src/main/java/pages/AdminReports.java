package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminReports extends BasePage {

	public AdminReports(WebDriver driver) {
		super(driver);
	}

	// Page locators - main page
	private By reportsDropdown = By
			.cssSelector("li:nth-of-type(5)  .material-icons.ng-star-inserted.site-menu-icon.sub-indicator");
	private By orderReport = By.cssSelector(".site-menu-sub-item.ng-star-inserted .site-menu-title");
	private By lotNrRecall = By
			.cssSelector(".site-menu li:nth-of-type(5) .ng-star-inserted:nth-of-type(3) .site-menu-title");
	
	// Locators GET functions
	public WebElement getReportsDropdown() {
		return getElement(reportsDropdown);
	}
	
	public WebElement getOrderReport() {
		return getElement(orderReport);
	}

	public WebElement getLotNrRecall() {
		return getElement(lotNrRecall);
	}
	
	

	// Page Navigation methods
	public AdminOrderReportPage enter_OrderReportPage() {
		getReportsDropdown().click();
		getOrderReport().click();
		return getInstance(AdminOrderReportPage.class);
	}

	public LotNumberRecallReport enter_LotNumberRecallReportPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getReportsDropdown().click();
		getLotNrRecall().click();
		return getInstance(LotNumberRecallReport.class);
	}

	public static class AdminOrderReportPage extends AdminReports {

		public AdminOrderReportPage(WebDriver driver) {
			super(driver);
		}

		// Page locators - AdminOrderReport Page
		private By searchBar = By.cssSelector("input[role='textbox']");
		private By exportCSV = By.cssSelector("ufc-orders-financial-report a");

		// Get locators functions
		public WebElement getExportCSV() {
			return getElement(exportCSV);
		}

		public WebElement getSearchBar() {
			return getElement(searchBar);
		}

		
		// Page Navigation Methods
		public void exportFile() {
			getExportCSV().click();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static class LotNumberRecallReport extends AdminReports {

		public LotNumberRecallReport(WebDriver driver) {
			super(driver);
		}

		// Page Locators - main page
		private By exportCSV = By
				.cssSelector(".col-sm-6.col-xs-12.lot-number-recall-report__export.text-right > a > span");
		private By startDate = By.cssSelector("[class='col-xl-2  col-lg-3  col-md-3  col-sm-6  col-xs-12'] [aria-haspopup]");
		private By endDate = By.cssSelector("[class=' col-xl-2 col-lg-3 col-md-3 col-sm-6 col-xs-12'] [aria-haspopup]");
		
		// Get locators functions
		public WebElement getExportCSV() {
			return getElement(exportCSV);
		}
		
		public WebElement getStartDate() {
			return getElement(startDate);
		}
		
		public WebElement getEndDate() {
			return getElement(endDate);
		}

		//Page Navigation methods
		public void exportCSV() {
			getExportCSV().click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void setStartDate(String expected) {
			getStartDate().clear();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getStartDate().sendKeys(expected);
		}
		
		public void setEndDate(String expected) {
			getEndDate().clear();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getEndDate().sendKeys(expected);
		}


		//// Pending assertions//////////////////////////////////////
		/////////////////////////////////////////////////////////////
	}

}
