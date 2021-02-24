package com.qa.eco.base;

import org.openqa.selenium.NoSuchElementException;

import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonInitialization extends TestBase{
	
	@AndroidFindBy  (id = "in.droom.eco:id/scrollView1") private MobileElement Panel;
	@AndroidFindBy (id="com.android.permissioncontroller:id/permission_allow_button") private MobileElement PhotoPermissionAllow;
	@AndroidFindBy  (id = "in.droom.eco:id/skip_to_login") private MobileElement LETS_GET_STARTED;
	@AndroidFindBy  (xpath = "//*[@text='LOGIN']") private MobileElement LoginButton1;
	@AndroidFindBy  (id = "in.droom.eco:id/login_text") private MobileElement login_text;
	TestUtils utils = new TestUtils();
	/*LoginButton1.click();
	
	
	User_Id.sendKeys("xyz@drom.in");
	
	Password.sendKeys("@Login123");

	LoginButton2.click();
	
	
	String actualpouptext = PopupText.getAttribute("text");
	System.out.println(actualpouptext);
	String expectedpouptext = "Wrong password. Please enter the correct password and try again.";
    Assert.assertEquals(actualpouptext, expectedpouptext);
	
    
    PopupOk.click();
	*/

	
	public CommonInitialization pressPhotoPermissionAllow() throws InterruptedException {
		click(PhotoPermissionAllow);
		utils.log().info("Photo Permission Given");
		Thread.sleep(4000);
		TestBase.scrollLRUD("right", Panel);
		utils.log().info("right movemnet done");
		return this;
	}
	public CommonInitialization pressLETS_GET_STARTED() {
		click(LETS_GET_STARTED);
		utils.log().info("LETS GET STARTED CLICKED");
		return this;
	}
	public LoginPage pressLoginButton1() {
		click(LoginButton1);
		utils.log().info("outer login button CLICKED");
		return new LoginPage();
	}
	public LoginPage initialization() throws InterruptedException {
		
		try {
	        login_text.isDisplayed();
	        return new LoginPage();
	    //} catch (org.openqa.selenium.NoSuchElementException e) {
		} catch (NoSuchElementException e) {
	    	pressPhotoPermissionAllow();
			pressLETS_GET_STARTED();
			return pressLoginButton1();
	    }
		
		
	}
}