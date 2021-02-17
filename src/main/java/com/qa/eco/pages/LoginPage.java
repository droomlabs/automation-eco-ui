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

public class LoginPage extends TestBase{
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy  (id = "in.droom.eco:id/et_email") private MobileElement User_Id;
	@AndroidFindBy  (id = "in.droom.eco:id/et_pwd") private MobileElement Password;
	@AndroidFindBy  (xpath = "//*[@text='LOGIN']") private MobileElement LoginButton2;
	@AndroidFindBy  (id = "in.droom.eco:id/alert_text") private MobileElement PopupText;
	@AndroidFindBy  (id = "in.droom.eco:id/ok") private MobileElement PopupOk;
	
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
	

public LoginPage enterUserName(String username) {
	sendKeys(User_Id , username);
	utils.log().info("user name entered");
	return this;
}
public LoginPage enterPassword(String password) {
	sendKeys(Password , password);
	utils.log().info("password entered");
	return this;
}
public Services pressLoginButton2() {
	click(LoginButton2);
	utils.log().info("main login button clicked");
	return new Services();
}
public Services login(String username , String password) {
	enterUserName(username);
	enterPassword(password);
	return pressLoginButton2();
}
public String getPopupText() {
	utils.log().info("error popup visible");
	return getAttribute(PopupText , "text");
	
}

public LoginPage pressPopupOk() {
	click(PopupOk);
	utils.log().info("error popup ok clicked");
	return this;
}

}