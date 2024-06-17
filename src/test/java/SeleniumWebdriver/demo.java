package SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo 
{
	public static void main(String[] args) 
	{
		  WebDriver driver;
		  WebDriverWait wait;
		  String sport = "Karate";
		  String currentYear="2024";
		  String year = "1999";
		  String month = "DEC";
		  String date = "5";
		  String time = "3 PM - 4 PM";

		  WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    driver.get("https://lkmdemoaut.accenture.com/AccenSportz/#/");
		    driver.manage().window().maximize();
		    driver.findElement(By.cssSelector(".sportscoaching")).click();
		  
		    WebElement trainingschedule = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Training Schedule')]")));
		    trainingschedule.click();
		 
		    boolean textisfound = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(),'Training Schedule')]"), "Training Schedule"));

		    if (textisfound) 
		    {
		      WebElement bookslot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Book Your Slot')]")));
		      bookslot.click();
		    } 
		    else 
		    {
		      System.out.println("text is not found");
		    }
		 
		    WebElement selectsport = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Sport']")));
		    selectsport.click();
		    driver.findElement(By.xpath("//*[@role='listbox']//*[contains(text(), '" + sport + "')]")).click();
		    List<WebElement> listofsports=driver.findElements(By.xpath("//*[@id='mat-autocomplete-1']//*[@role='option']"));
		    for(int r=0; r<listofsports.size(); r++)
		    {
		    	String sp=listofsports.get(r).getText();
		    	if(sp.equals(sport))
		    	{
		    		listofsports.get(r).click();
		    	}
		    }
		        
		    //String textispresent = selectsport.getText();
		    //Assert.assertFalse(textispresent.isEmpty(), "Text box is empty please select the sport");
		  
		    int yearInt = Integer.parseInt(year);
		    int currentyearInt = Integer.parseInt(currentYear);

		    //driver.findElement(By.xpath("//*[@aria-label='Open calendar']")).click();
		    
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Open calendar']")));
		    element.click();
		    
		    driver.findElement(By.xpath("//*[@aria-label='Choose month and year']")).click();

		    // Ensure current year is retrieved correctly
		    //WebElement currentYearElement = driver.findElement(By.xpath("//*[contains(@class,'mat-calendar-body-today')]"));
		    //String currentYearText = currentYearElement.getText();
		    //Assert.assertFalse(currentYearText.isEmpty(), "Current year is not found");
		    
		    try {
	            
	            if (yearInt == currentyearInt) 
	            {
	                clickYear(driver, wait, year);
	            } 
	            else if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), '" + year + "')]"), year))) 
	            {
	                clickYear(driver, wait, year);
	            } 
	            else if (yearInt < currentyearInt) 
	            {
	                navigateToYear(driver, wait, year, true);
	            } 
	            else 
	            {
	                navigateToYear(driver, wait, year, false);
	            }
	        } 
		    catch (Exception e) 
		    {
	            e.printStackTrace();
	        } 
		    
	   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + month + "')]"))).click();
		    List<WebElement> listofdates = driver.findElements(By.xpath("//*[@class='mat-calendar-content']//table/tbody//td"));
		    for (WebElement listofdate : listofdates) 
		    {
		      if (date.equals(listofdate.getText())) 
		      {
		        listofdate.click();
		        break;
		      }
		    }
		 
		    WebElement slotTimeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='slotstime']")));
		    slotTimeElement.click();
		    driver.findElement(By.xpath("//*[@role=\"listbox\"]//child::*[contains(text(), '" + time + "')]")).click();
		  
		    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='submit'])[3]")));
		    submitButton.click();
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), 'Thank You!')]"), "Thank You!"));
		    WebElement confirmationText = driver.findElement(By.xpath("//*[contains(text(), 'Your slot from " + time + " has been booked successfully.')]"));
		    Assert.assertTrue(confirmationText.isDisplayed(), "Confirmation text is not displayed");
		    driver.findElement(By.xpath("//*[@id='okbutton']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Training Schedule')]")));
		  
		    driver.close();
		    
   
		  
}
//main function closed
	
public static void clickYear(WebDriver driver, WebDriverWait wait, String year) {
    try {
        WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + year + "')]//ancestor::button")));
        yearElement.click();
    } catch (Exception e) {
        System.out.println("Error clicking year: " + year);
        e.printStackTrace();
    }
}

public static void navigateToYear(WebDriver driver, WebDriverWait wait, String year, boolean goBack) {
    try {
        while (true) {
            if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), '" + year + "')]//ancestor::button"), year))) {
                clickYear(driver, wait, year);
                break;
            }
            if (goBack) {
                driver.findElement(By.xpath("(//*[@class='mat-mdc-focus-indicator'])[3]")).click();
            } else {
                driver.findElement(By.xpath("(//*[@class='mat-mdc-focus-indicator'])[4]")).click();
            }
        }
    } catch (Exception e) {
        System.out.println("Error navigating to year: " + year);
        e.printStackTrace();
    }
}    
}   
