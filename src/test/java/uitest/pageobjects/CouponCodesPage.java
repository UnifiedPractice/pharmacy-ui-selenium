// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;
import uitest.Variables;

public class CouponCodesPage extends BasePage {
    public CouponCodesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".site-menu > li:nth-of-type(4) > .ng-star-inserted  .site-menu-title")
    WebElement couponCode_Menu;

    @FindBy(css = "[class='col-sm-6  col-xs-12  text-right  coupons-page__addcoupon'] span")
    WebElement add_new_Coupon;

    @FindBy(xpath = "//*[@id=;checkboxShowInactive']")
    WebElement show_inactive_coupons;
    // Add New Coupon Modal
    @FindBy(css = ".dx-editor-underlined.dx-show-clear-button.dx-textbox.dx-texteditor.dx-texteditor-empty.dx-validator.dx-visibility-change-handler.dx-widget.ng-invalid  input[role='textbox']")
    WebElement coupon_code;

    @FindBy(css = "[formcontrolname='couponDescription'] [type]")
    WebElement coupon_description;

    @FindBy(css = ".dx-editor-underlined.dx-numberbox.dx-show-clear-button.dx-texteditor.dx-widget.ng-pristine.ng-untouched.ng-valid.user-box__input  input[role='spinbutton']")
    WebElement minimum_order_number;

    @FindBy(css = "[displayexpr]")
    WebElement coupon_type_dropdown;

    @FindBy(css = ".dx-scrollview-content [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement coupon_type_select;

    @FindBy(css = "[formcontrolname='couponValue'] [type='text']")
    WebElement coupon_value;

    @FindBy(css = ".dx-dropdowneditor.ng-dirty [aria-haspopup]")
    WebElement active_from;

    @FindBy(css = ".dx-texteditor-empty.dx-dropdowneditor [aria-haspopup]")
    WebElement active_to;

    @FindBy(css = ".dx-texteditor-empty.ng-touched [type='text']")
    WebElement uses_per_practitioner;

    @FindBy(css = "[type='success'] .dx-button-content")
    WebElement save;

    public void set_new_Coupon(String code, String description, String min_value, String order_value,
            String active_from, String active_to, String uses) {
        waitElement(add_new_Coupon);
        click(add_new_Coupon);
        writeText(coupon_code, code);
        writeText(coupon_description, description);
        writeText(minimum_order_number, min_value);
        click(coupon_type_dropdown);
        click(coupon_type_select);
        writeText(coupon_value, order_value);
        writeText(active_from, active_from);
        writeText(active_to, active_to);
        writeText(uses_per_practitioner, uses);
        click(save);

    }

}
