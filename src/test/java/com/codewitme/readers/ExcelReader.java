package com.codewitme.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
public String[][] getData(String sheetName) throws IOException{
	String a =URLDecoder.decode(this.getClass().getClassLoader().getResource("data.xlsx").getPath(),"UTF-8");
	FileInputStream file = new FileInputStream(new File(a));
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	int rows=sheet.getPhysicalNumberOfRows();
	int cols=sheet.getRow(1).getPhysicalNumberOfCells();
	String[][] srtArray=new String[rows-1][cols];
	for (int i= 1 ; i < rows; i++) {
		for (int j=0; j < cols; j++) {
			Cell cell=sheet.getRow(i).getCell(j);
			srtArray[i-1][j] = cell.getStringCellValue();
		}
	}
	file.close();
	return srtArray;
}
}
