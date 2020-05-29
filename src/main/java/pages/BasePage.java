package pages;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	// Find and return any desired Page Title
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Find and return any desired Page header
	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	// Find any desired ELEMENT
	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			waitForElement(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("An error occurred upon creating element" + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	// Waiting for any desired ELEMENT
	@Override
	public void waitForElement(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("An error occurred upon waiting for element" + locator.toString());
		}
	}
	

	// Waiting for any desired Page Title
	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("An error occurred upon waiting for title" + title.toString());
		}
	}

	// Scroll to element
	public void scroll_to_Element(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", (WebElement) locator);
		} catch (Exception e) {
			System.out.println("An error occurred upon scrolling to element" + locator.toString());
		}
	}

	// Random NAME generator
	public String generateName() {
		String[] names = { "EARL", "AMELIA", "OLIVIA", "EMILY", "AVA", "ISLA", "JESSICA", "POPPY", "ISABELLA", "SOPHIE",
				"MIA", "RUBY", "LILY", "GRACE", "EVIE", "SOPHIA", "ELLA", "SCARLETT", "CHLOE", "ISABELLE", " FREYA",
				"CHARLOTTE", "SIENNA", "DAISY", "PHOEBE", "MILLIE", "EVA", "ALICE", "LUCY", "FLORENCE", "SOFIA",
				"LAYLA", "LOLA", "HOLLY", "IMOGEN", "MOLLY", "MATILDA", "LILLY", "ROSIE", "ELIZABETH", "ERIN", "MAISIE",
				"LEXI", "ELLIE", "HANNAH", "EVELYN", "ABIGAIL", "ELSIE", "SUMMER", "MEGAN", "JASMINE", "MAYA", "AMELIE",
				"LACEY", "WILLOW", "EMMA", "BELLA", "ELEANOR", "ESME", "ELIZA", "GEORGIA", "HARRIET", "GRACIE",
				"ANNABELLE", "EMILIA", "AMBER", "IVY", "BROOKE", "ROSE", "ANNA", "ZARA", "LEAH", "MOLLIE", "MARTHA",
				"FAITH", "HOLLIE", "AMY", "BETHANY", "VIOLET", "KATIE", "MARYAM", "FRANCESCA", "JULIA", "MARIA",
				"DARCEY", "ISABEL", "TILLY", "MADDISON", "VICTORIA", "ISOBEL", "NIAMH", "SKYE", "MADISON", "DARCY",
				"AISHA", "BEATRICE", "SARAH", "ZOE", "PAIGE", "HEIDI", "LYDIA", "SARA", "OLIVER", "JACK", "HARRY",
				"JACOB", "CHARLIE", "THOMAS", "OSCAR", "WILLIAM", "JAMES", "GEORGE", "ALFIE", "JOSHUA", "NOAH", "ETHAN",
				"MUHAMMAD", "ARCHIE", "LEO", "HENRY", "JOSEPH", "SAMUEL", "RILEY", "DANIEL", "MOHAMMED", "ALEXANDER",
				"MAX", "LUCAS", "MASON", "LOGAN", "ISAAC", "BENJAMIN", "DYLAN", "JAKE", "EDWARD", "FINLEY", "FREDDIE",
				"HARRISON", "TYLER", "SEBASTIAN", "ZACHARY", "ADAM", "THEO", "JAYDEN", "ARTHUR", "TOBY", "LUKE",
				"LEWIS", "MATTHEW", "HARVEY", "HARLEY", "DAVID", "RYAN", "TOMMY", "MICHAEL", "REUBEN", "NATHAN",
				"BLAKE", "MOHAMMAD", "JENSON", "BOBBY", "LUCA", "CHARLES", "FRANKIE", "DEXTER", "KAI", "ALEX", "CONNOR",
				"LIAM", "JAMIE", "ELIJAH", "STANLEY", "LOUIE", "JUDE", "CALLUM", "HUGO", "LEON", "ELLIOT", "LOUIS",
				"THEODORE", "GABRIEL", "OLLIE", "AARON", "FREDERICK", "EVAN", "ELLIOTT", "OWEN", "TEDDY", "FINLAY",
				"CALEB", "IBRAHIM", "RONNIE", "FELIX", "AIDEN", "CAMERON", "AUSTIN", "KIAN", "RORY", "SETH", "ROBERT",
				"ALBERT", "SONNY", };
		Random random = new Random();
		return names[random.nextInt(names.length)];
	}

	// Generate EMAIL - to add list of reusable emails
	public String generateEmail() {
		String[] emails = { "", "" };
		Random random = new Random();
		return emails[random.nextInt(emails.length)];
	}

	// Random INTEGER generat0r
	public String generateNumber() {
		Random number = new Random();
		int randomnumber = number.nextInt(50);
		return String.valueOf(randomnumber);
	}

	// Download assertions
	public void assertDownload(String location, String file) {
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();
		// System.out.println("Files are :" + listOfFiles);
		boolean found = false;
		File f = null;

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				// System.out.println("File " + listOfFile.getName());
				if (fileName.matches(file)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(found, "Downloaded document is not found");
		System.out.println("Path of the file is: " + f.getPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.delete();
	}

	public boolean checkIfFileExists(String location, String fileName) {
		File dir = new File(location);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete();
				System.out.println("File got deleted");
				return true;
			}
		}
		System.out.println("File does not exist");
		return false;
	}
	
	public static HashMap<String, String> getCredentials() {
		HashMap <String, String> userMap = new HashMap <String, String>();
		userMap.put("admin", "admin@mail.com:Up1234$#@!");
		userMap.put("practitioner", "practitioner@mail.com:Up1234$#@!");
		userMap.put("CSR", "CSR@mail.com:Up1234$#@!");
		return userMap;
								 
	}

}
