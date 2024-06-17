package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Logintest {

	public static void main(String[] args) 
	{
		//Launching the browser
		
		//WebDriverManager.chromedriver().setup(); 
		//ChromeDriver driver=new ChromeDriver();  (Here driver variable will hold only the chromedriver object)
		WebDriver driver=new ChromeDriver();     //(Here Webdriver is an interface and its variable will hold object of chrome or firefox etc)
		
		//To maximize the chrome browser
		driver.manage().window().maximize();
		
		
		//Open the URl: - https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//provide some time delay so that the application will open completely (not a recommended method for giving delay)
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		//Get the title of the page and validate the title
		String s=driver.getTitle();
		Assert.assertEquals(s, "OrangeHRM");
		System.out.println(s);  
		
		//Enter user name and password
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//Click on Login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//Validate the title
		String a=driver.getTitle();
		String e="OrangeHRM";
		
		if(a.equals(e))
		{
			System.out.println("Verified the app title as"+" "+a);
		}
		else 
		{
			System.out.println("Unable to verify the app title");
		}
		
		
		//provide some time delay so that the page will be in open state for some time
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException r) 
		{
			r.printStackTrace();
		}
		
				
		//Close the browser
		driver.close();
		//driver.quit();
		
	}

}
