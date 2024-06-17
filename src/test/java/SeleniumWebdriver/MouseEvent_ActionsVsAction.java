package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseEvent_ActionsVsAction {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing right click action on the button
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		
		Actions act=new Actions(driver);  
		
		Action myaction=act.contextClick(button).build(); 		//This will create the action and store it in a variable of Action interface without performing.
		
		//You can complete the action anywhere in the script at any time
		
		myaction.perform();
		
		
		//Actions class methods we use to create mouse/keyboard events
		//Action interface we use to hold the actions
		
		/*
		driver.findElement(By.xpath("//li[@class=\"context-menu-item context-menu-icon context-menu-icon-copy\"]")).click();
		
		driver.switchTo().alert().accept();  //close the alert window
		*/
	}

}
