package TestNG1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;  //This will import all the annotations


/*Perform below action: - 
 * Login
 * Search
 * Advance search
 * logout
 */
public class AnnotationDemo2 
{
  WebDriver driver;
  
  @BeforeClass
  public void login() 
  {
	  System.out.println("Login");
  }
  
  @Test(priority=1)
  public void Search() 
  {
	  System.out.println("Search");
  }
  
  @Test(priority=2)
  public void Advancesearch() 
  {
	  System.out.println("Advancesearch");
  }

  @AfterClass
  public void logout() 
  {
	  System.out.println("logout");
  }
  
  @BeforeTest
  void beforetest()
  {
	System.out.println("Before Test");
  }
	
  @AfterTest
  void Aftertest()
  {
	System.out.println("After Test");
  }
	
  @BeforeSuite
  void Beforesuite()
  {
	System.out.println("Before Suite");
  }
  @AfterSuite
  void Aftersuite()
  {
	System.out.println("After Suite");
  }

}


/*OUTPUT: -
Login
Search
Advancesearch
logout
*/
