package SeleniumWebdriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowserWindows {

	public static void main(String[] args) 
	{
		/* getWindowHandle()-> Return the id of single window (In which driver is focused)
		 * getWindowHandles() -> Return the id's of multiple windows
		
		 * driver.switchTo().window(windowid)
		 */
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //driver is focused on this browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title0=driver.getTitle();
		
		driver.findElement(By.xpath("//a[@ href='http://www.orangehrm.com']")).click();  //Opens another browser
		String Title2=driver.getTitle();
		
		//Now the driver is still pointing to first browser
		
		//Capture the id's of browser windows
		Set<String> windowids=driver.getWindowHandles();  // This will capture both the window id's
		
		//Set doesn't support index concept so not able to retrieve the values hence, convert set to list
		//List windowidlist=new ArrayList(windowids);  //converted from set to list
		
		//Switching to child window
		for(String childid:windowids)  //Nested for loop is used since "set" doesn't support indexing concept
		{
			String title1=driver.switchTo().window(childid).getTitle();
			if(title1.equals(Title2))  //Title2 is the title of second window, if the title matched then it perform the action in second window
			{
				driver.findElement(By.xpath("//*[@id=\"Form_submitForm_EmailHomePage\"]")).sendKeys("soorajkarkala@gmail.com");
				
			}
		}
		
		//Switching to parent window
		for(String parid:windowids)
		{
			String title3=driver.switchTo().window(parid).getTitle();
			if(title3.equals(title0))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("sooraj");

	}

}
