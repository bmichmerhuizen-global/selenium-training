/**
 * 
 */
package capital;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Administrator
 *
 */
public class TestScript {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path path = java.nio.file.Paths.get("src/test1.html");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get(path.toUri().toString());
		
		System.out.println("title:\t" + driver.getTitle());
		System.out.println("page url:"+driver.getCurrentUrl());
		System.out.println("page source:"+driver.getPageSource());
		

	}

}
