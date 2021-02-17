package com.eco.qa.testcases;

import org.testng.annotations.Test;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Menu;
import com.qa.eco.pages.Services;
import com.qa.eco.pages.SideMenu;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends TestBase{
	LoginPage loginPage ;
	CommonInitialization cm;
	Services services;
	Menu menu;
	SideMenu SM;
	TestUtils utils = new TestUtils();
	@BeforeClass
	  public void beforeClass() {
		closing();
		launching();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	  cm = new CommonInitialization();
	  
	  //TestBase.scrollLR("right");
	  
	  utils.log().info("method:-"+m.getName());
	  //System.out.println();
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }
  @Test
  public void a_invalidUserPswd() throws InterruptedException {
	  
	  loginPage=cm.initialization();
	  loginPage.enterUserName("invalid@droom.in");
	  loginPage.enterPassword("invalid");
	  loginPage.pressLoginButton2();
	  
	  
	  String actualpouptext = loginPage.getPopupText() ;
		String expectedpouptext = "Wrong password. Please enter the correct password and try again.";
		 utils.log().info("actualpouptext:-"+actualpouptext);
		//System.out.println(actualpouptext);
		Assert.assertEquals(actualpouptext, expectedpouptext);
		loginPage.pressPopupOk();
  }
  @Test
  public void b_invalidUserName() {
	  
	  loginPage.enterUserName("invalid@droom.in");
	  loginPage.enterPassword("@Login123");
	  loginPage.pressLoginButton2();
	  
	  String actualpouptext = loginPage.getPopupText() ;
		String expectedpouptext = "Wrong password. Please enter the correct password and try again.";
		utils.log().info("actualpouptext:-"+actualpouptext);
		//System.out.println(actualpouptext);
		Assert.assertEquals(actualpouptext, expectedpouptext);
		loginPage.pressPopupOk();
  }
  @Test
  public void c_invalidPswd() {
	  
	  loginPage.enterUserName("mitesh.karwa@gaadi.com");
	  loginPage.enterPassword("invalid");
	  loginPage.pressLoginButton2(); 
	  String actualpouptext = loginPage.getPopupText() ;
	  String expectedpouptext = "Wrong password. Please enter the correct password and try again.";
		utils.log().info("actualpouptext:-"+actualpouptext);
		//System.out.println(actualpouptext);
		Assert.assertEquals(actualpouptext, expectedpouptext);
		loginPage.pressPopupOk();
  }
  @Test
  public void d_validUserNamePswd() throws InterruptedException {
	 
	  loginPage.enterUserName("714928mitesh.karwa@gaadi.com");
	  loginPage.enterPassword("@Login123");
	  services=loginPage.pressLoginButton2();
	  services.pressforegroundLocationAllow();
	  SM=services.cickHamburgermenu();
	  SM.logout();
	  Thread.sleep(5000);
  }
}
