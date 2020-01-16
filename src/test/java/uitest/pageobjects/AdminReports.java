// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

// Admin Reports
public class AdminReports extends BasePage {
    public AdminReports(WebDriver driver) {
        super(driver);
    }

    // ss
    @FindBy(css = "li:nth-of-type(5)  .material-icons.ng-star-inserted.site-menu-icon.sub-indicator")
    WebElement reportsDropdown;
    @FindBy(css = ".site-menu-sub-item.ng-star-inserted .site-menu-title")
    WebElement orderReport;
    @FindBy(css = ".site-menu li:nth-of-type(5) .ng-star-inserted:nth-of-type(3) .site-menu-title")
    WebElement lotNrRecall;

    public AdminOrderReportPage enter_OrderReportPage() {
        waitElement(reportsDropdown);
        click(reportsDropdown);
        waitElement(orderReport);
        click(orderReport);
        return new AdminOrderReportPage(driver);
    }

    public LotNumberRecallReport enter_LotNumberRecallReportPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(reportsDropdown);
        waitElement(lotNrRecall);
        click(lotNrRecall);
        return new LotNumberRecallReport(driver);
    }

    // bb
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

    // cc
    public static class LotNumberRecallReport extends AdminReports {
        public LotNumberRecallReport(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = ".col-sm-6.col-xs-12.lot-number-recall-report__export.text-right > a > span")
        WebElement exportCSV;

        public void exportCSV() {
            waitElement(exportCSV);
            click(exportCSV);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void assertExport(String fileName) {
            assertDownload(fileName);
        }

    }

}
