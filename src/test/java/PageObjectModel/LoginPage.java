package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	//Page object class contains mainly Constructor, Locators, Action Methods

	public WebDriver driver;
	
	//Constructor
	
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
			
	
	//Locators
	
	By imp_logo = By.xpath("(//img[@alt='orangehrm-logo'])[2]");
	By txt_username=By.xpath("//input[@name='username']");
	By txt_password=By.xpath("//input[@name='password']");
	By btn_submit=By.xpath("//button[@type='submit']");
	
	//Action Methods
	
	public boolean checklogo()
	{
		boolean status=driver.findElement(imp_logo).isDisplayed();
		return status;
	}
	
	public void setusername(String username) 
	{
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clicksubmit()
	{
		driver.findElement(btn_submit).click();
	}

}
