package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Invalidlogintest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		//Enter the invalid credential
		driver.findElement(By.name("username")).sendKeys("hello");
		driver.findElement(By.name("password")).sendKeys("12333");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//provide some wait as it is taking time to fetch the data
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException r) 
		{
			r.printStackTrace();
		}
		
	    //Capture the error message
		String actual=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
		String expected="Invalid credentials";
		
		if(actual.equals(expected))
		{
			//Provide valid credential
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
		}
		else
		{
			System.out.println("failed"); 
		}
	}

	

}
