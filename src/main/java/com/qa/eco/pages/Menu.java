package com.qa.eco.pages;

import com.qa.eco.base.TestBase;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Menu extends TestBase{
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy  (id = "in.droom.eco:id/mHeaderLeft") private MobileElement Hamburgermenu;
	public SideMenu cickHamburgermenu() {
		click(Hamburgermenu);
		utils.log().info("clicked on Hamburgermenu");
		return new SideMenu();
	}
	
}
