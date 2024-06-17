package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitdemo {

	public static void main(String[] args) 
	{
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		//Wait Commands: - 
		
		//Sleep command -> Is already used in the previous example.
		/* Advantage: - Easy to use
		 Disadvantage: - 
		 1)If the element is not found then it can wait till maximum time sec after that it throws exception.
		 2)If the element is located within the specified time then then it will not jump to next statement, instead it waits till the time gets completed hence, reduces the performance script.
		 */
		
		//Implicit wait:-
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/* Advantages: - 
		1)This should be apply only once in the script after launching the chrome browser or after instantiating the driver.
		2)It is applicable for every element in your automation script.
		3)If the element is located within 2 sec immediately it will jump to next statement*/
		
		/*Disadvantage: - If the element is not found then it can wait till maximum time sec (that is 10 sec here)after that it throws exception.
		 */
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();	

	}

}
