package com.qa.eco.pages;

import java.util.List;

import com.qa.eco.base.TestBase;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NinjaHealthDeclaration extends Menu{	
	TestUtils utils = new TestUtils();
	//@AndroidFindBy  (xpath = "//android.widget.RadioButton[@text='No']") List<MobileElement> no_buttons;
	@AndroidFindBy  (id = "in.droom.eco:id/radioBtnForNo") List<MobileElement> no_buttons;
	@AndroidFindBy  (id = "in.droom.eco:id/radioBtnForNo") List<MobileElement> no_buttons2;
	//@AndroidFindBy  (id = "in.droom.eco:id/radioBtnForNo[i]") MobileElement no_buttons;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_done") private MobileElement Done;
	@AndroidFindBy  (id = "in.droom.eco:id/linearLayout") private MobileElement HealthScreen;
	public NinjaHealthDeclaration answerNoQuestion() {
		click(no_buttons.get(0));
		click(no_buttons.get(1));
		click(no_buttons.get(2));
		click(no_buttons.get(3));
		click(no_buttons.get(4));
		click(no_buttons.get(5));
		click(no_buttons.get(6));
		click(no_buttons.get(7));
		click(no_buttons.get(8));
		scrollUD("up",HealthScreen);
		click(no_buttons2.get(5));
		click(no_buttons2.get(6));
		click(no_buttons2.get(7));	
		utils.log().info("all answer completed");
		 return this;
			}		
	
public Services pressDone() {
	click(Done);
	utils.log().info("clicked done");
	back();
	utils.log().info("back done");
	return new Services();
}	
public MetaCategories transferMethod() {
	return new MetaCategories();
}

}