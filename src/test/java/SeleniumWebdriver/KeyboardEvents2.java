package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents2 {

	public static void main(String[] args) 
	{
		//Keyboard events for tabs and windows
		
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Launching one application, opening a new tab then launching second application
		Actions act=new Actions(driver);
		
		driver.get("https://demo.opencart.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);  //This will open a new tab
		
		//driver.switchTo().newWindow(WindowType.WINDOW); //This will open new window
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		
		
		
		

	}

}
