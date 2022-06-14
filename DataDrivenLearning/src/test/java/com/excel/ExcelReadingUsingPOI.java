package com.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingUsingPOI {
	public void excelreading() throws IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\Desktop\\prine\\LoginDetails.xlsx");
Workbook workbook=new XSSFWorkbook(file);
	Sheet sheet1=workbook.getSheetAt(0);
	Iterator<Row> rowiterator = sheet1.iterator();
	while(rowiterator.hasNext()) {
		Row rowvalue = rowiterator.next();
		Iterator<Cell> columniterator = rowvalue.iterator();
		while(columniterator.hasNext()) {
			Cell cellvalue = columniterator.next();
			System.out.println(cellvalue);
		}
		
	}
}
	public static void main(String[] args) throws IOException {
		ExcelReadingUsingPOI usingpoi=new ExcelReadingUsingPOI();
		usingpoi.excelreading();
	}
}
