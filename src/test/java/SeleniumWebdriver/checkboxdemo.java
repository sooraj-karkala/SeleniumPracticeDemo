package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxdemo {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		WebElement username=driver.findElement(By.xpath("//input[@type='email']"));
		username.clear();
		username.sendKeys("admin@yourstore.com");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.clear();
		password.sendKeys("admin");
		
					
		//Select one check box
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		

		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[3]/a/p")).click();
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[3]/ul/li[1]/a/p")).click();
		
		//More than one check boxes
		//Capture all the check boxes in a web element
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@name='checkbox_orders']"));
		System.out.println("Total number of check boxes available are:"+checkbox.size());
		
		/*Selecting all check boxes
		for(int i=0; i<checkbox.size(); i++)
		{
			checkbox.get(i).click();
			
		}
		*/
		
		/*enhanced for loop for selecting all check boxes
		 for(WebElement Check:checkbox)
		 {
		    Check.click();
		 }
		
		
		/*Selecting last 2 check boxes
		Formula= total number of check boxes - total number of check boxes to be selected from bottom
		5-2=3(starting index)
		for(int i=3; i<checkbox.size(); i++)
		{
			checkbox.get(i).click();
			
		}
		*/
		
		/*Selecting first 2 check boxes
		
		for(int i=0; i<2; i++)
		{
			checkbox.get(i).click();
			
		}
		*/
		
		/*Un-check the check boxes
		 for(int i=0; i<checkbox.size(); i++)
			{
				checkbox.get(i).click();
				
			}
        */
		 
		 //Selecting first 2 check boxes and un-selecting the selected check boxes
		for(int i=0; i<2; i++)
		{
			checkbox.get(i).click();
			
		}
		
		for(int j=0; j<checkbox.size(); j++)
		{
			if(checkbox.get(j).isSelected())
            {
            	checkbox.get(j).click();    
            }

		}
	}
}
