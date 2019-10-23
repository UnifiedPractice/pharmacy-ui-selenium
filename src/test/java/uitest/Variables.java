package uitest;

import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;

public class Variables {
    // URLs
    public static String helioUrl = "http://sunten.staging.unifiedpractice.com/account/login";

    // Accounts and passwords
    public static String practitioner = "practitioner@mail.com";
    public static String pass = "Up1234$#@!";
    public static String invalidPass = "custom1";
    public static String invalidUser = "custom1@test.com";
    public static String admin = "admin@mail.com";

    // Error messages
    public static String loginEM = "info The username/password couple is invalid.";
    public static String orderSent = "ORDER SENT";
    public static String patientListBtnEM = "PATIENT LIST";

    public static String succesfullAdjustment = "";

    // Add Patient Info
    public static String firstName = UUID.randomUUID().toString();
    public static String lastName = UUID.randomUUID().toString();
    public static String dObOption = "3/03/1999";
    public static String phoneNumber = "+40728312211";
    public static String emailAddress = "test.test@test.com";
    public static String address1 = "Checkout Street 1";
    public static String city = "Colorado";
    public static String zipCode = "000000";

    //
    public static String s = RandomStringUtils.randomAlphabetic(8);

    // Lot Adjustment quantites
    public static String lotQuantity = "12";

}