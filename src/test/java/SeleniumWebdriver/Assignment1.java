package SeleniumWebdriver;


import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) 
	{

		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
		 driver.get("https://blazedemo.com/");
		 
		 WebElement dropdown1=driver.findElement(By.xpath("//select[@name=\"fromPort\"]"));
		 
		 Select d1=new Select(dropdown1);
		 
		 d1.selectByVisibleText("San Diego");
		 
		 WebElement dropdown2=driver.findElement(By.xpath("//select[@name=\"toPort\"]"));
		 
		 Select d2=new Select(dropdown2);
		 
		 d2.selectByVisibleText("New York");
		 
		 driver.findElement(By.xpath("//input[@type=\"submit\"] ")).click();
		 
		 //driver.navigate().refresh();
		 
		 //Capture number of rows and columns
		 
		 int rows=driver.findElements(By.xpath("//table[@class=\"table\"]//tbody//tr")).size();
		 int columns=driver.findElements(By.xpath("//table[@class=\"table\"]//thead//tr//th")).size();
		 
		
		 Object a[]=new Object[10];
		 
		 for(int r=1; r<=rows;r++)
		 {
			 String s=driver.findElement(By.xpath("//table[@class=\"table\"]//tbody//tr["+r+"]//td[6]")).getText();
			
			 s.replace("$"," ");
			 
			 for(int m=0; m<=rows; m++)
			 {
				 a[m]=Double.parseDouble(s);
			 }
		 }
	
		 Arrays.sort(a);
		 System.out.println(a[0]);
		 
		
		 
		 
		 /*
		 
		 driver.get("http://example.com/your-application-url");

	        // Assuming the prices are in a table with rows and columns
	        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@id='priceTable']/tbody/tr/td[2]"));

	        double lowestPrice = Double.MAX_VALUE;
	        WebElement lowestPriceElement = null;

	        // Loop through the price elements to find the lowest price
	        for (WebElement priceElement : priceElements) {
	            double currentPrice = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
	            if (currentPrice < lowestPrice) {
	                lowestPrice = currentPrice;
	                lowestPriceElement = priceElement;
	            }
	        }

	        // Assuming the buttons are in the same row as the prices
	        WebElement row = lowestPriceElement.findElement(By.xpath("./.."));
	        WebElement button = row.findElement(By.xpath("//button"));

	        // Click on the corresponding button
	        button.click();

	        // Close the WebDriver
	        driver.quit();
	    */	

	}

}
