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

public class CommonNewRequestPage extends CommonSubCategorydPage{
	
	TestUtils utils = new TestUtils();
		
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout") private MobileElement AcceptMark;
	@AndroidFindBy  (id = "in.droom.eco:id/alert_text") private MobileElement Order_Accept_Popup;
	@AndroidFindBy  (id = "in.droom.eco:id/yes") private MobileElement Order_Accept;
	
	public CommonNewRequestPage pressAcceptMark() {
		click(AcceptMark);
		utils.log().info("AcceptMark Clicked");
		return this;
	}
	public CommonPendingTreatmentPage pressYesForOrderAccept() {
		click(Order_Accept);
		utils.log().info("Order_Accepted");
		return new CommonPendingTreatmentPage();
	}

}