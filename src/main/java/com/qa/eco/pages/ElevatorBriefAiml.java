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

public class ElevatorBriefAiml extends TestBase{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/skip_step") private MobileElement Skip_Step;
	@AndroidFindBy  (id = "in.droom.eco:id/skip_capacity_step") private MobileElement Skip_Cpacity_Step;
	
	public ElevatorBriefAiml pressSkipStep() {
		click(Skip_Step);
		utils.log().info("Skip_Step Clicked");
		return this;
	}
	
	
	public ElevatorBrief pressSkipCapacityStep() {
		click(Skip_Cpacity_Step);
		utils.log().info("Skip_Cpacity_Step Clicked");
		return new ElevatorBrief();
	}
	
	
		
}