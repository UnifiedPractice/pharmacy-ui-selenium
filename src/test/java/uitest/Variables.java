package uitest;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.StringEscapeUtils;

public class Variables {
    // URLs
    public static String helioUrl = "http://sunten.stage.helioscript.com/account/login";

    // Accounts and passwords
    public static String practitioner = "practitioner@mail.com";
    public static String actualPass = "Up1234$#@!";
    public static String invalidPass = "custom1";
    public static String invalidUser = "custom1@test.com";
    public static String admin = "admin@mail.com";

    public static String newPass = "Test123!";
    public static String confirmPass = "Test123!";

    // Error messages
    public static String loginEM = "The username/password couple is invalid.";
    public static String orderSent = "ORDER SENT";
    public static String patientListBtnEM = "PATIENT LIST";
    public static String escapedString = "×&#10;Successfully updated commissions.";

    public static String successfulPatientImport = "You have successfully imported 1 patients";

    // Add Patient Info
    public static String firstName = UUID.randomUUID().toString();
    public static String lastName = UUID.randomUUID().toString();
    public static String dObOption = "3/03/1999";
    public static String phoneNumber = "+40728312211";
    public static String emailAddress = "claudiu.maxiim@omnisourcetech.com";
    public static String address1 = "Checkout Street 1";
    public static String city = "Colorado";
    public static String zipCode = "000000";
    public static String expiryDate = "6/15/2010";

    // Special char parser and randomizer
    public static String s = RandomStringUtils.randomAlphabetic(8);
    public static String unEscapedHTML = StringEscapeUtils.unescapeHtml4(escapedString);
    public static String registrationApproval = StringEscapeUtils.unescapeHtml4("×&#10;Email invite sent");
    // Lot Adjustment quantites
    public static String lotQuantity = "12";

    // Adjustments and receivals
    public static String succesfulAdjustment = "Quantities successfully adjusted";
    public static String succesfulReceival = "Quantities successfully received";
    // Active From
    public static String Active_from_Date = "11/20/2019";
    // Active To
    public static String Active_toDate = "11/30/2019";

    // Javascript executor commands
    public static String uploadJS = "arguments[0].removeAttribute('style')";

    // Registration Credentials
    public static String fName = "James";
    public static String lName = "Deen";
    public static String clinicName = "JamesDees";
    public static String zipcode = "123123";
    public static String license = "123456789";
    public static String address = "RandomAddress";

    // Exported file names
    public static String orderReport = "order-report.csv";
}