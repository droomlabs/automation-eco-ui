package com.qa.eco.pages;

import com.qa.eco.base.TestBase;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideMenu extends TestBase{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/logout") private MobileElement Logout_btn;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement yes_btn;
	
	public LoginPage logout() {
		click(Logout_btn);
		click(yes_btn);
		utils.log().info("logout done");
		return new LoginPage();
	}
}
