package com.qa.eco.base;

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

public class TestBase {
	protected static AppiumDriver driver ;
	protected static WebDriver driver2;
	protected static Properties props;
	InputStream inputStream;
	TestUtils utils = new TestUtils();
	JavascriptExecutor js = (JavascriptExecutor) driver2;
	public TestBase() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver2, this);
	}

	@Parameters({"platformName","platformVersion","deviceName"})
	@BeforeTest
	public void beforeTest(String platformName , String platformVersion , String deviceName) throws Exception {
		try {
			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", "63d521db0806");
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
			//throw e;
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
	public void waitForVisibilitybrowser(WebElement e) {
		WebDriverWait wait2 = new WebDriverWait(driver2,TestUtils.WAIT);
		wait2.until(ExpectedConditions.visibilityOf(e));
	}
	public void click(MobileElement e){
		waitForVisibility(e);
		e.click();
	}
	public void clickb(WebElement e){
		waitForVisibilitybrowser(e);
		e.click();
	}
	public void selectbyindex(WebElement e,int index){
		waitForVisibilitybrowser(e);
		Select f = new Select(e);
	    f.selectByIndex(index);;		
	}
	public void selectbyvlaue(WebElement e,String value){
		waitForVisibilitybrowser(e);
		Select f = new Select(e);
	    f.selectByValue(value);
	    }
	public void selectbytext(WebElement e,String text){
		waitForVisibilitybrowser(e);
		Select f = new Select(e);
	    f.selectByVisibleText(text);		
	}
	public void sendKeys(MobileElement e, String txt){
		waitForVisibility(e);
		e.sendKeys(txt);
	}
	public void sendKeysb(WebElement e, String txt){
		waitForVisibilitybrowser(e);
		e.sendKeys(txt);
	}
	public void pagescroll(String s){
		js.executeScript(s);
	}
	public String getAttribute(MobileElement e , String attribute){
		waitForVisibility(e);
	return e.getAttribute(attribute);
	}
	public String getAttributeb(WebElement e , String attribute){
		waitForVisibilitybrowser(e);
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
	public boolean isElementDisplayedb(WebElement element){
	    try{
	        return element.isDisplayed();

	    }catch(Exception e){
	        //System.out.println(e);
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
	public void afterTest() {
		driver.quit();
		driver2.quit();
	}


	/*	
	static AppiumDriver<MobileElement> driver ;
  @Test
  public void invalidLoginUsername() throws InterruptedException {
	  Thread.sleep(15000);
	MobileElement LoginButton1 = driver.findElement(By.xpath("//*[@text='LOGIN']"));
	LoginButton1.click();
	//MobileElement LoginButton1 = driver.findElement(By.id("in.droom.eco:id/login"));
	//MobileElement User_Id = driver.findElement(By.xpath("//*[@id='et_email']"));
	MobileElement User_Id = driver.findElement(By.id("in.droom.eco:id/et_email"));
	User_Id.sendKeys("xyz@drom.in");
	//MobileElement Password = driver.findElement(By.xpath("//*[@id='et_pwd']"));
	MobileElement Password = driver.findElement(By.id("in.droom.eco:id/et_pwd"));
	Password.sendKeys("@Login123");

	MobileElement LoginButton2 = driver.findElement(By.xpath("//*[@text='LOGIN']"));
	LoginButton2.click();
	MobileElement PopupText = driver.findElement(By.id("in.droom.eco:id/alert_text"));	
	System.out.println("4");
	String actualpouptext = PopupText.getAttribute("text");
	System.out.println(actualpouptext);
	String expectedpouptext = "Wrong password. Please enter the correct password and try again.";
    Assert.assertEquals(actualpouptext, expectedpouptext);
	//MobileElement Popup = driver.findElement(By.xpath("//*[@text='OK']"));
    MobileElement Popup = driver.findElement(By.id("in.droom.eco:id/ok"));
    Popup.click();
	System.out.println("6");

	//new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='back']")));
	//driver.findElement(By.xpath("//*[@id='back']")).click();
    //driver.findElement(By.xpath("//*[@id='back']")).click();

  }
  @BeforeClass
  public void beforeClass() {
	  try {
		  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		  desiredCapabilities.setCapability("devicename", "Redmi");
		  desiredCapabilities.setCapability("udid", "63d521db0806");
		  desiredCapabilities.setCapability("platformName", "Android");
		  desiredCapabilities.setCapability("platformVersion", "10 QKQ1.191014.001");
		  desiredCapabilities.setCapability("appPackage","in.droom.eco");
		  desiredCapabilities.setCapability("appActivity","in.droom.eco.activity.SplashActivity");

		  URL url = new URL("http://127.0.0.1:4723/wd/hub");

		  driver = new AppiumDriver<MobileElement>(url,desiredCapabilities);
		  System.out.println("Application Started");
		  String sessionId = driver.getSessionId().toString();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception exp) {
	       System.out.println(exp.getCause()); 
	        System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

  }

  @AfterSuite
  public void afterClass() {
	  driver.quit();
  }
  
  public static void scrollLR(String direction) {
		Dimension dim = driver.manage().window().getSize();
		int startX = 0;
		int endX = 0;
		int Y = dim.getHeight()/2;
				
		switch(direction) {
		case "right":
			startX = (int)(dim.getWidth() * 0.8);
			endX = (int)(dim.getWidth() * 0.2);
		     break;
		case "left":
			startX = (int)(dim.getWidth() * 0.2);
			endX = (int)(dim.getWidth() * 0.8);
	     break;
		}
		System.out.println(endX);
		TouchAction t = new TouchAction(driver);
	    t.press(PointOption.point(startX, Y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).moveTo(PointOption.point(endX, Y)).release().perform();
		
	}

	 */
}
