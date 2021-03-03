package com.qa.eco.browser.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.eco.base.TestBase;
import com.qa.eco.pages.LoginPage;
import com.qa.eco.pages.Services;
import com.qa.utils.TestUtils;

public class NewRequestPage extends BrowserMenu {
	
	 String Order_id;
	
	@FindBy(id="vendor_id") WebElement Vendor;
	@FindBy(id="cust_name") WebElement Customer;
	@FindBy(id="cust_addr") WebElement Address;
	@FindBy(id="cust_pincode") WebElement Pincode;
	@FindBy(id="cust_phone") WebElement Phone;
	@FindBy(id="cust_email") WebElement Email;
	@FindBy(id="cust_service") WebElement Service;
	@FindBy(id="cust_vehicle") WebElement Vehicle;
	@FindBy(id="sub_category_type") WebElement SubCategory;
	@FindBy(id="report_type") WebElement RportType;
	@FindBy(id="coverage_area") WebElement CoverageAreaOrCapacity;
	@FindBy(id="swab_test") WebElement SwabTest;
	@FindBy(id="swab_count") WebElement SwabCount;
	@FindBy(xpath="//*[@id=\"dateRangePicker\"]/span") WebElement Timeslot1;
	@FindBy(xpath="/html/body/div[4]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]") WebElement midLink1;
	@FindBy(xpath="/html/body/div[4]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]") WebElement previousLink1;
	@FindBy(xpath="/html/body/div[4]/ul/li[1]/div/div[2]/table/thead/tr/th[3]") WebElement nextLink1;
	//@FindBy(xpath="/html/body/div[4]/ul/li[1]/div/div[1]/table/tbody/tr/td") WebElement date1;
	@FindBy(xpath="/html/body/div[4]/ul/li[1]/div/div[2]/table/tbody/tr/td/span")  List<WebElement> list_AllMonthToBook1;
	              
	@FindBy(xpath="//*[@id=\"dateRangePicker1\"]/span") WebElement Timeslot2;
	@FindBy(xpath="/html/body/div[5]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]") WebElement midLink2;
	@FindBy(xpath="/html/body/div[5]/ul/li[1]/div/div[2]/table/thead/tr/th[1]") WebElement previousLink2;
	@FindBy(xpath="/html/body/div[5]/ul/li[1]/div/div[2]/table/thead/tr/th[3]") WebElement nextLink2;
	//@FindBy(xpath="/html/body/div[5]/ul/li[1]/div/div[1]/table/tbody/tr/td") WebElement date2;
	@FindBy(xpath="/html/body/div[5]/ul/li[1]/div/div[2]/table/tbody/tr/td/span")  List<WebElement> list_AllMonthToBook2;
	@FindBy(xpath="//*[@id=\"new_order\"]/div/div[29]/input[2]") WebElement Submit;
	//@FindBy(xpath="//div[@class='modal-body'][@class='_14p'][@class='thin']") WebElement Order_Id;
	@FindBy(xpath="//div[@class='modal-body _14p thin']") WebElement Order_Id;
	TestUtils utils = new TestUtils();
		
	
	public NewRequestPage selectVendor(String vendor) {
		selectbyvlaue(Vendor,vendor);
		utils.log().info("Vendor selcted");
		return this;
	}
	public NewRequestPage enterCustomerName(String customername) {
		sendKeysb(Customer,customername);
		utils.log().info("customername entered");
		return this;
	}
	public NewRequestPage enterCustomerAdd(String customeradd) {
		sendKeysb(Address,customeradd);
		utils.log().info("customer address entered");
		return this;
	}
	public NewRequestPage enterCustomerPincode(String pincode) {
		sendKeysb(Pincode,pincode);
		utils.log().info("customer Pincode entered");
		return this;
	}
	public NewRequestPage enterCustomerPhone(String phone) {
		sendKeysb(Phone,phone);
		utils.log().info("customer phone entered");
		return this;
	}
	public NewRequestPage enterCustomerEmail(String email) {
		sendKeysb(Email,email);
		utils.log().info("customer email entered");
		return this;
	}
	public NewRequestPage selectService(String service) {
		selectbyvlaue(Service,service);
		utils.log().info("Service selcted");
		pagescroll("window.scrollBy(0,500)");
		  utils.log().info("Pagescroll done");
		return this;
	}
	public NewRequestPage selectVehicle(String vehicle) {
		selectbyvlaue(Vehicle,vehicle);
		utils.log().info("Vehicle selcted");
		return this;
	}
	public NewRequestPage selectSubCategory(String subcategory) {
		selectbyvlaue(SubCategory,subcategory);
		
		utils.log().info("SubCategory selcted");
		return this;
	}
	public NewRequestPage selectRportType(String rporttype) {
		selectbyvlaue(RportType,rporttype);
		utils.log().info("RportType selcted");
		return this;
	}
	public NewRequestPage enterCoverageAreaOrCapacity(String coverageareaorcapacity) {
		sendKeysb(CoverageAreaOrCapacity,coverageareaorcapacity);
		utils.log().info("CoverageAreaOrCapacity entered");
		return this;
	}
	public NewRequestPage selectSwabTest(String swabtest) {
		selectbyvlaue(SwabTest,swabtest);
		utils.log().info("SwabTest selcted");
		return this;
	}
	public NewRequestPage enterSwabCount(String swabcount) {
		sendKeysb(SwabCount,swabcount);
		utils.log().info("SwabCount entered");
		return this;
	}
	public NewRequestPage selectTimeslot1(String dateTime)  {
		pagescroll("window.scrollBy(0,200)");
		  utils.log().info("Pagescroll done");
		WebElement timeslot =  Timeslot1;
		//WebElement date =  date1;
		WebElement midLink =  midLink1;
		WebElement previousLink =  previousLink1;
		WebElement nextLink =  nextLink1;
		List<WebElement> list_AllMonthToBook = list_AllMonthToBook1;
		Calender(dateTime, 1, list_AllMonthToBook, midLink, previousLink, timeslot, nextLink);
		utils.log().info("selectTimeslot1 selcted");
		return this;
	}
	public NewRequestPage selectTimeslot2(String dateTime) {
		WebElement timeslot =  Timeslot2;
		//WebElement date =  date2;
		WebElement midLink =  midLink2;
		WebElement previousLink =  previousLink2;
		WebElement nextLink =  nextLink2;
		List<WebElement> list_AllMonthToBook = list_AllMonthToBook2;
		Calender(dateTime,2, list_AllMonthToBook, midLink, previousLink, timeslot, nextLink);
		utils.log().info("selectTimeslot2 selcted");
		return this;
	}
	

	
	public OrderManagementPage pressSubmit() {
		clickb(Submit);
		utils.log().info("Submit button clicked");
		String text = Order_Id.getText();
		String[] arrOfStr =   text.split("-", 2);
		Order_id=arrOfStr[1];
		return new OrderManagementPage();
		
	}

}
