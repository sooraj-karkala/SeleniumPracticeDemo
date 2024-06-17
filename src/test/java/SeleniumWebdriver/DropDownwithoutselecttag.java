package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownwithoutselecttag {

	public static void main(String[] args) 
	{
		//Dropdown not having select tag in DOM structure instead it has(input/div)tags ->Bootstrap dropdown 
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@type=\"button\"] [@class='multiselect dropdown-toggle btn btn-default']")).click();
		
		//Dropdown having multiple check boxes to select 
		
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class, checkbox)]//label"));
		
		//Find total number of options
		System.out.println("Total number of options:"+options.size());
		
		//Print all the options
		for(int i=0; i<options.size(); i++)
		{
			System.out.println("Options are:"+options.get(i).getText());
		}
		
		//select options from dropdown
		
		for(int i=0; i<options.size(); i++)
		{
			String text = options.get(i).getText();
			if(text.equals("Java")||text.equals("Python"))
			{
				options.get(i).click();
			}
		}
		
		

	}

}
