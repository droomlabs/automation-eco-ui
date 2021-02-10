package com.qa.eco.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonPendingTreatmentPage extends CommonNewRequestPage{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/btn_start") private MobileElement Start_For_Location;
	@AndroidFindBy  (id = "in.droom.eco:id/alert_text") private MobileElement Ready_to_startPopup;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement Ready_to_startPopup_yes;
	@AndroidFindBy  (xpath = "//android.widget.Button[@text='Reached Location']") private MobileElement Reached_Location;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement FinishTripPopup_yes;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_start") private MobileElement Start_Service;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement ConfirmServicePopup_yes;
	@AndroidFindBy  (id = "in.droom.eco:id/txtViewForOTP") private MobileElement InputOtpTextFILED;
	
	@AndroidFindBy  (id = "in.droom.eco:id/btn_submit") private MobileElement SubmitOtp;
	
	
	
	public CommonPendingTreatmentPage pressStartForLocation() {
		click(Start_For_Location);
		utils.log().info("Start_For_Location Clicked");
		return this;
	}
	public CommonPendingTreatmentPage pressReadyToStart() {
		click(Ready_to_startPopup_yes);
		utils.log().info("Ready_to_start yes Clicked");
		return this;
	}
	public CommonPendingTreatmentPage pressReachedLocation() {
		click(Reached_Location);
		utils.log().info("Reached_Location Clicked");
		return this;
	}
	public CommonPendingTreatmentPage pressFinishTrip() {
		click(FinishTripPopup_yes);
		utils.log().info("FinishTripPopup yes Clicked");
		return this;
	}
	public CommonPendingTreatmentPage pressStartService() {
		click(Start_Service);
		utils.log().info("Start_Service Clicked");
		return this;
	}
	
	public SelectServiceModulePage pressConfirmService() throws Exception {
		click(ConfirmServicePopup_yes);
		utils.log().info("otpchecking");
		boolean x = isElementDisplayed(InputOtpTextFILED);
		if(x == true) {		
		String otp1 = TestUtils.getotp("SELECT * FROM cscart_new.otp_verification where phone ='7000848718' order by id desc limit 1;");
		sendKeys(InputOtpTextFILED,otp1);
		click(SubmitOtp);
		utils.log().info("SubmitOtp Button Clicked");
		}
		else {
			utils.log().info("ConfirmServicePopup yes Clicked");
		}
	return new SelectServiceModulePage();
	}	
	
		
}