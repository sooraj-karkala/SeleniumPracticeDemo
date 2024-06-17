package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestdropdown {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("textarea[id=APjFqb]")).sendKeys("selenium ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Values in the drop down options are dynamic.
		
		List<WebElement> autodropdown=driver.findElements(By.xpath("//li[@class='sbct']//div[contains(@class, 'wM6W7d')]//span[contains(text(), 'selenium')]"));
		
		System.out.println("list of options in the dropdown are:"+autodropdown.size());
		
		for(int i=0; i<autodropdown.size(); i++)
		{
			String Result=autodropdown.get(i).getText();
			if(Result.equals("selenium grid"))
			{
				autodropdown.get(i).click();
				break;
				
			}
		}
		

	}

}
