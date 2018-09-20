package thursday;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPage2 {

	public static void main(String[] args) {
		// Create Driver
		System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\temp\\logs.txt");
		WebDriver driver = new FirefoxDriver();

		// Open Webpage
		driver.get("file:///C:/TestPages/test2.html");
		
		List<WebElement> paras = driver.findElements(By.name("para"));
		int NumofParas = paras.size();
		System.out.printf("Number of paras = %d\n", NumofParas);
		for (WebElement e : paras) {
			System.out.println(e.getText());
		}
		
		//WebElement h1 = driver.findElement(By.tagName("h1"));
		
		//List<WebElement> h1s = driver.findElements(By.tagName("h1"));
		//System.out.printf("Number of h1s = %d\n", h1s.size());
		
		driver.close();

	}

}
