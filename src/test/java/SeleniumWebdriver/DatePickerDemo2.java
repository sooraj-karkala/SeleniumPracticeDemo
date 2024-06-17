package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	public static void main(String[] args) 
	{
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
		 driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		 driver.findElement(By.xpath("//input[@id=\"dob\"]")).click(); //it will open the date picker
		 
		 String year="1999";
		 String month="Dec";
		 String date="5";
		
		 //This method is used when the HTML DOM structure is having "Select" tag
		 
		 WebElement dropdown1=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		 
		 Select monthvalue=new Select(dropdown1);
		 
		 monthvalue.selectByVisibleText("Dec");
		 
		 WebElement dropdown2=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		 
		 Select yearvalue=new Select(dropdown2);
		 
		 yearvalue.selectByVisibleText("1999");
		
		 /*
		  * This method used when the tag is other than "Select"
		  * 
		 List<WebElement> dropdown1=driver.findElements(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		 for(int i=0; i<dropdown1.size(); i++)
		 {
			 if(dropdown1.get(i).getText().equals(month))
			 {
				 dropdown1.get(i).click();
				 break;
			 }
		 }
		 
		 List<WebElement> dropdown2=driver.findElements(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		 for(int i=0; i<dropdown2.size(); i++)
		 {
			 if(dropdown2.get(i).getText().equals(year))
			 {
				 dropdown2.get(i).click();
				 break;
			 }
		 }
		 */
		 		 
		 List<WebElement> listdates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td"));
		 
		 for(WebElement dt:listdates)
		 {
			 if(dt.getText().equals(date))
			 {
				 dt.click();
				 break;
			 }
		 }
		 
		
		 
		 
		
	}

}
