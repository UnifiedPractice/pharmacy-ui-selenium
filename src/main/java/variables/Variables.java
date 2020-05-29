package variables;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.StringEscapeUtils;

public class Variables {

	
	// URLs
	public static String development = "http://sunten.dev.helioscript.com/account/login";
	public static String staging = "http://sunten.stage.helioscript.com/account/login";
	public static String uat = "http://sunten.uat.helioscript.com/account/login";
	public static String live = "";//

	
	// Accounts and passwords
	public static String practitioner = "practitioner@mail.com";
	public static String admin = "admin@mail.com";
	public static String actualPass = "Up1234$#@!";
	public static String invalidPass = "custom1";
	public static String invalidUser = "custom1@test.com";
	public static String newPass = "Test123!";
	public static String confirmPass = "Test123!";

	
	// Error messages
	public static String escapedString = "×&#10;Successfully updated commissions.";
	public static String s = RandomStringUtils.randomAlphabetic(8);
	public static String unEscapedHTML = StringEscapeUtils.unescapeHtml4(escapedString);
	public static String loginEM = "The username/password couple is invalid.";
	public static String orderSent = "ORDER SENT";
	public static String patientListBtnEM = "PATIENT LIST";
	
	public static String successfulPatientImport = "You have successfully imported 1 patients";
	public static String registrationApproval = StringEscapeUtils.unescapeHtml4("×&#10;Email invite sent");
	public static String shippingMethodMessage = "Settings saved successfully";
	public static String invititationMessage = "Invite has been sent.";	
	public static String mediumMessage = "Medium saved successfully";
	public static String regApproval = "Application submitted";
	public static String chineseNamesMessage = "You have successfully imported the names for 2 products.";
	public static String settingsMessage = "Settings saved successfully";
	public static String practitionerProfileMessage = "Your data has been successfully saved.";
	
	
	// Add Patient Info
	public static String firstName = UUID.randomUUID().toString();
	public static String lastName = UUID.randomUUID().toString();
	public static String dObOption = "3/03/1999";
	public static String phoneNumber = "+40728312211";
	public static String emailAddress = "claudiu.maxim@omnisourcetech.com";
	public static String address1 = "Checkout Street 1";
	public static String city = "Colorado";
	public static String zipCode = "000000";
	public static String expiryDate = "6/15/2010";

	
	// Lot Adjustment quantites
	public static String lotQuantity = "12";

	
	// Adjustments and receivals
	public static String succesfulAdjustment = "Quantities successfully adjusted";
	public static String succesfulReceival = "Quantities successfully received";

	
	// Date & Time Formatting
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");
	public static DateTimeFormatter der = DateTimeFormatter.ofPattern("MM_dd_yyyy", Locale.ENGLISH);
	public static LocalDate localDate = LocalDate.now();
	public static String ParsedDate = dtf.format(localDate);
	public static String MyLocalDate = der.format(localDate);
	public static String Active_from_Date = "11/20/2019";
	public static String Active_toDate = "11/30/2020";

	
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
	public static String thresholdReport = "Threshold Report.csv";
	public static String expiredLotReport = "Expired_lot_report_" + MyLocalDate + ".csv";
	public static String lotNumberRecallReport = "Lot_Number_Recall_Report.csv";

	
	// Downloaded files location - inProject location
	public static String downloadFilepathOpera = System.getProperty("user.dir") + File.separator + "downloadFiles" + File.separator + "opera";
	public static String downloadFilepathChrome = System.getProperty("user.dir") + File.separator + "downloadFiles" + File.separator + "chrome";
	public static String downloadFilepathFirefox = System.getProperty("user.dir") + File.separator + "downloadFiles" + File.separator + "firefox";
}