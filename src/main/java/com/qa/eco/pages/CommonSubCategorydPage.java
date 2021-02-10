package com.qa.eco.pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonSubCategorydPage extends TreatmentSubcategory{
	TestUtils utils = new TestUtils();
		
	@AndroidFindBy  (id = "in.droom.eco:id/search_button") private MobileElement Search_Button;	
	@AndroidFindBy  (id = "in.droom.eco:id/search_src_text") private MobileElement Search_Text_Button;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='New Request']") private MobileElement New_Request;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='Pending Treatment']") private MobileElement Pending_Treatment;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='Completed Treatment']") private MobileElement Completed_Treatment;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='Rejected Treatment']") private MobileElement Rejected_Treatment;
	
	
	public CommonSubCategorydPage pressSearchButton() {
		click(Search_Button);
		utils.log().info("Search_Button Clicked");
		return this;
	}
	public CommonSubCategorydPage enterSearchText(String Order_id) {
		sendKeys(Search_Text_Button,Order_id);
		utils.log().info("order id searched");
		return this;
	}
	
	public CommonNewRequestPage pressNewRequestTab() {
		click(New_Request);
		utils.log().info("NewRequest Tab Clicked");
		return new CommonNewRequestPage();
	}
	
	public CommonPendingTreatmentPage pressPendingTreatmentTab() {
		click(Pending_Treatment);
		utils.log().info("PendingTreatment Tab Clicked");
		return new CommonPendingTreatmentPage();
	}
	public CommonCompletedTreatmentPage pressCompletedTreatmentTab() {
		click(Completed_Treatment);
		utils.log().info("CompletedTreatment Tab Clicked");
		return new CommonCompletedTreatmentPage();
	}
	public CommonRejectedTreatmentdPage pressRejectedTreatmentTab() {
		click(Rejected_Treatment);
		utils.log().info("RejectedTreatment Tab Clicked");
		return new CommonRejectedTreatmentdPage();
	}


}