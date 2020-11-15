package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataStorage {

	static FileInputStream fis;
	static Properties pobj = new Properties();
	static FileOutputStream fos;
	public String getDataFromProperty(String key) throws IOException
	{
		fis = new FileInputStream("./src/test/resources/datacontainer/commondata.properties");
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws IOException
	{
		fis = new FileInputStream("./src/test/resources/datacontainer/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	public void updateDataInExcel(String sheetName, int rowNum, int cellNum, String newData) throws IOException
	{
		fis = new FileInputStream("./src/test/resources/datacontainer/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		cel.setCellValue(newData);
		fos = new FileOutputStream("./src/test/resources/datacontainer/testdata.xlsx");
		book.write(fos);
		fos.flush();		
	}
	
	public void addNewCellDataInExcel(String sheetName, int rowNum, int cellNum, String newData) throws IOException
	{
		fis = new FileInputStream("./src/test/resources/datacontainer/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cel.setCellValue(newData);
		fos = new FileOutputStream("./src/test/resources/datacontainer/testdata.xlsx");
		book.write(fos);
		fos.flush();	
	}
}
