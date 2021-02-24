package com.eco.qa.testcases;

import org.testng.annotations.Test;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.eco.pages.BeforeTreatmentPage;
import com.qa.eco.pages.CommonCompletedTreatmentPage;
import com.qa.eco.pages.CommonNewRequestPage;
import com.qa.eco.pages.CommonPageToSubCategories;
import com.qa.eco.pages.CommonPendingTreatmentPage;

import com.qa.eco.pages.ElevatorBrief;
import com.qa.eco.pages.ElevatorBriefAiml;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Menu;
import com.qa.eco.pages.MetaCategories;
import com.qa.eco.pages.NinjaHealthDeclaration;
import com.qa.eco.pages.PostTreatmentPage;
import com.qa.eco.pages.SelectServiceModulePage;
import com.qa.eco.pages.Services;
import com.qa.eco.pages.SideMenu;
import com.qa.eco.pages.TreatmentDurationPage;
import com.qa.eco.pages.TreatmentSubcategory;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.Console;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GermShieldTreatmeElevatorTests extends TestBase{
	TestUtils utils = new TestUtils();
	CommonInitialization cm;
	LoginPage loginPage ;
	Services services;
	SideMenu SM;
	CommonPageToSubCategories cscp;
	MetaCategories mc;
	TreatmentSubcategory ts;
	CommonNewRequestPage cnrp;
	CommonPendingTreatmentPage cptp;
	ElevatorBriefAiml EBA;
	ElevatorBrief EB;
	BeforeTreatmentPage BTP;
	TreatmentDurationPage TDP;
	CommonCompletedTreatmentPage cctp;
	SelectServiceModulePage SSMP;
	PostTreatmentPage PTP;
	NinjaHealthDeclaration nh;
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
  }

  @AfterMethod
  public void afterMethod() {
	  
  }
 
  @Test
  public void ElevatorIdealFlow() throws Exception {
	  Console c =System.console();
	  	  
	  loginPage=cm.initialization();
	 services=loginPage.login("714928mitesh.karwa@gaadi.com","@Login123");
	  
	  services.pressforegroundLocationAllow();
	  nh=services.pressCheckServices();
	  try {
		  nh.answerNoQuestion();
		  services=nh.pressDone();
		  mc=services.pressCheckServices2();
	  }
	 catch (Exception e) {
		  mc =nh.transferMethod();
	 }
	  
	  ts=mc.pressTreatmentTab();
	  cscp=ts.pressGermshieldViewOrders();
	  cnrp=cscp.pressNewRequestTab();
      cnrp.pressAcceptMark();
      cptp=cnrp.pressYesForOrderAccept();
      cptp.pressSearchButton();
      cptp.enterSearchText("179819");
      cptp.pressStartForLocation();
      cptp.pressReadyToStart();
      cptp.pressReachedLocation();
      cptp.pressFinishTrip();
      cptp.pressStartService();	  
      SSMP=cptp.pressConfirmService();
	  EBA=SSMP.pressElevatorBrief();
	  EBA.pressSkipStep();
	  EB=EBA.pressSkipCapacityStep();
	  EB.enterElevatorMake("Make");
	  EB.enterElevatorCapacity("10");
	  EB.pressRadioBtnPrePostCheckbox();
	  EB.enterSwabCount("1"); 
	  EB.enterFloorCount("11"); 
	  EB.selectSprayerType();
	  EB.selectATPMeter();
	  EB.takeElevatorPic();
	  SSMP=EB.submitDetails();
	  BTP=SSMP.pressBeforeGermshieldReading();
	 // BTP=cctp.pressBeforeGermshieldReading();
	  BTP.takeBeforeTreatmentPhotos();
	  BTP.enterTreatmentAreaName("TreatmentArea");
	  BTP.enterInitialReading("200");
	  SSMP=BTP.pressFinishBtn();
	  TDP=SSMP.pressGermshieldReadingDuration();
	  TDP.pressTimerBtn();
	  SSMP=TDP.pressFinishBtn();
	  PTP=SSMP.pressPostGermshieldReading();
	  PTP.takePostTreatmentPhotos();
	  PTP.enterFinalReading("300");
	  SSMP=PTP.pressFinishBtn();
	  cctp=SSMP.pressSelectServiceModulePageFinishBtn();
	  cctp.pressGenerateReport();
	  SM=cctp.cickHamburgermenu();
	  SM.logout();
	  Thread.sleep(10000);
  }
}
