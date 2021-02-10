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

public class MetaCategories extends Services{
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy  (accessibility = "Inspection") private MobileElement Inspection;
	@AndroidFindBy  (accessibility = "Treatment") private MobileElement Treatment;
	@AndroidFindBy  (accessibility = "Maintenance") private MobileElement Maintenance;
	
	public TreatmentSubcategory pressTreatmentTab() {
		click(Treatment);
		utils.log().info("Treatment Tab Clicked");
		return new TreatmentSubcategory();
	}
	
	/*
	public InspectionSubcategory pressInspectionTab() {
		click(Inspection);
		utils.log().info("Inspection Tab Clicked");
		return new InspectionSubcategory();
	}
	
	public MaintenanceSubcategory pressMaintenancenTab() {
		click(Inspection);
		utils.log().info("Maintenance Tab Clicked");
		return new MaintenanceSubcategory();
	}
*/

}