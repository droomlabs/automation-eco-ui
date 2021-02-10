package com.qa.eco.browser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class Welcomepage extends EcoAdminLogin {
	
	@FindBy(xpath="/html/body/div[1]/div[1]/section[2]/h1") WebElement WelcomeText;
	@FindBy(xpath="/html/body/div[1]/aside/section/ul/li[8]/a/span") WebElement OrderManagementButton;

	TestUtils utils = new TestUtils();
	
	public Welcomepage checkPageOpening() {
		boolean x=isElementDisplayedb(WelcomeText);
		 if(x == true) {
			 utils.log().info("successful login");
		 }
		 else {
			 utils.log().info("no login");
			 }
		
		return this;
	}
	
	public OrderManagementPage pressOrderManagement() {
		clickb(OrderManagementButton);
		utils.log().info("OrderManagement button clicked");
		return new OrderManagementPage();
	}
	

}
