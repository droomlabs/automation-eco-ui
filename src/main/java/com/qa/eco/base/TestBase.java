package com.qa.eco.base;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
@Listeners(ExtentITestListenerClassAdapter.class)
public class TestBase {
	protected static AppiumDriver  driver ;
	protected static Properties props;
	InputStream inputStream;
	TestUtils utils = new TestUtils();
	
	public TestBase() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@Parameters({"platformName","platformVersion","deviceName"})
	@BeforeTest
	public  void beforeTest(String platformName , String platformVersion , String deviceName) throws Exception {
		try {
			
			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("udid", "172.20.8.117:5555");
			desiredCapabilities.setCapability("unicodeKeyboard", true);
			desiredCapabilities.setCapability("resetKeyboard", true);
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("platformVersion", platformVersion);
			desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
			desiredCapabilities.setCapability("appPackage",props.getProperty("androidAppPackage"));
			desiredCapabilities.setCapability("appActivity",props.getProperty("androidAppActicity"));
			
			//URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
			//desiredCapabilities.setCapability("app","C:/Users/umang.sharma/eclipse-workspace/EcoApp/target/test-classes/app/eco_2.8.20_qa.apk");
			//URL url = new URL("http://127.0.0.1:4723/wd/hub");
		String appUrl1 = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
		String appUrl=charAt(appUrl1, 0);
	     desiredCapabilities.setCapability("app",appUrl);
			
			URL url = new URL(props.getProperty("appiumURL"));

			driver = new AppiumDriver(url,desiredCapabilities);
			utils.log().info("Application Started");
			String sessionId = driver.getSessionId().toString();
			
			
		} catch (Exception e) {
			System.out.println(e.getCause()); 
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	public static String charAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
     }  
	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
public void back() {
	driver.navigate().back();
}

	public void click(MobileElement e){
		waitForVisibility(e);
		e.click();
	}
	
	public void sendKeys(MobileElement e, String txt){
		waitForVisibility(e);
		e.sendKeys(txt);
	}
	
	public String getAttribute(MobileElement e , String attribute){
		waitForVisibility(e);
	return e.getAttribute(attribute);
	}
	
	
	public static void scrollLRUD(String direction, MobileElement Panel) {
		Dimension dim = Panel.getSize();
		
		int start=0;
		int end=0;
		int cons =0;
				
		switch(direction) {
		case "right":
			Double startX = (Double)(dim.getWidth() * 0.8);
			start = (int)(startX.intValue());
			Double endX = (Double)(dim.getWidth() * 0.2);
			end = (int)(endX.intValue());
			Double Y = (Double)(dim.getHeight()*0.5);
			cons = (int)(Y.intValue());
		     break;
		case "left":
			startX = (Double)(dim.getWidth() * 0.2);
			start = (int)(startX.intValue());
			endX = (Double)(dim.getWidth() * 0.8);
			end = (int)(endX.intValue());
			 Y = (Double)(dim.getHeight()*0.5);
			cons = (int)(Y.intValue());
	     break;
		
		}
		
		new TouchAction((PerformsTouchActions) driver)
	    .press(PointOption.point(start, cons)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	    .moveTo(PointOption.point(end, cons)).release().perform();
		
	}
	public static void scrollUD(String direction, MobileElement Panel) {
		Dimension dim = Panel.getSize();
		
		int start=0;
		int end=0;
		int cons =0;
		switch(direction) {
		case "up":
			
			Double startY = (Double)(dim.getHeight() * 0.9);
		    start = (int)(startY.intValue());
			//System.out.println(start);
			Double endY = (Double)(dim.getHeight() * 0.2);
			end = (int)(endY.intValue());
			//System.out.println(end);
			Double X = (Double)(dim.getWidth() * 0.5);
			cons = (int)(X.intValue());
			//System.out.println(cons);
			
		     break;
		case "down":
			startY = (Double)(dim.getHeight() * 0.2);
			start = (int)(startY.intValue());
			endY = (Double)(dim.getHeight() * 0.8);
			end = (int)(endY.intValue());
			 X = (Double)(dim.getWidth()*0.5);
			cons = (int)(X.intValue());
		     break;
		}
		
		new TouchAction((PerformsTouchActions) driver)
	    .press(PointOption.point(cons, start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	    .moveTo(PointOption.point(cons, end)).release().perform();
		
	}

	public boolean isElementDisplayed(MobileElement element){
	    try{
	        return element.isDisplayed();

	    }catch(Exception e){
	        //System.out.println(e);
	        return false;
	    }
	}
	

public void closing() {
	((InteractsWithApps)driver).closeApp();
}
public void launching() {
	((InteractsWithApps)driver).launchApp();
}
	@AfterTest
	public  void afterTest() {
		driver.quit();
		
	}
}
