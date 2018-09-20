/**
 * 
 */
package capital;

import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Administrator
 *
 */
public class TestScript {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
		
		URL path = TestScript.class.getClassLoader().getResource("test1.html");
		URL resource = TestScript.class.getClassLoader().getResource("exes/geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", resource.getPath().toString());
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get(path.toString());
		
		System.out.println("title:\t" + driver.getTitle());
		System.out.println("page url:"+driver.getCurrentUrl());
		System.out.println("page source:"+driver.getPageSource());
		

	}

}
