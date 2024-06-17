package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertpopup {

	public static void main(String[] args) 
	{
		/*alert popups: - Alert is not an element of a web page hence we cannot inspect
		1) alert with ok
		2) alert with ok and cancel
		3) alert with inputbox along with ok and cancel
		4) alert with no element
		*/
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));  //declaration
		
		//1) alert with ok
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Switch the control from main page to popup. This can be achieved with the help "Alert" class
		
		//driver.switchTo().alert().accept();  //we have captured the alert and loaded it into alertwindow variable of Alert class. This can be used without explicit wait command 
		
		
		Alert alertwindow1=wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alertwindow1.getText());
						
		alertwindow1.accept(); //this will click "Ok" button and close the alert window
		
		String text1=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		System.out.println(text1);
		
		
		//2) alert with ok and cancel
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		
		Alert alertwindow2=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alertwindow2.getText());
		
		alertwindow2.dismiss();  
        String text2=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		System.out.println(text2);
		
		//3) alert with inputbox along with ok and cancel
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		Alert alertwindow3=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alertwindow3.getText());
		
		alertwindow3.sendKeys("Sooraj Nayak");
		alertwindow3.accept();
		
        String text3=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		System.out.println(text3);
		
		
		/*Sometimes when you launch the URL you will directly get a popup asking for usrname and password. Without entring these detail the the application will not be opened.
		 * in that case you need to pass the URL with username and password: - http://username:password@the-inernet.herokuapp.com/basic_auth
		 */

	}

}
