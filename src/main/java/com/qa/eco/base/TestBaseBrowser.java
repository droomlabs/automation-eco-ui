package com.qa.eco.base;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
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
public class TestBaseBrowser {
	
	protected static WebDriver driver2;
	protected static Properties props;
	InputStream inputStream;
	TestUtils utils = new TestUtils();
	JavascriptExecutor js = (JavascriptExecutor) driver2;
	public TestBaseBrowser() {
		PageFactory.initElements(driver2, this);	
	}

	
	@Parameters()
	@BeforeTest
	public  void beforeTest() throws Exception {
		try {
			System.out.println("insidebrowser");
			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			
			String browserName = props.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "D:\\java\\DRIVER\\chromedriver_win32\\chromedriver.exe");	
				driver2 = new ChromeDriver();
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "D:\\java\\DRIVER\\geckodriver-v0.26.0-win64\\geckodriver-v0.26.0-win64.exe");	
				driver2 = new FirefoxDriver(); 
			}
			
			driver2.manage().window().maximize();
			driver2.manage().deleteAllCookies();
			driver2.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver2.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver2.get(props.getProperty("url"));
			

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

	public void waitForVisibilitybrowser(WebElement we) {
		WebDriverWait wait2 = new WebDriverWait(driver2,TestUtils.WAIT);
		wait2.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void clickb(WebElement we){
		waitForVisibilitybrowser(we);
		we.click();
	}
	public void selectbyindex(WebElement we,int index){
		waitForVisibilitybrowser(we);
		Select f = new Select(we);
	    f.selectByIndex(index);;		
	}
	public void selectbyvlaue(WebElement we,String value){
		waitForVisibilitybrowser(we);
		Select f = new Select(we);
	    f.selectByValue(value);
	    }
	public void selectbytext(WebElement we,String text){
		waitForVisibilitybrowser(we);
		Select f = new Select(we);
	    f.selectByVisibleText(text);		
	}
	
	public void sendKeysb(WebElement we, String txt){
		waitForVisibilitybrowser(we);
		we.sendKeys(txt);
	}
	public void pagescroll(String s){
		js.executeScript(s);
	}
	
	public String getAttributeb(WebElement we , String attribute){
		waitForVisibilitybrowser(we);
	return we.getAttribute(attribute);
	}
	
	
	
	public boolean isElementDisplayedb(WebElement element){
	    try{
	        return element.isDisplayed();

	    }catch(Exception e){
	        System.out.println(e);
	        return false;
	    }
	}
	
public static void Calender(String dateTime ,int x , List<WebElement> list_AllMonthToBook , WebElement midLink , WebElement previousLink , WebElement timeslot , WebElement nextLink) {
		

		
	    timeslot.click();
	    String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
	    midLink.click();
		//System.out.println("yearDiff"+Calendar.getInstance().get(Calendar.YEAR));
	    int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
	    System.out.println(yearDiff);
	    if(yearDiff!=0){

	        //if you have to move next year

	        if(yearDiff>0){

	            for(int i=0;i< yearDiff;i++){

	                System.out.println("Year Diff->"+i);

	                nextLink.click();

	            }

	        }

	        //if you have to move previous year

	        else if(yearDiff<0){

	            for(int i=0;i< (yearDiff*(-1));i++){

	                System.out.println("Year Diff->"+i);

	                previousLink.click();

	            }

	        }

	    }
	    
	    System.out.println("month");
	  // list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
	    list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])).click();
	   System.out.println("date");
	   System.out.println(date_dd_MM_yyyy[0]);
	   if (x==1) {
		   WebElement date = driver2.findElement(By.xpath("/html/body/div[4]/ul/li[1]/div/div[1]/table/tbody/tr/td[contains(text(),"+date_dd_MM_yyyy[0]+")]"));
		   date.click();
		   System.out.println("date click");
	   }
	   else {
		   
	   WebElement date2 = driver2.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div/div[1]/table/tbody/tr/td[contains(text(),"+date_dd_MM_yyyy[0]+")]"));
	   System.out.println("date click");	   
	   date2.click();
	   }
	   
	    
	   
		
	}

	@AfterTest
	public  void afterTest() {
		System.out.println("insidebrowserafter");
		driver2.quit();
	}

}
