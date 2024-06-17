package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverutil 
{
	public static WebDriver getBrowserInstance(String browsername)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			return new ChromeDriver();
			
		}
		else
		{
			return null;
		}
		
	}

}
