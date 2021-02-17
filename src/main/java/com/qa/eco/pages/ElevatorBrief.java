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

public class ElevatorBrief extends TestBase{
	TestUtils utils = new TestUtils();
	@AndroidFindBy  (id = "in.droom.eco:id/input_layout") private MobileElement Panel;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.LinearLayout") private MobileElement Elevator_Type;
	@AndroidFindBy  (id = "in.droom.eco:id/elevator_make") private MobileElement Elevator_Make;
	@AndroidFindBy  (id = "in.droom.eco:id/elevator_capacity") private MobileElement Elevator_Capacity;
	@AndroidFindBy  (id = "in.droom.eco:id/radioBtnForElevatorPrePost") private MobileElement RadioBtnPrePost;
	@AndroidFindBy  (id = "in.droom.eco:id/et_swab_count_elevator") private MobileElement Swab_Count;
	@AndroidFindBy  (id = "in.droom.eco:id/et_floor_count") private MobileElement Floor_Count;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Spinner") private MobileElement SprayerType;
	@AndroidFindBy  (xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]") private MobileElement ULV;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Spinner") private MobileElement ATPMeter;
	@AndroidFindBy  (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]") private MobileElement Merck;
	@AndroidFindBy  (id = "in.droom.eco:id/layout_camera") private MobileElement CameraIcon;
	@AndroidFindBy  (id = "com.android.permissioncontroller:id/permission_allow_button") private MobileElement CameraPermission;
	@AndroidFindBy  (id = "com.android.camera:id/v9_shutter_button_internal") private MobileElement Shutterbutton;
	@AndroidFindBy  (id = "com.android.camera:id/intent_done_apply") private MobileElement PicDone;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_done") private MobileElement Done;
	public ElevatorBrief enterElevatorMake(String Make) {
		sendKeys(Elevator_Make,Make);
		utils.log().info("Elevator_Make entered");
		return this;
	}
	public ElevatorBrief enterElevatorCapacity(String Capacity) {
		sendKeys(Elevator_Capacity,Capacity);
		utils.log().info("Elevator_Capacity entered");
		return this;
	}
	public ElevatorBrief pressRadioBtnPrePostCheckbox() {
		click(RadioBtnPrePost);
		utils.log().info("RadioBtnPrePostCheckbox selected");
		return this;
	}
	public ElevatorBrief enterSwabCount(String SwabCount) throws InterruptedException {
		sendKeys(Swab_Count,SwabCount);
		TestBase.scrollUD("up", Panel);
		Thread.sleep(5000);
		utils.log().info("up movemnet done");
		return this;
	}
	public ElevatorBrief enterFloorCount(String FloorCount) {
		sendKeys(Floor_Count,FloorCount);
		utils.log().info("FloorCount entered");
		return this;
	}
	
	public ElevatorBrief selectSprayerType() {
		click(SprayerType);
		click(ULV);
		utils.log().info("SprayerType selected");
		return this;
	}
	public ElevatorBrief selectATPMeter() {
		click(ATPMeter);
		click(Merck);
		utils.log().info("SATPMeter selected");
		return this;
	}
	
	
	public ElevatorBrief takeElevatorPic() throws InterruptedException {
		click(CameraIcon);
		click(CameraPermission);
		click(Shutterbutton);
		click(PicDone);
		TestBase.scrollUD("up", Panel);
		Thread.sleep(5000);
		utils.log().info("eElevatorPic taken");
		return this;
	}
	public SelectServiceModulePage submitDetails() {
		click(Done);
		utils.log().info("Details SUbmitted");
		return new SelectServiceModulePage();
	}
		
}