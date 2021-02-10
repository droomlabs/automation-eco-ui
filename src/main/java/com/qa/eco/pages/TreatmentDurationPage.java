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

public class TreatmentDurationPage extends SelectServiceModulePage{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/btn_timer_start") private MobileElement Timer_Start_Button;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_timer_stop") private MobileElement Timer_Stop_Button;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_next") private MobileElement FinishBtn;
	public TreatmentDurationPage pressTimerBtn() throws InterruptedException {
		click(Timer_Start_Button);
		utils.log().info("Timer Started");
		Thread.sleep(5000);
		click(Timer_Stop_Button);
		utils.log().info("Timer Ended");
		return this;
	}
	
	public SelectServiceModulePage pressFinishBtn(){
		click(FinishBtn);
		return new SelectServiceModulePage();
	}
	
	
		
}