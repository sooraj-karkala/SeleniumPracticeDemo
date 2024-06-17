package SeleniumWebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigationalcommandsdemo {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigational commands: - 
		/*1) navigate().to(URL) -> same as driver.get(URL)
		     navigate().to(URL)-> Accept the URL in in URL and string format
		     driver.get("URL")-> Accept the URL in only string format
		  2) navigate().forward() 
		  3) navigate().back() 
		  4) navigate().refresh() ->
		 */
          
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://www.flipkart.com/");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
	}

}
