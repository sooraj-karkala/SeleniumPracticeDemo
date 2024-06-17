package SeleniumWebdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest3 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		//Identifying multiple slides in a web page
		List<WebElement> slides = driver.findElements(By.className("nivo-imageLink"));
		System.out.println("Number of slides are"+" "+slides.size());
		
		//Identify the total number of images in a web page
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of images are"+" "+images.size());
		
		//Identify the total number of links in a web page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are"+" "+links.size());
		
	}
}
