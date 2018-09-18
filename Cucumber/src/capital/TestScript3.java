/**
 * 
 */
package capital;

import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Administrator
 *
 */
public class TestScript3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path path = java.nio.file.Paths.get("src/command.set.II.html");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get(path.toUri().toString());
		String homePage = driver.getCurrentUrl();
		System.out.println("title:\t" + driver.getTitle());
		driver.navigate().to("http://www.capitalone.com");
		String capOneUrl = driver.getCurrentUrl();
		System.out.println("title:\t" + driver.getTitle());
		driver.navigate().back();
		assertTrue(homePage.equals(driver.getCurrentUrl()));
		driver.navigate().forward();
		assertTrue(capOneUrl.equals(driver.getCurrentUrl()));
		driver.close();

	}

}
