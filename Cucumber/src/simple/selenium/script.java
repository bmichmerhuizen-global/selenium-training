package simple.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class script {

	public static void main(String[] args) {
		// Create Driver
		System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		
		// Open Webpage
		driver.get("file:///C:/CashFlow/index.html");
		
		// go to calculator page
		WebElement widget = driver.findElement(By.cssSelector("a[href*='calc'"));
       	widget.click();
        
       	// Enter Data
        widget = driver.findElement(By.id("income"));
        widget.sendKeys("50000");
        widget = driver.findElement(By.id("credit"));
        widget.sendKeys("750");
        driver.findElement(By.id("employment")).sendKeys("180");
        
        // hit the submit button.
        driver.findElement(By.name("Calc")).click();
        
        //Verify Page
       widget = driver.findElement(By.tagName("body"));
       String result = widget.getText();
       if (! result.contains("Please apply Today!!")) {
    	   System.out.println("FAILURE: Wrong Page");
       }
       else if  (! result.contains("$5000")) {
    	   System.out.println("FAILURE: Amount");
       }
       else {
    	   System.out.println("All Tests Pass");
       }
	}
	

}
