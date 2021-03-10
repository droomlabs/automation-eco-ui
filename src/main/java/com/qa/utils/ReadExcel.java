package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook  wb;
    XSSFSheet sheet1 ;
    TestUtils utils = new TestUtils();
	public ReadExcel(String excelpath) {
		try {
			File src = new File(excelpath);
			 
			 FileInputStream fis = new FileInputStream(src);
 
			  wb = new XSSFWorkbook(fis);
			  FileOutputStream fout = new FileOutputStream(src);
			  wb = new XSSFWorkbook(fout);
		}
		catch (Exception e) {
					utils.log().info(e.getMessage());
		}		
	}
	public String getData(int sheetNumber , int row , int column){
		sheet1 = wb.getSheetAt(sheetNumber);
    String data0=sheet1.getRow(row).getCell(column).getStringCellValue();
     
    return data0;
	}
	public void writeData(int sheetNumber , int row , int column,String oid){
		sheet1 = wb.getSheetAt(sheetNumber);
   sheet1.getRow(row).createCell(column).setCellValue(oid);
   
   wb.write(fout);
   wb.close();    
	}
}
