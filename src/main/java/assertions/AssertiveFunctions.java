package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.BasePage;

public class AssertiveFunctions extends BasePage {

	public AssertiveFunctions(WebDriver driver) {
		super(driver);
	}
	
	
	//Export assertion general functions
		// Verify and fail/pass test case
	public void assertExport(String location, String fileName) {
		assertDownload(location, fileName);
	}
		// Check if the file exists and delete if so
	public void isFileDownloaded(String location, String fileName) {
		checkIfFileExists(location, fileName);
	}
	
	//Assert messages
	public void asserTestCase(WebElement locator, String expected) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(getElement((By) locator), expected);
	}

}
