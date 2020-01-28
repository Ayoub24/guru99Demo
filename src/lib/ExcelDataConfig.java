package lib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb; 
	
	XSSFSheet ws;
	
	public ExcelDataConfig (String excelPath){
		
		try {
			File src = new File(excelPath);
			
			FileInputStream FInput = new FileInputStream(src);
			
			wb = new XSSFWorkbook(FInput);
			
		} catch (Exception e) {
			System.out.println("Exception is .. " + e.getMessage());
		} 
				
	}
	
	public String getData(int sheetNum, int row, int column) {
		
		ws = wb.getSheetAt(sheetNum);
		
		String data = ws.getRow(row).getCell(column).getStringCellValue();
		
		return data;		
		
	}
	
	public int getSheetRowNumber(int sheetNum) {
		
		int rowNumber = wb.getSheetAt(sheetNum).getLastRowNum();
		
		rowNumber = rowNumber + 1;
		
		return rowNumber;
	}	 
	 
}
