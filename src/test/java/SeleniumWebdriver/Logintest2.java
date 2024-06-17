package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest2 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		String title1=driver.getTitle();
		System.out.println(title1);
		
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//clear the field and then enter the value
		WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		
		
		WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException r) 
		{
			r.printStackTrace();
		}
		
		String title2=driver.getTitle();
		System.out.println(title2);
		
		String header=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
		System.out.println(header);
	}
}
