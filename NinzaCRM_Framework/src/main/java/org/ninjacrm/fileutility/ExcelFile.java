package org.ninjacrm.fileutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	
	public String getDataFromExcel(String sheet,int row,int cell) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Users\\QSP\\eclipse-workspace1\\Frame\\src\\test\\resources\\NinjaCRMData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		file.close();
		return value;
	}
	
	public int getNumberOfRows(String sheet) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Users\\QSP\\eclipse-workspace1\\Frame\\src\\test\\resources\\NinjaCRMData.xlsx");	
		Workbook wb = WorkbookFactory.create(file);
		int value = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		file.close();
		return value;
	}

}
