package com.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.eco.base.TestBase;

public class TestUtils {
	public static final long WAIT=10;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public Logger log() {
		//static Logger log = return LogManager.getLogger(TestBase.class.getName());
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	public static String getotp(String qry) throws Exception
	{
	String url="jdbc:mysql://qa1.droom.in:3306/cscart_new";
	String user="root";
	String password="$6bK6R=a";
//	String qry="SELECT * FROM cscart_new.otp_verification where phone='6307641802' order by id desc limit 1";
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection(url, user, password);
	Statement statement = connection.createStatement();
	System.out.println("connected");
	ResultSet rs = statement.executeQuery(qry);
	rs.next();
	String otp = rs.getString("code");
	//System.out.println(otp);
	//int otpNumber = Integer.parseInt(otp);
   	//System.out.println(otp);
   	//System.out.println(otpNumber);
//	
//	statement.close();
//	connection.close();
	//return otpNumber;
	return otp;
	
}
	
		
}
