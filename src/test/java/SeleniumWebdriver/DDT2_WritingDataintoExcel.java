package SeleniumWebdriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT2_WritingDataintoExcel {

	public static void main(String[] args) throws IOException 
	{
			
		//Create the ExcelFile in writting mode 
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\SeleniumTestData2.xlsx");
		
		//Create the WorkBook in the file
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//In the new workbook create the sheet
		XSSFSheet sheet=workbook.createSheet();  //sheet is created and returned
		
		//Creating rows and cells without loop
		//Create first row 
		/*
		XSSFRow row1=sheet.createRow(0); 
		row1.createCell(0).setCellValue("Welcome");
		//same row second cell
		row1.createCell(1).setCellValue("Sooraj");
		//same row second cell
		row1.createCell(2).setCellValue("Nayak");
		
		//Second row and first cell
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("Hello");
		row2.createCell(1).setCellValue("Sushma");
		row2.createCell(2).setCellValue("Nayak");
		
		//Third row and first cell
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("Hi");
		row3.createCell(1).setCellValue("Archana");
		row3.createCell(2).setCellValue("Nayak");
		*/
		
		
		//Creating rows and cells with loop
		//Use the scanner class to get the run time data from user
		
		Scanner sc=new Scanner(System.in);
		
		for(int r=0; r<=3; r++)
		{
			XSSFRow currentrow=sheet.createRow(r);
			for(int c=0; c<3; c++)
			{
				System.out.println("Enter the value");
				String value=sc.next();  //Take the run time data from the user
				currentrow.createCell(c).setCellValue(value);
			}
		}
		//Attach the workbook to the file
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Writting is done");
	}

}
