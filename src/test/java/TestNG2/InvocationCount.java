package TestNG2;

import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test(invocationCount=10)   //This will execute the method 10 times
	void test()
	{
	System.out.println("testing...");	
	}
	
}
