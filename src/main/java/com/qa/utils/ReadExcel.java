package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public void ReadData() throws Exception{
	
	File src = new File("C:\\Users\\umang.sharma\\Desktop\\Datafolder\\DataForAPP.xlsx");
 
     FileInputStream fis = new FileInputStream(src);
 
     XSSFWorkbook  wb = new XSSFWorkbook(fis);
    
 
	}
}
