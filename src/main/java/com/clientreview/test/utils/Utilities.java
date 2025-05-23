package com.clientreview.test.utils;

import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10; 
	public static final int PAGE_LOAD_TIME=10;
	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public void fetchDataFromXcel(String SheetName)
	{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet= workbook.getSheet(SheetName);
		int rows=sheet.getLastRowNum();
		int cols=sheet.getLastRowNum();
		Object data=new Object[rows][cols];
		
		
		
	}

}
