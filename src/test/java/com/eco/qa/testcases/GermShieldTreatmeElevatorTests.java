package com.eco.qa.testcases;

import org.testng.annotations.Test;

import com.qa.eco.base.CommonInitialization;
import com.qa.eco.base.TestBase;
import com.qa.eco.pages.BeforeTreatmentPage;
import com.qa.eco.pages.CommonCompletedTreatmentPage;
import com.qa.eco.pages.CommonNewRequestPage;
import com.qa.eco.pages.CommonPendingTreatmentPage;
import com.qa.eco.pages.CommonSubCategorydPage;
import com.qa.eco.pages.ElevatorBrief;
import com.qa.eco.pages.ElevatorBriefAiml;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.MetaCategories;
import com.qa.eco.pages.NinjaHealthDeclaration;
import com.qa.eco.pages.PostTreatmentPage;
import com.qa.eco.pages.SelectServiceModulePage;
import com.qa.eco.pages.Services;
import com.qa.eco.pages.TreatmentDurationPage;
import com.qa.eco.pages.TreatmentSubcategory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.Console;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GermShieldTreatmeElevatorTests extends TestBase{
	CommonInitialization cm;
	LoginPage loginPage ;
	Services services;
	CommonSubCategorydPage cscp;
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
		 
	  }

	  @AfterClass
	  public void afterClass() {
	  }
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  System.out.println("done");
	 
	  cm = new CommonInitialization();
	  System.out.println("done2");
	  //TestBase.scrollLR("right");
	  
	  System.out.println("method:-"+m.getName());
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
	  String n=c.readLine();
	  if (n=="inside else") {
		  mc =nh.transferMethod();
	  }
	  else {
		  int i;
		  for(i=1;i==12;i++) {
		  nh.answerNoQuestionEight(i);
		  }
		  services=nh.pressDone();
		  mc=services.pressCheckServices2();
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
	  BTP=cctp.pressBeforeGermshieldReading();
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
	  Thread.sleep(10000);
  }
}
