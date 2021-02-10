package com.qa.utils;

   import java.io.File;
   import org.automationtesting.excelreport.Xl;
   import org.testng.annotations.Test;
   
   public class TestReport{
   @Test
   public void report() throws Exception{
   /*try {
   File file = new File("./ExcelstatusReport.xlsx");
   if(file.exists()) {
   file.delete();
   System.out.println("Found And deleted !!!");
   Thread.sleep(5000);
   }
   } catch (Exception e) {
   e.printStackTrace();
   }
   Xl.generateReport(".","ExcelstatusReport.xlsx" );
   */Xl.generateReport("ExcelstatusReport.xlsx" );}}


