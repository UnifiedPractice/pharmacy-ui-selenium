package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponCodesPage extends BasePage {

	public CouponCodesPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Page Locators - Coupon Codes Page
	private By addCoupon = By.cssSelector("[class='col-sm-6  col-xs-12  text-right  coupons-page__addcoupon'] span");
	private By show_InactiveCoupons = By.xpath("//*[@id=;checkboxShowInactive']");
	
	
	//Add new coupon Modal
	private By couponName = By.cssSelector(".dx-editor-underlined.dx-show-clear-button.dx-textbox.dx-texteditor.dx-texteditor-empty.dx-validator.dx-visibility-change-handler.dx-widget.ng-invalid  input[role='textbox']");
	private By couponDescription = By.cssSelector("[formcontrolname='couponDescription'] [type]");
	private By minOrderValue = By.cssSelector(".dx-editor-underlined.dx-numberbox.dx-show-clear-button.dx-texteditor.dx-widget.ng-pristine.ng-untouched.ng-valid.user-box__input  input[role='spinbutton']");
	private By coupon_type_dropdown = By.cssSelector("[displayexpr]");
	private By coupon_type_selection = By.cssSelector(".dx-scrollview-content [role='option']:nth-of-type(1) .dx-list-item-content");
	private By couponValue = By.cssSelector("[formcontrolname='couponValue'] [type='text']");
	private By active_from = By.xpath("//ufc-add-edit-coupon-modal/div/div[@class='modal-dialog']/div[@class='modal-content']/form/div[@class='modal-body']/div[3]/div[@class='col-md-5 col-sm-12 form-row']/div/div[@class='user-box__item']/dx-date-box//input[@role='combobox']");
	private By active_to = By.xpath("//ufc-add-edit-coupon-modal/div/div[@class='modal-dialog']/div[@class='modal-content']/form/div[@class='modal-body']//div[@class='col-md-6 col-sm-12 form-row']/div/div[@class='user-box__item']/dx-date-box//input[@role='combobox']");
	private By use_per_practitioner = By.cssSelector(".ng-valid.dx-numberbox.dx-texteditor-empty [type='text']");
	private By save = By.cssSelector("[type='success'] .dx-button-content");
	private By toastMessage = By.cssSelector(".toast-message");
	
	
	//Locator GET function
	public WebElement getAddCoupon_button() {
		return getElement(addCoupon);
	}
	public WebElement getInactiveCoupons_button() {
		return getElement(show_InactiveCoupons);
	}
	public WebElement getCouponName_button() {
		return getElement(couponName);
	}
	public WebElement getCouponDescription() {
		return getElement(couponDescription);
	}
	public WebElement getMinOrderValue_button() {
		return getElement(minOrderValue);
	}
	public WebElement getCouponTypedropdown_button() {
		return getElement(coupon_type_dropdown);
	}
	public WebElement getCouponTypeSelection_button() {
		return getElement(coupon_type_selection);
	}
	public WebElement getCouponValue_button() {
		return getElement(couponValue);
	}
	public WebElement getActiveFrom_button() {
		return getElement(active_from);
	}
	public WebElement getActiveTo_button() {
		return getElement(active_to);
	}
	public WebElement getUsePerPractitioner_button() {
		return getElement(use_per_practitioner);
	}
	public WebElement getSave_button() {
		return getElement(save);
	}
	public WebElement getToastMessage_button() {
		return getElement(toastMessage);
	}
	
	
	//Page navigation methods 
	public void createCoupon(String couponName, String couponDescription, String orderValue, String couponValue,
			String activeFrom, String activeTo, String usesPerPrac) {
		getAddCoupon_button().click();
		getCouponName_button().sendKeys(couponName); // coupon name = coupon value
		getCouponDescription().sendKeys(couponDescription);
		getMinOrderValue_button().sendKeys(orderValue);
		getCouponTypedropdown_button().click();
		getCouponTypeSelection_button().click();
		getCouponValue_button().sendKeys(couponValue);
		getActiveFrom_button().click();
		getActiveFrom_button().sendKeys(activeFrom);// date format string to be sent
		getActiveTo_button().click();
		getActiveTo_button().sendKeys(activeTo);// date format string to be sent
		getUsePerPractitioner_button().sendKeys(usesPerPrac);// number of uses per practitioner
		getSave_button().click();
	}
	//Assertions pending - no success message is shown upon adding a coupon - to track BUG
	
}
