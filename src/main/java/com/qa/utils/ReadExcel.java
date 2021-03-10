package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.RowIdLifetime;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {


		FileInputStream ExcelFile = new FileInputStream(Path);


		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

}


public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";

			}

}

public static void setCellData(String Result,  int RowNum, int ColNum,String Path) throws Exception	{

		try{

			Row  = ExcelWSheet.getRow(RowNum);

		Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

		if (Cell == null) {

			Cell = Row.createCell(ColNum);

			Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

				FileOutputStream fileOut = new FileOutputStream(Path);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}

	}
	
	/*XSSFWorkbook  wb;
	FileOutputStream fout;
    XSSFSheet sheet1 ;
    TestUtils utils = new TestUtils();
	public ReadExcel(String excelpath) {
		try {
			File src = new File(excelpath);
			 
			 FileInputStream fis = new FileInputStream(src);
 
			  wb = new XSSFWorkbook(fis);
			  fout = new FileOutputStream(src);
			  
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
	}*/
}
