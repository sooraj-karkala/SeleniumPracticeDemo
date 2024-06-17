package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framesdemo {

	public static void main(String[] args) 
	{
		/*Frame: - A page is divided into multiple parts and those parts are called as frames. Frames contain different type of elements.
		iframe: - frame within another frame.
		
		1) driver.switchTo().frame(name/id) -> if the name/id attributes available for the frame
		
		2) if the name/id attributes are not available for the frame then, identify the frame through xpath and store it in an webelement.
		   driver.switchTo().frame(WebElement)		
		
		3) driver.switchTo().frame(index) -> if the page has only one frame (index =0)
		
		*/
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1= driver.findElement(By.xpath("/html/frameset/frame[1]"));
		driver.switchTo().frame(frame1);                                                //driver control switched to frame 1
		driver.findElement(By.xpath("//*[@id=\"id1\"]/div/input")).sendKeys("Sooraj");
		
		
		//Since its not possible to switch the driver from frame to frame, we need to switch back to main page
		
		driver.switchTo().defaultContent();   //This will switch the driver control to main page
		
		WebElement frame2= driver.findElement(By.xpath("/html/frameset/frameset/frame[1]"));
		driver.switchTo().frame(frame2);                                               //driver control switched to frame 2
		driver.findElement(By.xpath("//*[@id=\"id2\"]/div/input")).sendKeys("Nayak");
		
		driver.switchTo().defaultContent();   //This will switch the driver control to main page
		
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);                                              //driver control switched to frame 3
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello");
		
		//Switch to inner frame from frame 3
		
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div[class='AB7Lab Id5V1']")).click();
		driver.findElement(By.cssSelector("div[jscontroller='EcW08c']")).click();
		
		List<WebElement> dropdown=driver.findElements(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R' ]"));
		for(int i=0; i<dropdown.size(); i++)
		{
			String value=dropdown.get(i).getText();
			if(value.equals("Yes"))
			{
				dropdown.get(i).click();
			}
			
		}
		
		driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[3]/div[1]/div[1]/div/span/span")).click();
		
		}

}
