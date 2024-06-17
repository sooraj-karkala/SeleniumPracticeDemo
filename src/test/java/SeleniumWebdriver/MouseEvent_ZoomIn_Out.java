package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseEvent_ZoomIn_Out {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing ZoomIn/ZoomOut, Maximize/Minimize  action on the button
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\r\n");
		
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));
		
		driver.manage().window().maximize(); //Maximize the screen
		System.out.println("Location of logo after maximizing the page:"+logo.getLocation());
		
		driver.manage().window().minimize(); //Minimize the screen
		System.out.println("Location of logo after minimizing the page:"+logo.getLocation());
		
		driver.manage().window().fullscreen(); //Full screen
		System.out.println("Location of logo after full screen:"+logo.getLocation());
		
		
		//We can set the window size by passing the x and y values -> This can be achieved with help of Point class Object
		Point p=new Point(100,100);
		driver.manage().window().setPosition(p);
		System.out.println("Location of logo after setting the screen:"+logo.getLocation());
		
		
	}

}
