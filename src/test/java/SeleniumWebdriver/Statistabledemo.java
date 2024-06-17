package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Statistabledemo {

	public static void main(String[] args) 
	{
		
        WebDriver driver = new ChromeDriver();
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Find total number of rows
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows"+rows);
		
		//find total number of columns
		int column= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of columns"+column);
		
		//read specific row and column data
		String value1=driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
		System.out.println("value is"+" "+value1);
		
		String value2=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
		System.out.println("value is"+" "+value2);
		
		//read data from all the rows and columns
		
		for(int i=2; i<=rows; i++)   //Actual data are starts from second row
		{
			for(int j=1; j<=column; j++)
			{
				String value3=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();  //passing parameter in the xpath "+ +"
				System.out.print(value3+"   ");
			}
			System.out.println();
		}
		
				
		//print book names whose author is Amit
		
		for(int r=2; r<=rows; r++)
		{
			String Author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(Author.equals("Amit"))
			{
				String bookname= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookname);
			}
			
		}
		
		
		//find sum of price for all the books
		int price=0;
		
		for(int s=2; s<=rows; s++)
		{
			String sum=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+s+"]//td[4]")).getText();
			//"Sum" value is in string format hence we cannot perform arithmetic operation on strings. So, convert string to int
			
			price=price+Integer.parseInt(sum); 
		}
		
		System.out.println("Sum is:"+" "+price);
		

	}

}
