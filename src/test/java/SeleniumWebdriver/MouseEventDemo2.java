package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventDemo2 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing right click action on the button
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		
		Actions act=new Actions(driver);  
		
		act.contextClick(button).perform(); //This syntax is used to perform right click 
		                                    //You can use either build().perform() or only Perform() -> This will call the build method internally
		
		
		driver.findElement(By.xpath("//li[@class=\"context-menu-item context-menu-icon context-menu-icon-copy\"]")).click();
		
		driver.switchTo().alert().accept();  //close the alert window
	}

}
