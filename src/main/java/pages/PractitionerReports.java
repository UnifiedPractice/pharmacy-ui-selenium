package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractitionerReports extends BasePage {

	public PractitionerReports(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators - report Button 
	//locators to be added after removing PractitionerHomePage and AdminHomePage
	
	
	public static class PractitionerOrderReportPage extends PractitionerReports{
		
		public PractitionerOrderReportPage(WebDriver driver) {
			super(driver);
		}
		
		//Page Locators
		private By searchBar = By.cssSelector("input[role='textbox']");
		private By exportCSV = By.cssSelector("ufc-orders-financial-report a");
		
		//Locator GET functions
		public WebElement getSearchBar() {
			return getElement(searchBar);
		}
		public WebElement getExportButton() {
			return getElement(exportCSV);
		}
		
		
		//Page Navigation Methods
		public void exportFile() {
			getExportButton().click();
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
