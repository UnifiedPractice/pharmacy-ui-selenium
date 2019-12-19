// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class AdminReports extends BasePage {
    public AdminReports(WebDriver driver) {
        super(driver);
    }

    // s
    @FindBy(css = ".site-menu-icon.ng-star-inserted")
    WebElement reportsDropdown;
    @FindBy(css = ".site-menu-sub-item.ng-star-inserted .site-menu-title")
    WebElement orderReport;

    public static class AdminOrderReportPage extends AdminReports {
        public AdminOrderReportPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = "input[role='textbox']")
        WebElement searchBar;

        @FindBy(css = "ufc-orders-financial-report a")
        WebElement exportCSV;

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
