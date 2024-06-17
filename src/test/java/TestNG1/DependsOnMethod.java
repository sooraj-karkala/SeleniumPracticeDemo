package TestNG1;


import org.testng.Assert;
import org.testng.annotations.*;

public class DependsOnMethod 
{
	@Test(priority=0)
	void openapp()
	{
		System.out.println("openapp");
	}
 
	
  @Test(priority=1, dependsOnMethods= {"openapp"})
  public void login() 
  {
	  System.out.println("Login");
  }
  
  
  @Test(priority=2, dependsOnMethods= {"login"})  //This method will be executed only if the login method is passed
  public void Search() 
  {
	  //System.out.println("Search");
	  Assert.assertTrue(false);     //Intentionally failing the method
  }  
  
  
  @Test(priority=3, dependsOnMethods= {"login","Search"}) //This method will be executed only if the Login and Search methods are passed
  public void Advancesearch() 
  {
	  System.out.println("Advancesearch");
  }

  
  @Test(priority=4, dependsOnMethods= {"login"})
  public void logout() 
  {
	  System.out.println("logout");
  }
}
