package com.qa.eco.pages;

import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideMenu extends Services{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/logout") private MobileElement Logout_btn;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement yes_btn;
	public void logout() {
		click(Logout_btn);
		click(yes_btn);
		utils.log().info("logout done");
	}
}
