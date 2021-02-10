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

public class BeforeTreatmentPage extends SelectServiceModulePage{
	TestUtils utils = new TestUtils();
	@AndroidFindBy  (id = "in.droom.eco:id/img_dmg_arrow") private MobileElement BeforeTreatmentPhotodropdown;
	@AndroidFindBy  (id = "in.droom.eco:id/layout_camera") private MobileElement CameraIcon;
	//@AndroidFindBy  (id = "com.android.permissioncontroller:id/permission_allow_button") private MobileElement CameraPermission;
	@AndroidFindBy  (id = "com.android.camera:id/v9_shutter_button_internal") private MobileElement Shutterbutton;
	@AndroidFindBy  (id = "com.android.camera:id/intent_done_apply") private MobileElement PicDone;
	
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText") private MobileElement TreatmentAreaName;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText") private MobileElement Initial_Reading;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_next") private MobileElement FinishBtn;
	public BeforeTreatmentPage takeBeforeTreatmentPhotos() {
		click(BeforeTreatmentPhotodropdown);
		click(CameraIcon);
		//click(CameraPermission);
		click(Shutterbutton);
		click(PicDone);
		utils.log().info("BeforeTreatmentPhotos taken");
		return this;
	}
	public BeforeTreatmentPage enterTreatmentAreaName(String TreatmentArea) {
		sendKeys(TreatmentAreaName,TreatmentArea);
		utils.log().info("TreatmentAreaName entered");
		return this;
	}
	public BeforeTreatmentPage enterInitialReading(String InitialReading) {
		sendKeys(Initial_Reading,InitialReading);
		utils.log().info("InitialReading entered");
		return this;
	}
	public SelectServiceModulePage pressFinishBtn() {
		click(FinishBtn);
		utils.log().info("FinishBtn clicked");
		return new SelectServiceModulePage();
	}
	
	
		
}