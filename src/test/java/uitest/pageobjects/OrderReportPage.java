// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import uitest.BasePage;

public class OrderReportPage extends BasePage {
    public OrderReportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[role='textbox']")
    WebElement searchBar;

    @FindBy(css = "ufc-orders-financial-report a")
    WebElement exportCSV;

    @FindBy(css = "")
    WebElement changePass;

    String fileName = "order-report.csv";

    public void exportFile() {
        waitElement(exportCSV);
        click(exportCSV);
    }

    public void assertExport() {
        assertDownload(fileName);
    }
}
