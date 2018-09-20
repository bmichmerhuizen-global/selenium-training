/**
 * 
 */
package capital;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Administrator
 *
 */
public class TestScript2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		URL path = TestScript.class.getClassLoader().getResource("test1.html");
		URL resource = TestScript.class.getClassLoader().getResource("exes/geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", resource.getPath().toString());
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get(path.toString());
		// TODO Auto-generated method stub
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
