// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import uitest.BasePage;
import uitest.Variables;

public class AdminHomePage extends BasePage {
    public AdminHomePage(WebDriver driver) {
        super(driver);
    }

    // Side Menu
    @FindBy(css = ".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title")
    WebElement dispensary;

    @FindBy(css = ".site-menu li:nth-of-type(2) .material-icons.ng-star-inserted")
    WebElement inventoryDropdown;
    @FindBy(css = "li:nth-of-type(2) > .ng-star-inserted.site-menu-sub > li:nth-of-type(2) > .ng-star-inserted  .site-menu-title")
    WebElement productCatalog;

    @FindBy(css = ".site-menu .has-sub:nth-of-type(3) .material-icons.ng-star-inserted")
    WebElement settingsDropdown;

    @FindBy(css = ".site-menu > .ng-star-inserted:nth-of-type(4) .site-menu-title")
    WebElement couponCodes;

    @FindBy(css = ".site-menu .ng-star-inserted:nth-of-type(5) .material-icons.ng-star-inserted")
    WebElement reports;

    public ProductCatalogPage enter_ProductCatalog() {
        waitElement(inventoryDropdown);
        click(inventoryDropdown);
        waitElement(productCatalog);
        click(productCatalog);
        return new ProductCatalogPage(driver);
    }
}
