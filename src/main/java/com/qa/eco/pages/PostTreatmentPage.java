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

public class PostTreatmentPage extends TestBase{
	TestUtils utils = new TestUtils();
	@AndroidFindBy  (id = "in.droom.eco:id/img_dmg_arrow") private MobileElement PostTreatmentPhoto;
	@AndroidFindBy  (id = "in.droom.eco:id/layout_camera") private MobileElement CameraIcon;
	//@AndroidFindBy  (id = "com.android.permissioncontroller:id/permission_allow_button") private MobileElement CameraPermission;
	@AndroidFindBy  (id = "com.android.camera:id/v9_shutter_button_internal") private MobileElement Shutterbutton;
	@AndroidFindBy  (id = "com.android.camera:id/intent_done_apply") private MobileElement PicDone;
	@AndroidFindBy  (id = "in.droom.eco:id/edit_text") private MobileElement Final_Reading;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_next") private MobileElement FinishBtn;
	public PostTreatmentPage takePostTreatmentPhotos() {
		click(PostTreatmentPhoto);
		click(CameraIcon);
		//click(CameraPermission);
		click(Shutterbutton);
		click(PicDone);
		utils.log().info("PostTreatmentPhotos taken");
		return this;
	}
	
	public PostTreatmentPage enterFinalReading(String FinalReading) {
		sendKeys(Final_Reading,FinalReading);
		utils.log().info("FinalReading entered");
		return this;
	}
	public SelectServiceModulePage pressFinishBtn() {
		click(FinishBtn);
		utils.log().info("FinishBtn clicked");
		return new SelectServiceModulePage();
	}
	
	
		
}