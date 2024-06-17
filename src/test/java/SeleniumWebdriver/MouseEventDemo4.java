package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventDemo4 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing drag and drop action on the button
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Actions act=new Actions(driver);  
				
		WebElement oslo=driver.findElement(By.xpath("//div[@ id=\"box1\"]"));
		
		WebElement norway = driver.findElement(By.xpath("//div[@id=\"box101\"]"));
				
	
		
		act.dragAndDrop(oslo, norway).perform();	//This syntax is used to perform drag and drop action 
		                                                //You can use either build().perform() or only Perform() -> This will call the build method internally
		
		
		
		
	}

}
