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

public class SelectServiceModulePage extends CommonPendingTreatmentPage{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy  (xpath = "//*[@text='Elevator Brief']") private MobileElement Elevato_Brief;
	@AndroidFindBy  (xpath = "//*[@text='Before Treatment']") private MobileElement Germshield_ReadingBFT;
	@AndroidFindBy  (xpath = "//*[@text='Treatment Duration']") private MobileElement Germshield_ReadingDuration;
	@AndroidFindBy  (xpath = "//*[@text='Post Treatment']") private MobileElement Germshield_ReadingPost;
	/*
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView") private MobileElement Germshield_ReadingBFT;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.TextView") private MobileElement Germshield_ReadingDuration;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.LinearLayout/android.widget.TextView") private MobileElement Germshield_ReadingPost;
	*/
	@AndroidFindBy (id="in.droom.eco:id/btn_finish") private MobileElement FinishBtn;
	public ElevatorBriefAiml pressElevatorBrief() {
		click(Elevato_Brief);
		utils.log().info("ElevatorBrief Clicked");
		return new ElevatorBriefAiml();
	}
	
	
	public BeforeTreatmentPage pressBeforeGermshieldReading() {
		click(Germshield_ReadingBFT);
		utils.log().info("BeforeTreatmentPage Clicked");
		return new BeforeTreatmentPage();
	}
	
	public TreatmentDurationPage pressGermshieldReadingDuration() {
		click(Germshield_ReadingDuration);
		utils.log().info("TreatmentDurationPage Clicked");
		return new TreatmentDurationPage();
	}
	public PostTreatmentPage pressPostGermshieldReading() {
		click(Germshield_ReadingPost);
		utils.log().info("PostTreatmentPage Clicked");
		return new PostTreatmentPage();
	}
	public CommonCompletedTreatmentPage pressSelectServiceModulePageFinishBtn() {
		click(FinishBtn);
		utils.log().info("FinishBtn Clicked");
		return new CommonCompletedTreatmentPage();
	}
	
}