package TestNG1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Explanation 
{
	//Suite  -> Test --> Classes --> Class
	//TestNG classes do not need Main method.
	/*List of Annotations: - 
	 * @Test
	 * @BeforeMethod -> It will be executed before every @test method
	 * @AfterMethod  -> It will be executed after every @test method
	 * @BeforeClass  -> It will be executed before starting all the @test methods in the class
	 * @AfterClass   -> It will be executed after completing all the @test methods in the class
	 * @BeforeTest   -> It will be executed before the Test in the XML suite file 
	 * @AfterTest    -> It will be executed after the Test in the XML suite file 
	 * @BeforeSuite  -> It will be executed before the Suite in the XML suite file 
	 * @AfterSuite   -> It will be executed after the Suite in the XML suite file 
	 * @DataProvider(name="", indices= {, , ,})
	 * @Parameters({"name1","name2"})
	 */
	
	
	//Write annotations before the method
	//If you don't specify the annotation then, TestNG will not execute the method.   
	//If the same annotation is provided for multiple methods, then those methods will be executed based on alphabetical order.  
    //To control the order of the execution we provide priority
	
	//XML file or Test Suite or Package 
	//To see|generate the test report we need to use TestNG XML file.
	//We can run multiple test cases using single XML file
	//We can create the XML file OR We can create the XML file automatically
	
	/*By default, TestNg will run all of the methods, regardless of whether the dependent method that comes before it passes or fails.
	 * So. to avoid this we use dependsOnmethods
	 * 
	 * @Test(priority=3, dependsOnMethods= {"login","Search"})
	 */
	
	/*The Assert method will be used to determine whether the @test method passes or fails based on the condition we specify,
	 * since If Else statement will not be able to pass/ fail the method. 
	 * Two types of assertion-> hard assertion and soft assertion
	 * Hard assertions are available in Assert class directly but, soft assertion are available in SoftAssert class which needs to be declared 
	 */
	
	//Grouping is used to decide which method to execute (can be achieved with the help of XML file) 
	//@Test(priority=1,groups= {"sanity","regression"})
	
	
	//Parameterization -> Passing the parameters to the method
	//1)@DataProvider
	/*This can be achieved with the help of @DataProvider annotation
	 * The method written with @DataProvider will generate the data and pass the data to the method hence no looping statement is required to repeat it multiple time. 
	 * dataprovider method will read the data from excel sheet using XLutils and store it in 2 dimensional array.
	 * 
	
	// invocationCount -> When you want to repeat the method multiple time without using data.
	  

     //2) XML - Parallel testing
      * @Parameters({"name1","name2"})
      * Parameterization can also be achieved with the help XML file by passing the parameters
      * Parallel testing means-> we can execute the same test case on multiple browser at same time. 
      * Advantage: - We can execute the multiple test cases at once so that it will save the time.

     step1) create test case
     step 2) create xml file to run the test
     step3) pass browser name parameter from the xml to setup() method
     step4 ) execute test case on chrome & edge ( serial execution)
     step5 ) execute test case on chrome & edge ( parallel execution)
             
       Cross browser testing -> We can execute the same test case in different browser
       Example: - 
       TC1 -> executing in chrome
           -> executing in firefox
           -> executing in edge   
           
       This i can achieve in two ways 1) serial execution  -> Through serial execution, first it will execute the TC1 in chrome then after in firefox and then in edge in a sequential manner.                                     
                                      2) parallel execution   -> Through parallel execution, it will execute the TC1 on all the browsers at same time.
                                         
     */
}
