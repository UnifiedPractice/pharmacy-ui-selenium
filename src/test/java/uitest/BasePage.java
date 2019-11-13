package uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    // If we need we can use custom wait in BasePage and all page classes
    protected WebDriverWait wait = new WebDriverWait(this.driver, 20);

    // Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    // Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    public <T> void waitElement(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
        }
    }

    // Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    // Close popup if exists
    public void handlePopup(By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            Thread.sleep(200);
        }
    }

    public void assertDownload(String file) {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(file)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}
