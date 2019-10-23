// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.*;

import org.testng.annotations.Test;

class Tests extends TestNgTestBase {

    @Test
    public void ValidCredentials() {

        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        // page.GetInstance(DashboardPage.class).verifyLogin(Variables.patientListBtn);

    }

    @Test
    public void InvalidCredentials() {
        page.GetInstance(LoginPage.class).login(Variables.invalidUser, Variables.invalidPass);
        page.GetInstance(LoginPage.class).verifyCredentials();
    }

    @Test
    public void AddNewPatient() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(PatientlistPage.class).addPatient();

    }
}
