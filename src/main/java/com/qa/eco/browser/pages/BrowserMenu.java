package com.qa.eco.browser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.TestBase;
import com.qa.eco.base.TestBaseBrowser;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class BrowserMenu extends TestBaseBrowser {
	
	
	@FindBy(xpath="//a[@href='/home']") WebElement OrderManagementButton;
	@FindBy(xpath="//a[@class='dropdown-toggle']") WebElement Profile_btn;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement Logout_btn;

	TestUtils utils = new TestUtils();
	
	
	public void logoutMethod() {
		clickb(Profile_btn);
		utils.log().info("profile button clicked");
		clickb(Logout_btn);
		utils.log().info("logout done");
			}
	public OrderManagementPage pressOrderManagement() {
		clickb(OrderManagementButton);
		utils.log().info("OrderManagement button clicked");
		return new OrderManagementPage();
	}
	

}
