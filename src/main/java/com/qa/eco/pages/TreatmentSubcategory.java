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

public class TreatmentSubcategory extends MetaCategories{
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='GERM SHIELD']") private MobileElement GERM_SHIELD;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='GERM SHIELD SILVER']") private MobileElement GERM_SHIELD_SILVER;
	@AndroidFindBy  (xpath = "//android.widget.TextView[@text='CONTAMINATION TEST']") private MobileElement CONTAMINATION_TEST;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button") private MobileElement GERM_SHIELD_VIEW_ORDER;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button") private MobileElement GERM_SHIELD_SILVER_VIEW_ORDER;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button") private MobileElement CONTAMINATION_TEST_VIEW_ORDER;
	
	
	
	public CommonSubCategorydPage pressGermshieldViewOrders() {
		click(GERM_SHIELD_VIEW_ORDER);
		utils.log().info("GERM_SHIELD_VIEW_ORDER button clicked");
		return new CommonSubCategorydPage();
	}
	public CommonSubCategorydPage pressGermshieldSilverViewOrders() {
		click(GERM_SHIELD_SILVER_VIEW_ORDER);
		utils.log().info("GERM_SHIELD_SILVER_VIEW_ORDER button clicked");
		return new CommonSubCategorydPage();
	}
	public CommonSubCategorydPage pressContaminationtestViewOrders() {
		click(CONTAMINATION_TEST_VIEW_ORDER);
		utils.log().info("CONTAMINATION_TEST_VIEW_ORDER button clicked");
		return new CommonSubCategorydPage();
	}

}