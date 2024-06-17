package TestNG1;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.*;

public class Assertion 
{
  @Test
  public void Compare() 
  {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the 2 numbers");
	  int a=sc.nextInt();
	  int b=sc.nextInt();
	  
	  /* If Else statement will not be able to pass/ fail the method.
	  if(a==b)
	  {
		  System.out.println("Passed");
	  }
	  else
	  {
		  System.out.println("Failed");
	  }
	  */  
	  
	  //Assert.assertEquals(a, b);        //The Assert method will be used to determine whether the @test method passes or fails based on the condition we specify,
	  
	  Assert.assertEquals(a, b, "Entered numbers are not equal");
	  /* example: - 
	   * a=10, b=20; 10=20->flase; -> Print the message 
	   * a=10, b=10; 10=10->true;  -> It will not print the message 
	   */
	  
	  
	  //Assert.assertTrue(true);  
	  	  
	  
	 // Assert.assertEquals(a>b, true, "a is not greater than b");  //This message will be printed when failure happens
	  /* example: - 
	   * a=10, b=20; 10>20->flase; Expecting true but obtained false -> Print the message 
	   * a=20, b=10; 20>10->true; Expecting true and obtained true -> It will not print the message 
	   */
	  
	  
	  
  }
}
