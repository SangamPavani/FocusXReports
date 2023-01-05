package com.focus.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//import com.focus.base.BaseEngine;

public class ExcelReader
{
	private String filePath;
	private FileInputStream fip;
	private FileOutputStream fop;
	private Workbook workbook;
	private Sheet sheet;
	private Cell cell;
	private CellStyle style;
	private Row row;

	
	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		this.filePath=filePath;
		fip=new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fip);
	}
	
	
	
	
	public Sheet getSheet(String sheetName) 
	{
		sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public Sheet getSheet(int sheetIndex)
	{
		sheet=workbook.getSheetAt(sheetIndex);
		return sheet;
	}
	
	public Row getRow(String sheetName, int rowNum)
	{
		Row row=getSheet(sheetName).getRow(rowNum);
		return row;
	}
	
	public Row getRow(int sheetIndex, int rowNum)
	{
		row=getSheet(sheetIndex).getRow(rowNum);
		return row;
	}
	
	public Cell getCell(String sheetName,int rowNum, int cellNum)
	{
    
		cell =getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		return cell;
		
	}
	
	public String getCellData(String sheetName, int rowNum,int cellNum)
	{
		String data=null;
		cell=getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			data=cell.getNumericCellValue()+"";
		}
		else if(cell.getCellType()==cell.CELL_TYPE_STRING)
		{
			data=cell.getStringCellValue();
		}
		return data;
	}
	
	
   public List<String> getTotalExcelData(String sheetName)
   {
	   String data=null;
	   sheet=getSheet(sheetName);
	   List<String> excelData=new ArrayList<String>();
	   
	   for(int i=0;i<sheet.getLastRowNum();i++)
	   {
		   row=sheet.getRow(i);
		   
		   for(int j=0;j<row.getLastCellNum();j++)
		   {
			   cell=row.getCell(j);
			   if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			   {
				   data=cell.getNumericCellValue()+"";
				   excelData.add(data);
			   }
			   else if(cell.getCellType()==cell.CELL_TYPE_STRING)
			   {
				   data=cell.getStringCellValue();
				   excelData.add(data);
			   }
			   
		   }
	   }
	   
	   return excelData;
   }
   
   
   
   public List<String> getRowData(String sheetName, int rowNum)
   {
	   row=getSheet(sheetName).getRow(rowNum);
	   List<String> excelRowData=null;
	   String data=null;
	   
	   for(int i=0;i<row.getLastCellNum();i++)
	   {
		   cell=row.getCell(i);
		   
		   if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		   {
			   data=cell.getNumericCellValue()+"";
			   excelRowData.add(data);
		   }
		   else if(cell.getCellType()==cell.CELL_TYPE_STRING)
		   {
			   data=cell.getStringCellValue();
			   excelRowData.add(data);
		   }
		   
	   }
	   return excelRowData;
   }
   
   //To Write the data in the excel sheet
  
   
   public void setCellData(String filePath,String sheetName,int rowNum,int cellNum,String data) throws IOException, EncryptedDocumentException, InvalidFormatException
   {
	   this.filePath=filePath;
	 
	   fip=new FileInputStream(filePath);
	   
	   workbook=WorkbookFactory.create(fip);
	   
	   
	   sheet=workbook.createSheet();
	   row=sheet.createRow(rowNum);
	   System.out.println("row=="+row);
	   cell=row.createCell(cellNum);
	   System.out.println("cell=="+cell+",data="+data);
	   cell.setCellValue(data);
	   
	   
	   /*sheet=workbook.getSheet(sheetName);
	   
	   row=sheet.getRow(rowNum);
	   
	   //cell=row.createCell(cellNum);
	   System.out.println("test");
	   System.out.println("test===="+row);
	   
	  cell= row.getCell(cellNum);
	   cell.setCellValue(data);*/
	   
	   //cell=workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	   //cell.setCellValue(data);
	   
	   fop=new FileOutputStream(filePath);
	   workbook.write(fop);
	   workbook.close();
	   fip.close();
	   fop.close();
	   
   }
   
   
  	
	
}
