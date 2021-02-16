package com.qa.eco.browser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.TestBase;

import com.qa.eco.base.TestBaseBrowser;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class EcoAdminLogOut extends TestBaseBrowser {
	
	@FindBy(xpath="//a[normalize-space()='Profile']") WebElement Profile_btn;
    @FindBy(xpath="//a[normalize-space()='Logout']") WebElement Logout_btn;
	
	TestUtils utils = new TestUtils();
	
	public EcoAdminLogOut logout() {
		clickb(Profile_btn);
		clickb(Logout_btn);
		utils.log().info("logout done");
		return this;
	}
	

}
