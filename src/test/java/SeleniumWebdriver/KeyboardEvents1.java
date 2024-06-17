package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents1 {

	public static void main(String[] args) 
	{
		//Keyboard events can be handled with the help of "Actions" class and "Keys" class
		
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Performing selecting, coping, switching the Tab and pasting using keyboard buttons. 
		
		driver.get("https://text-compare.com/");
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("//textarea[1][@name=\"text1\"]")).sendKeys("SoorajNayak");
		
		//All keys in the keyboard can be accessed with the help of "Keys" class
		//Whenever you enter characters/letters from the keyboard then use "Sendkeys()" 
		
		//selecting (Ctrl+A)
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();  //This will press ctrl button and enter character "a" then release the ctrl button
		
		//Coping (Ctrl+C)
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//switching the Tab
		act.sendKeys(Keys.TAB);  //prefer this method if you press only single key
		//act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		
		//Pasting (Ctrl+v)
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		

	}

}
