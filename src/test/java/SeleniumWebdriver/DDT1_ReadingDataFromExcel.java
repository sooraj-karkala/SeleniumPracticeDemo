package SeleniumWebdriver;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT1_ReadingDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		
		/* Data Driven Testing -> Executing the same test case multiple time with different type of data.
		There is no specific class/method to integrate excel sheet and webdriver so we seek Apache Poi for automating the excel sheet.
		
		Create a new folder in the project (TestData) to store the excel sheet.
		
		Structure of excel sheet: - 
		ExcelFile -> WorkBook -> Sheets -> Rows -> Cells
		 
		ExcelFile = There are 2 classes that comes from java itself
		FileInputStream -> Used to read the data from the file
		FileOutputStream -> Used to write the data into the file
		
		WorkBook=There is a class comes from Apache poi  
		XSSFWorkBook -> This class is available for dealing the workbooks
		
		Sheets=There is a class comes from Apache poi  
		XSSFSheet -> This class is available for dealing the sheets
		
		Row=There is a class comes from Apache poi  
		XSSFRow -> This class is available for dealing the rows's
		
		Cell=There is a class comes from Apache poi  
		XSSFCell -> This class is available for dealing the Cell
		
		*/
		
		//Open the ExcelFile in reading mode -> FileInputStream file=new FileInputStream("Loactaion of the Excelsheet from eclips")
		//OR
		// FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\SeleniumTestData1.xlsx");
		//System.getProperty("user.dir") -> This will identify the project loactaion
		FileInputStream file=new FileInputStream("C:\\Users\\soora\\eclipse-workspace\\Webdrivermavenproject\\TestData\\SeleniumTestData1.xlsx");
		
		//Capture the WorkBook from the file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//In the workbook there will be multiple sheet so, capture the sheet from the workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1");  //Sheet1=Name of the sheet in the excel
		
		//Find the total number of rows
		int totalrows=sheet.getLastRowNum();
		
		//Find the total number of cells
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println(totalrows); //Output: - 4 ; Row count will start from 0 (including header)
		System.out.println(totalcells);//Output: - 4 ; Column count will start from 1
		
		//Printing the data 
		for(int r=0; r<=totalrows; r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0; c<totalcells; c++)
			{
				String value=currentrow.getCell(c).toString();
				//Or
				//XSSFCell cell=currentrow.getCell(c);
				//String value=cell.toString();
				System.out.println(value);
				
			}
			System.out.println();
			
		}
		workbook.close();
		file.close();

	}

}
