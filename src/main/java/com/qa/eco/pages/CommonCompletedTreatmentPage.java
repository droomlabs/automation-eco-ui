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

public class CommonCompletedTreatmentPage extends CommonPageToSubCategories{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (id = "in.droom.eco:id/btn_generate") private MobileElement GenerateReport;
	
	
	public CommonCompletedTreatmentPage pressGenerateReport() {
		click(GenerateReport);
		utils.log().info("GenerateReport Clicked");
		utils.log().info("Report Generation in progress");
		return this;
	}
	
	
		
}