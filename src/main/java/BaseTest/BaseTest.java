package BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.Page;
import variables.Variables;

public class BaseTest {

	public static WebDriver driver;
	public Page page;
	public ExtentReports extent;
	public ExtentTest logger;

	
	@BeforeMethod
	@Parameters(value = { "browser", "url" })
	public void setUp(String browser, String url) {

		// Browser selection
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			// Setting Chrome options (download directory)
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", Variables.downloadFilepathChrome);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			

			driver = new ChromeDriver(options);

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxProfile profile = new FirefoxProfile();
			// Setting preferences (download location path, accepted formats)
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", Variables.downloadFilepathFirefox);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application" + "/java-archive, "
					+ "application/x-msexcel," + "application/excel,"
					+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document,"
					+ "application/x-excel," + "application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,"
					+ "application/msword," + "application/xml," + "application/vnd.microsoft.portable-executable");
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.setProfile(profile);

			driver = new FirefoxDriver(option);

		} else {
			System.out.println("No browser is defined in the XML file..");
		}

		driver.manage().window().maximize();
		driver.get(url);
		page = new BasePage(driver);

	}

	
	public void takeScreenshot(String methodName, String testStatus) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + testStatus
					+ methodName + ".jpg";
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static HashMap<String, String> getCredentials() {
		HashMap <String, String> userMap = new HashMap <String, String>();
		userMap.put("admin", "admin@mail.com:Up1234$#@!");
		userMap.put("practitioner", "practitioner@mail.com:Up1234$#@!");
		userMap.put("CSR", "CSR@mail.com:Up1234$#@!");
		return userMap;
								 
	}

	/*
	 * public String getScreenshot(WebDriver driver, String screenshotName) { String
	 * dateName = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
	 * TakesScreenshot ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir") + File.separator + "screenshots" +
	 * File.separator + screenshotName + dateName + ".png"; File finalDestination =
	 * new File(destination); FileUtils.copyFile(source, finalDestination); return
	 * destination; }
	 */

	@AfterMethod
	public void tearDown() {
		/*
		 * if (result.getStatus() == ITestResult.FAILURE) { logger.log(LogStatus.FAIL,
		 * "Test case FAILED is " + result.getName()); logger.log(LogStatus.FAIL,
		 * "Test case FAILED is " + result.getThrowable()); String screenshotPath =
		 * getScreenshot(result.getName()); logger.log(LogStatus.FAIL,
		 * logger.addScreencast(screenshotPath));
		 * 
		 * } else if (result.getStatus() == ITestResult.SKIP) {
		 * logger.log(LogStatus.SKIP, "Test case SKIPPED is " + result.getName());
		 * 
		 * } else if (result.getStatus() == ITestResult.SUCCESS) {
		 * logger.log(LogStatus.PASS, "Test case PASSED is " + result.getName()); }
		 * 
		 * extent.endTest(logger);
		 */
		driver.quit();
	}

}
