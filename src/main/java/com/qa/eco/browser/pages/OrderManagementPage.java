package com.qa.eco.browser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class OrderManagementPage extends BrowserMenu {
	
	
	@FindBy(xpath="//input[@value='Raise New Request']") WebElement RaiseNewRequest;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/div/div/div[2]") WebElement SucessMsg;
	@FindBy(xpath="//*[@class='assign_vendor_tech' and @value=1]") WebElement AssignTechnician;
	@FindBy(xpath="//span[@id='select2-assignee_id-container']") WebElement AssignTechniciandropdown;
	@FindBy(xpath="/html/body/span/span/span[1]/input") WebElement AssignTechniciansearch;
	@FindBy(xpath="/html/body/span/span/span[2]/ul/li[1]") WebElement Technician;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[6]/div/form/div/div[3]/button[2]") WebElement Submit;
	TestUtils utils = new TestUtils();
		
	public NewRequestPage pressRaiseNewRequest() {
		clickb(RaiseNewRequest);
		utils.log().info("RaiseNewRequest button clicked");
		return new NewRequestPage();
	}
	public  BrowserMenu assignTechnician(String Tech_id) throws Exception {
		
		clickb(AssignTechnician);
		clickb(AssignTechniciandropdown);
		utils.log().info("dropdown visible");
	    Thread.sleep(10000);
		sendKeysb(AssignTechniciansearch,Tech_id);
		utils.log().info("Technician id filled");
		clickb(Technician);
		clickb(Submit);
		utils.log().info("technician assigned");
		Thread.sleep(10000);
		//return new CommonInitialization();
		return new BrowserMenu();
	}

}
