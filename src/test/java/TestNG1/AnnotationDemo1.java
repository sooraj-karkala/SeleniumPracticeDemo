package TestNG1;

import org.testng.annotations.*;  //This will import all the annotations


/*Perform below action: - 
 * Login
 * Search
 * logout
 * login
 * Advance search
 * logout
 */
public class AnnotationDemo1 
{
   
  @BeforeMethod
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

  @AfterMethod
  public void logout() 
  {
	  System.out.println("logout");
  }
  
}

/*OUTPUT: -
Login
Search
Logout
Login
Advancesearch
logout
*/
