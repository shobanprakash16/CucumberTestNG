package Ultils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	//File file =new File("filepath");
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle cellStyle;
	String filePath="C:\\\\Users\\\\Shoban\\\\eclipse-workspace\\\\NewProject\\\\NewProject1\\\\CucumberTestNG\\\\TestData.xlsx";
	
	public ExcelUtility(String Path) {
		this.filePath=filePath;
	}
	
	
	public String getCellValue(String SheetName) throws IOException {
		String cellValue = null;
		fis=new FileInputStream(filePath);
		workbook =new XSSFWorkbook(fis);		
		sheet=workbook.getSheet(SheetName);
		int rowCount=sheet.getLastRowNum();
		System.out.println("====Row Count is===="+rowCount);
		for (int i=0;i<rowCount;i++) {
			{
				Row row=sheet.getRow(i);
				System.out.println("====Column Count is===="+row.getLastCellNum());
				for (int j=0;j<row.getLastCellNum();j++) {
					cellValue=row.getCell(j).getStringCellValue();
					//System.out.println(cellValue);
				}
			}
			
		}
		workbook.close();
		fis.close();
		return cellValue;
		
	}
	
	public int cellCount(String SheetName, int rowNum) throws IOException {
		
		fis=new FileInputStream(filePath);
		workbook =new XSSFWorkbook(fis);		
		sheet=workbook.getSheet(SheetName);
		row=sheet.getRow(rowNum);		
		int cellCount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;		
	}
	
	public String getCellData(String SheetName,int rowNum, int column) throws IOException {
		
		fis=new FileInputStream(filePath);
		workbook =new XSSFWorkbook(fis);		
		sheet=workbook.getSheet(SheetName);
		row=sheet.getRow(rowNum);	
		cell=row.getCell(column);
		
		
		String cellValue="";
		workbook.close();
		fis.close();
		
		return cellValue;
		
	}
	
	
	
	
	
	
	
	

}
