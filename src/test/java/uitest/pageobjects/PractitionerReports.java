// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class PractitionerReports extends BasePage {

    public PractitionerReports(WebDriver driver) {
        super(driver);
    }

    public static class PractitionerOrderReportPage extends PractitionerReports {
        public PractitionerOrderReportPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = "input[role='textbox']")
        WebElement searchBar;

        @FindBy(css = "ufc-orders-financial-report a")
        WebElement exportCSV;

        @FindBy(css = "")
        WebElement changePass;

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
