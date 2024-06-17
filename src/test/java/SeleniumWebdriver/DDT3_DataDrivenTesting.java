package SeleniumWebdriver;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDT3_DataDrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		/* Data Driven testing test case will have 2 type of scripts, one for interacting with the excel sheet and other for interacting with the application. 
		 * DDT test case = Code to interact with excel sheet + Code to interact with Application.
		 * 
		 * Utility file: -It's a .java file which has reusable methods for reading data, writing the data and counting number of columns, cells etc
		 * So that we can use these methods in any DDT test case instead of writing it again 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String file=System.getProperty("user.dir")+"\\TestData\\caldata.xlsx";
		
		int rows=DDT4_UtilityClass.getRowCount(file, "Sheet1");//Calling the method from (DDT4_UtilityClass) utility class.
		//The methods defined in an instance are only able to be accessed by that object of a class.
		//If the method is a static method then, you can call that method using class name without the need of object of that class. 
		
		
		for(int i=1;i<=rows;i++)          //i=0 is not required as the first row is header in the excel sheet1
		{
			//read data from excel
			String princ=DDT4_UtilityClass.getCellData(file,"Sheet1",i,0);
			String rateofinterest=DDT4_UtilityClass.getCellData(file,"Sheet1",i,1);
			String per1=DDT4_UtilityClass.getCellData(file,"Sheet1",i,2);
			String per2=DDT4_UtilityClass.getCellData(file,"Sheet1",i,3);
			String fre=DDT4_UtilityClass.getCellData(file,"Sheet1",i,4);
			String exp_mvalue=DDT4_UtilityClass.getCellData(file,"Sheet1",i,5);
			
				
			//pass data to the app
			driver.findElement(By.id("principal")).sendKeys(princ);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			fredrp.selectByVisibleText(fre);
			
			// driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]")).click();  -> when you use this one line code, you will get ElementClickInterceptedException
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			js.executeScript("arguments[0].click();",calculate_btn);  // clicking on calculate button
						
			//validation & update results in excel
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))    //Converting the string to double and then comparing the values 
			{
				System.out.println("Test Passsed");
				DDT4_UtilityClass.setCellData(file, "Sheet1",i,7,"Passed");    // This method will update the result as passed in the excel sheet
				DDT4_UtilityClass.fillGreenColor(file, "Sheet1",i,7);       //This method will fill green color in the excel sheet 
			}
			else
			{
				System.out.println("Test Failed");
				DDT4_UtilityClass.setCellData(file, "Sheet1",i,7,"Failed"); // This method will update the result as failed in the excel sheet
				DDT4_UtilityClass.fillRedColor(file, "Sheet1",i,7);    //This method will fill red color in the excel sheet 
			}
			Thread.sleep(3000);
			
			//driver.findElement(By.xpath("//a[@onclick='javascript:reset_fdcalcfrm();']")).click();  -> when you use this one line code, you will get ElementClickInterceptedException	
			WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();",clear_btn);  // clicking on clear button
		
		
		}

	}

}
