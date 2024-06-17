package TestNG1;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardandSoftAssertion 
{
  //@Test
  public void Hardassertion() 
  {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the 2 numbers");
	  int a=sc.nextInt();
	  int b=sc.nextInt();
	  
	  System.out.println("hello.....");
	  System.out.println("hello.....");
	  System.out.println("hello.....");
	  
	  Assert.assertEquals(a, b);  //This is hard assertion -> If hard assertion fails then the statements written after hard assertion will not be executed.
	  
	  System.out.println("Hard assertion completed");
   }
  
  @Test
  public void Softassertion() 
  {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the 2 numbers");
	  int a=sc.nextInt();
	  int b=sc.nextInt();
	  
	  System.out.println("hello.....");
	  System.out.println("hello.....");
	  System.out.println("hello.....");
	  
	  SoftAssert soft=new SoftAssert(); //This is declaring soft assertion -> If soft assertion fails then the statements written after soft assertion will be executed.
	  
	  soft.assertEquals(a, b);  
	  
	  System.out.println("Soft assertion completed");
	  
	  soft.assertAll();  //At the end of the script write this statement which is mandatory  
   }
}
