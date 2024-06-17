package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	public static void main(String[] args) 
	{
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
		 driver.get("https://jqueryui.com/datepicker/");
		 driver.switchTo().frame(0);
		  
		 //Selecting future dates:-
		 //Approach 1
		 //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("12/05/1013");  
		 
		 //Approach 2
		 driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //it will open the date picker
		 
		 String year="2025";
		 String month="December";
		 String date="5";
		 
		 while(true)
		 {
			 String mon= driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			 String yer=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
			 
			 if(mon.equals(month) && yer.equals(year))
			 {
				 break;
			 }
			 driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();   //Xpath for clicking the forward arrow
			 
		 }
		 
		 List<WebElement> listdates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td"));
		 
		 for(WebElement dt:listdates)
		 {
			 if(dt.getText().equals(date))
			 {
				 dt.click();
				 break;
			 }
		 }
		 		 
		 /*
		 for(int i=0; i<listdates.size(); i++)
		 {
			 
			 if(date.equals(listdates.get(i).getText()))
			 {
				 listdates.get(i).click();
				 break;
			 }
		 }
		 */
		 
		 /*
		 //Selecting past dates: - 
		 //Just change the xpath of arrow mark
		 driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //it will open the date picker
		 
         String year="2021";
		 String month="December";
		 String date="5";
		 
		 while(true)
		 {
			 String mon= driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			 String yer=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
			 
			 if(mon.equals(month) && yer.equals(year))
			 {
				 break;
			 }
			 driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();  //Xpath for clicking the backward arrow
			 
		 }
		 
		 List<WebElement> listdates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td"));
		 
		 for(WebElement dt:listdates)
		 {
			 if(dt.getText().equals(date))
			 {
				 dt.click();
				 break;
			 }
		 }
		*/
		 
		 
		 
		
	}

}
