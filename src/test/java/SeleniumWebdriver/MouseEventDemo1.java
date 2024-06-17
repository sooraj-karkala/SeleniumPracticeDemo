package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventDemo1 {

	public static void main(String[] args) 
	{
		//Mouse Hover  -> moveToElement(element)
		//Right click  -> contextClick(element)
		//Double click -> doubleClick(element)
		//Drag and drop ->draganddrop(source, destination)
		//Slider -> dragAndDropby(WebElementsource, Xoffset, Yoffset)
		
		
		//Action -> class is provided by selenium to perform above actions
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		
		WebElement desktop=driver.findElement(By.xpath("//a[@class=\"nav-link dropdown-toggle\"][contains(text(), \"Desktops\")]"));
		
		WebElement mac =driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a"));
		
		Actions act=new Actions(driver);  //declaring the object of Actions class
		                            //Actions class has a constructor and that is expecting a driver instance. Hence we need to pass a driver as a parameter 
		
		act.moveToElement(desktop).moveToElement(mac).click().build().perform(); // build is a method which will create an action 
		                                                                         //perform is a method which will complete/perform an action
		
		
		
		
	}

}
