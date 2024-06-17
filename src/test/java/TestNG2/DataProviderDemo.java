package TestNG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo 
{
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="dp", indices= {0,1,4})                   // indices= {0,1,4} -> This will send the data from only 0th, 1st and 4th index 
	String [][] loginData()                                      //Return type of the method should be string[][] since its returning 2D string value.   
	{
		String data[][]= {                                       //Defining 2 dimensional array, and adding data to it       
							{ "abc@gmail.com", "test123" }, 
							{ "pavanol@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test3" },
							{ "pavanoltraining@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test@123" } 
						};
		
		return data;
	}
	
	
	
}