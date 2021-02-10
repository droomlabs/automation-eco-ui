package com.qa.eco.pages;

import java.util.List;

import com.qa.eco.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NinjaHealthDeclaration extends Services{
	
	
	@AndroidFindBy  (xpath = "//*[@text='No']") List<MobileElement> no_buttons;
	@AndroidFindBy  (id = "in.droom.eco:id/btn_done") private MobileElement Done;
	
public NinjaHealthDeclaration answerNoQuestionOne(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}	
public NinjaHealthDeclaration answerNoQuestiontwo(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}	
public NinjaHealthDeclaration answerNoQuestionThree(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}	
public NinjaHealthDeclaration answerNoQuestionFour(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}	
public NinjaHealthDeclaration answerNoQuestionFive(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionSix(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}

public NinjaHealthDeclaration answerNoQuestionSeven(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionEight(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionNine(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionTen(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionEleven(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public NinjaHealthDeclaration answerNoQuestionTwelve(int questnum) {
	int index = questnum -1;
		click(no_buttons.get(index));
		return this;
	}
public Services pressDone() {
	click(Done);
	driver.navigate().back();
	return new Services();
}	
public MetaCategories transferMethod() {
	System.out.println("transfered");
	return new MetaCategories();
}

}