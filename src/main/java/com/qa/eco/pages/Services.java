package com.qa.eco.pages;

import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Services extends LoginPage{
	TestUtils utils = new TestUtils();
	@AndroidFindBy  (id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") private MobileElement foreground_Location_Allow;
	@AndroidFindBy  (id = "in.droom.eco:id/check_inspection") private MobileElement Check_Services;
	@AndroidFindBy  (id = "android:id/button1") private MobileElement Ninja_Health_Proceed;
	
public Services pressforegroundLocationAllow() {
		click(foreground_Location_Allow);
		utils.log().info("Location_Allow");
		return this;
	}
/*public Services pressCheckServices() {
		click(Check_Services);
		utils.log().info("clicked on view services");
		return this;
	}*/	

public  NinjaHealthDeclaration pressCheckServices() {
	click(Check_Services);
	if (Ninja_Health_Proceed.isDisplayed()==false) {
		utils.log().info("clicked on view services");
		return new NinjaHealthDeclaration();
		
		}
	else{
		click(Ninja_Health_Proceed);
		System.out.println("inside else");
		utils.log().info("clicked on Health_declaration Proceed button");
		return new NinjaHealthDeclaration();
	}
}	
/*public NinjaHealthDeclaration pressNinjaHealthDeclaration() {
	click(Ninja_Health_Proceed);
	utils.log().info("clicked on Health_declaration Proceed button");
	return new NinjaHealthDeclaration();
}*/
public MetaCategories pressCheckServices2() {
	click(Check_Services);
	utils.log().info("clicked on view services");
	return new MetaCategories();

}

}