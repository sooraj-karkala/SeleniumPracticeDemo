package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getmethods {

	public static void main(String[] args) 
	{
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Get commands: -
		//Usage of driver.get command
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		//getTitle()
		//getCurrentURL()
		//getPageSource()
		//GetWindowHandle()
		//GetWindowHandles()
		
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//Conditional commands: - 
		//Usage of Conditional commands like isenabled, isdisplayed and isSelected() commands
		
		//Locating the logo in the webpage
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		//I have captured the logo in "logo" webelement but not sure its captured or not. So, we need to check the status of logo element.
		System.out.println("Display the status of logo:"+logo.isDisplayed());  //logo.isdisplayed will send true or false
				
		//checking whether input field is enabled or not
		Boolean enabled=driver.findElement(By.cssSelector("input[name='username']")).isEnabled(); //.isenabled will send true or false
		System.out.println("Display the status of username field:"+enabled);
		
		//.isSelected() is user to identify the status on check box and radio buttons etc.
		
		
		//Browser Methods: - 
		//Quit() and Close()
		driver.findElement(By.cssSelector("//a[contains(text(), 'OrangeHRM, Inc')]")).click();
		driver.manage().window().maximize();
		driver.close();  //this will close the first browser window not the second, as the driver is aware of only the first browser window.
		
		//We cannot perform any kind of operation on the second window as the driver is associated with only the first browser. 
		//In order to achieve that we need to switch the driver to second browser 
		
		//Quit() is used to close all the browser windows 
	}

}
