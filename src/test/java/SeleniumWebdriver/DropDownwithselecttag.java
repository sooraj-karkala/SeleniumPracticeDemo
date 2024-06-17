package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownwithselecttag {

	public static void main(String[] args) 
	{
		/*DropDown types: - 
		 Dropdown having select tag in DOM
		 Dropdown not having select tag in DOM instead it has(input/div)tags ->Bootstrap dropdown 
		 Auto suggested drop down (Dynamic)
		*/
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Sooraj");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nayak");
		
		//Dropdown having select tag in DOM -> This can be handled with the help of "Select" class 
		//Select class can be used only if Select tag is available in the DOM structure
		
		WebElement Day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		Select dayvalue=new Select(Day);  //Creating object of class select
		
		//Selecting option from dropdown -> 1st method
		dayvalue.selectByVisibleText("5");
		
		
		WebElement Month=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		Select monthvalue=new Select(Month);
		
		monthvalue.selectByVisibleText("December");
		
		WebElement Year=driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		Select yearvalue=new Select(Year);
		
		//Selecting option from dropdown -> 2nd method
		yearvalue.selectByValue("1999");
		
		//Selecting option from dropdown -> 3rd method -> Selectbyindex()
		
		//Finding total number of option in dropdown
		List<WebElement> days=dayvalue.getOptions();
		List<WebElement> months=monthvalue.getOptions();
		List<WebElement> years=yearvalue.getOptions();
		
		System.out.println("total number of day:"+days.size());
		System.out.println("total number of months:"+months.size());
		System.out.println("total number of years:"+years.size());
		
		//print the options
		for(int i=0; i<days.size(); i++)
		{
			System.out.println("days are:"+days.get(i).getText()); //if you write only days.get(i) it will print the web element but not the text
		}
		

	}

}
