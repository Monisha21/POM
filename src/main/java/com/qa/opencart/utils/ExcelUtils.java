package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	//We need to use apache POI API to read the data from excel sheet
	private static String TEST_DATA_SHEET = "C:\\Users\\rkmde\\eclipse-workspace\\POMSeries\\src\\test\\resources\\TestData\\DemocartTestdata.xlsx";
	private static Workbook workbook;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname) {
		
		Object data[][] = null;
		
		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET);
			workbook = WorkbookFactory.create(fis);
			sheet = workbook.getSheet(sheetname);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i< sheet.getLastRowNum(); i++) {
				for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;
	}
	

}
