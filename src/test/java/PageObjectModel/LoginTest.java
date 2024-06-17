package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	WebDriver driver;
	LoginPage lp;       //created the object 
	
	
    @BeforeClass
	public void launch()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    
    @Test(priority=1)
    public void testlogo()
    {
    	lp=new LoginPage(driver);   //Pass driver as parameter since loginpage class has a constructor which is expecting a driver parameter.
    	
    	/*Declaring the object 
        *Constructor is invoked when the object of the class is created
        *driver is passed as an argument since the constructor has a driver argument
        **/
    	boolean status2=lp.checklogo();
    	Assert.assertEquals(status2,true);
    }
    
    @Test(priority=2)
    public void login()
    {
    	lp.setusername("Admin");
    	lp.setpassword("admin123");
    	lp.clicksubmit();
    	
    	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    	
    }
    
    @AfterClass
    public void logout()
    {
    	driver.quit();
    }
			
}
