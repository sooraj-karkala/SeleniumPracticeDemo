package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitdemo {

	public static void main(String[] args) 
	{
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		/*Wait Commands:- Explicit wait
		This should be declared after instantiating the driver with the help WebdriverWait class.*/
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		/* Advantages: - 
		1)It is conditional based and work more effectively
		2)Finding element is inclusive
		3)It will wait for the condition to be true considering the time
				
		/*Disadvantage: - we need to write multiple statements for multiple elements
		*/
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Apply explicit wait for below username element
		WebElement username= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		/*if the condition becomes true in 10 sec, then "mywait" will return the element hence no need to find the elements separately.
		If the condition becomes false in 10 sec,it will throw the exception.*/
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
	    username.sendKeys("admin");
		
	    WebElement password= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
		password.sendKeys("admin123");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();	

	}

}
