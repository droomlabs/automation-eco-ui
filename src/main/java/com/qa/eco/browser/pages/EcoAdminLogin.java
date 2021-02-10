package com.qa.eco.browser.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class EcoAdminLogin extends TestBase {
	
	@FindBy(name="username") WebElement UserName;
	@FindBy(name="password1") WebElement Password;
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[3]/button") WebElement LoginBtn;
	
	TestUtils utils = new TestUtils();
	
	public EcoAdminLogin enterUserName(String username) {
		sendKeysb(UserName , username);
		utils.log().info("user name entered");
		return this;
	}
	public EcoAdminLogin enterPassword(String password) {
		sendKeysb(Password , password);
		utils.log().info("password entered");
		return this;
	}
	public Welcomepage pressLoginButton() {
		clickb(LoginBtn);
		utils.log().info("main login button clicked");
		//return new Services();
		return new Welcomepage();
	}
	public Welcomepage login(String username , String password) {
		enterUserName(username);
		enterPassword(password);
		return pressLoginButton();
		
	}
	

}
