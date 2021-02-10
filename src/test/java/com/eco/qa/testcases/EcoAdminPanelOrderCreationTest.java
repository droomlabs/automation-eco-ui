package com.eco.qa.testcases;

import org.testng.annotations.Test;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.eco.browser.pages.EcoAdminLogin;
import com.qa.eco.browser.pages.NewRequestPage;
import com.qa.eco.browser.pages.OrderManagementPage;
import com.qa.eco.browser.pages.Welcomepage;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class EcoAdminPanelOrderCreationTest extends TestBase{
	EcoAdminLogin EAL ;
	Welcomepage welcomepage;
	OrderManagementPage OMP;
	NewRequestPage NRP;
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
	 // driver.quit();
  }
  @Test
  public void ElevatorOrderCreation() throws Exception {
	 
	  welcomepage=EAL.login("admin","123456");
	  welcomepage.checkPageOpening();
	  OMP=welcomepage.pressOrderManagement();
	  NRP=OMP.pressRaiseNewRequest();
	  NRP.selectVendor("1");
	  NRP.enterCustomerName("name");
	  NRP.enterCustomerAdd("customer addess");
	  NRP.enterCustomerPincode("110058");
	  NRP.enterCustomerPhone("7000848718");
	  NRP.enterCustomerEmail("umang.sharma@droom.in");
	  NRP.selectService("2");
	  Thread.sleep(5000);
	  NRP.selectVehicle("6");
	  NRP.selectSubCategory("20");
	  NRP.selectRportType("germ_shield");
	  NRP.enterCoverageAreaOrCapacity("10");
	  NRP.selectSwabTest("Not available");
	  NRP.enterSwabCount("1");
	  NRP.selectTimeslot1("29/10/2020");
	  NRP.selectTimeslot2("30/10/2020");
	  OMP=NRP.pressSubmit();
	  OMP.assignTechnician("2282");
	  
  }
}
