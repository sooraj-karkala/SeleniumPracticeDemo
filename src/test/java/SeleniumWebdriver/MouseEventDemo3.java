package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventDemo3 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing double click action on the button
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.switchTo().frame("iframeResult");  //Switch to the frame
			
		
		WebElement field1=driver.findElement(By.xpath("//input[@id=\"field1\"]"));
		field1.clear();
		field1.sendKeys("Sooraj Nayak");
		
		WebElement button = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));
				
		Actions act=new Actions(driver);  
		
		act.doubleClick(button).perform();	//This syntax is used to perform double click 
		                                    //You can use either build().perform() or only Perform() -> This will call the build method internally
		
		
		String result=driver.findElement(By.xpath("//input[@id=\"field2\"]")).getAttribute("value");
		System.out.println(result);
		
		//findelement(loc).getText() -> It will return the inner text of the element (when inner text is present in the DOM structure)
		//findelement(loc).getAttribute("value")  -> it will return the value present in the value attribute 
		//findelement(loc).getAttribute("id")  -> it will return the value present in the id attribute 
		
	}

}
