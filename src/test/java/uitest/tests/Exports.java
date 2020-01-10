// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.AdminReports;
import uitest.pageobjects.InventoryPages;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerReports;

class Exports extends TestNgTestBase {
    @Test(enabled = true, priority = 1)
    public void practitionerOrderReport_Export() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_orderReportPage();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).isFileDownloaded("order-report.csv");
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).exportFile();
        // page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).assertExport(Variables.orderReport);
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).assertDownload("order-report.csv");
    }

    @Test(enabled = true, priority = 2)
    public void adminOrderReport_Export() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_ReportPage();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).isFileDownloaded("order-report.csv");
        page.GetInstance(AdminReports.AdminOrderReportPage.class).exportFile();
        page.GetInstance(AdminReports.AdminOrderReportPage.class).assertExport("order-report.csv");
    }

    @Test(enabled = true, priority = 3)
    public void lotNumber_RecallReport() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminReports.class).enter_LotNumberRecallReportPage();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).isFileDownloaded("Lot_Number_Recall_Report.csv");
        page.GetInstance(AdminReports.LotNumberRecallReport.class).exportCSV();
        page.GetInstance(AdminReports.LotNumberRecallReport.class).assertExport("Lot_Number_Recall_Report.csv");
    }

    @Test(enabled = true, priority = 4)
    public void expired_LotNumber() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ExpiredLotNumber();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).isFileDownloaded("Expired_lot_report_" + Variables.MyLocalDate + ".csv");
        page.GetInstance(InventoryPages.ExpiredLotNumber.class).exportFile();
        page.GetInstance(InventoryPages.ExpiredLotNumber.class).assertExport("Expired_lot_report_" + Variables.MyLocalDate + ".csv");
    }

    @Test(enabled = true, priority = 5)//need 2 rewrite locators
    public void thresholdReport() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ThresholdReport();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).isFileDownloaded("Threshold Report.csv");
        page.GetInstance(InventoryPages.ThresholdReport.class).generateExportList();
        page.GetInstance(InventoryPages.ThresholdReport.class).assertDownload("Threshold Report.csv");
    }
}
