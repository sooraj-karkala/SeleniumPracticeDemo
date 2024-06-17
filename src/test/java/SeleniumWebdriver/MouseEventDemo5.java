package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventDemo5 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing sliding action -> dragAndDropby(WebElementsource, Xoffset, Yoffset)
		
		driver.get("https:www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		Actions act=new Actions(driver); 
		
		//LeftSlider
		WebElement leftslider=driver.findElement(By.xpath("//span[1][@class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));  //Starting position of left slider
		System.out.println("Location of the left slider before moving"+leftslider.getLocation());  //This will print the current location of the left slider
		act.dragAndDropBy(leftslider, 100, 249).perform();  //This will move the left slider along X-axis by 100 while the Y-axis remains unchanged
		System.out.println("Location of the left slider after moving"+leftslider.getLocation());
		
		
		//RightSlider		
		WebElement rightslider =driver.findElement(By.xpath("//span[2][@class=\"ui-slider-handle ui-corner-all ui-state-default\"]")); //starting position of right slider
		System.out.println("Location of the right slider before moving"+rightslider.getLocation());
		act.dragAndDropBy(rightslider, -50, 249).perform();   //This will move the right slider along (-X)-axis by 50 while the Y-axis remains unchanged
		System.out.println("Location of the right slider after moving"+rightslider.getLocation());
		
		
		
		
	}

}
