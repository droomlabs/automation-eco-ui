package com.eco.qa.testcases;

import org.testng.annotations.Test;

import com.qa.eco.base.CommonInitialization;

import com.qa.eco.base.TestBaseBrowser;
import com.qa.eco.browser.pages.EcoAdminLogOut;
import com.qa.eco.browser.pages.EcoAdminLogin;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class EcoAdminPanelLoginTest extends TestBaseBrowser{
	EcoAdminLogin EAL ;
	EcoAdminLogOut EALO;
	
	TestUtils utils = new TestUtils();
	@BeforeClass
	  public void beforeClass() {
		 
	  }

	  @AfterClass
	  public void afterClass() {
	  }
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	  EAL = new EcoAdminLogin();
	  
	  //TestBase.scrollLR("right");
	  
	  utils.log().info("method:-"+m.getName());
	  //System.out.println();
  }

  @AfterMethod
  public void afterMethod() {
	  EALO.logout();
  }
  @Test
  public void validUserNamePswd() throws InterruptedException {
	 
	  EAL.login("admin","123456");
	  
	  Thread.sleep(1000);
  }
}
