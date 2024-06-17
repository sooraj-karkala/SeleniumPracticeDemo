package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutor {

	public static void main(String[] args) 
	{
		//if you are initiating the sendkeys("xyz") method by passing some data (xyz), but if the sendkeys() method fails to execute the corresponding java script code, then it will throw some exception (Element Intercepted Exception) . 
		//In this case you can use "executeScript()" method to directly execute the javascript code written in sendkeys() method. 
		//JavaScriptExecutor -> It is an Interface which contains method called "executeScript()" that is used to execute java script statements in selenium 
		
		WebDriver driver=new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		 
	    driver.manage().window().maximize();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://testautomationpractice.blogspot.com/");
		 
		//We cannot apply one type of object to another type. If we want to do so then we need to perform type conversion.
		//Here, "driver" is a variable of "webdriver" interface and "js" is a variable of "javascriptexecutor" interface. 
		//So, we need to perform type conversion on "driver" in order to assign it to "js"
		//Note: - both driver and js should have same attributes and methods in order to perform type conversion
		 
		JavascriptExecutor js=(JavascriptExecutor)driver;   //perform the type conversion as "webdriver" instance and "javascriptexecutor" instance are no were interrelated (check the structural diagram in book) 
		 
		//JavascriptExecutor js=driver;   //No need to perform type conversion as chromedriver class is also a child class of JavascriptExecutor (check the structural diagram in book) 
		 
		//Enter the name 
		//driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Sooraj");
		 
		WebElement name= driver.findElement(By.xpath("//input[@id=\"name\"]"));
		
		js.executeScript("arguments[0].setAttribute('value', 'Sooraj')", name);    //Same javascript statement can be used to enter the data in web element 
		 
		//Here the webelement/argument "name" is stored in argument[0]
		//"arguments[0].setAttribute('value', 'Sooraj')" -> It is a javascript statements
		
		
		//Click on radio button
		WebElement radiobutton=driver.findElement(By.xpath("//input[@id=\"male\"] "));
		
		js.executeScript("arguemnts[0].click();", radiobutton);   //All clicking actions will use same javascript statement
		
        
	}

}
