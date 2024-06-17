package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutor_scrolling {

	public static void main(String[] args) 
	{
		//scrolling up and down
		
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
	
		JavascriptExecutor js=driver;
		
		//Scroll down the page by pixel
		//js.executeScript("window.scrollBy(0,3000)", "");  // window.scrollBy(0,3000) -> is a javascript statement for scrolling
		//System.out.println(js.executeScript("return window.pageYOffset;"));  //This will return the location of scrolling 
		
		
		//Scroll down till you find the required element
		WebElement indianflag=driver.findElement(By.xpath("//img[@alt=\"Flag of India\"]"));
		js.executeScript("arguments[0].scrollIntoView();", indianflag);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//Scroll down to end of the page
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");		//document.body.scrollHeight -> This statement representing the end of the page
 
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Scroll to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		
	}

}
