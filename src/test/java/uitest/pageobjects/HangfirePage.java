// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class HangfirePage extends BasePage {

    public HangfirePage(WebDriver driver) {
        super(driver);
    }

    // Jobs
    @FindBy(css = "tbody tr:nth-of-type(3) [name]")
    WebElement lateOrder;
    @FindBy(css = "tbody tr:nth-of-type(2) [name]")
    WebElement importPractitioners;
    @FindBy(css = "tbody tr:nth-of-type(1) [name]")
    WebElement importInventory;

    // Trigger
    @FindBy(css = ".btn.btn-primary.btn-sm.js-jobs-list-command")
    WebElement triggerNow;

    public void trigger_lateOrder() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(lateOrder);
        click(triggerNow);
        driver.switchTo().window(tabs.get(0));
    }

    public void trigger_importPractitioners() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(importPractitioners);
        click(triggerNow);
        driver.switchTo().window(tabs.get(0));
    }

    public void trigger_importInventory() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(importInventory);
        click(triggerNow);
        driver.switchTo().window(tabs.get(0));
    }

}
