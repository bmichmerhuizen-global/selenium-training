package thursday;


import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import capital.TestScript;

public class TestPage2 {

	public static void main(String[] args) {
		// Create Driver
				URL path = TestScript.class.getClassLoader().getResource("TestPages/test2.html");
				URL resource = TestScript.class.getClassLoader().getResource("exes/geckodriver.exe");
				
				System.setProperty("webdriver.gecko.driver", resource.getPath().toString());
				// TODO Auto-generated method stub
				WebDriver driver = new FirefoxDriver();
				driver.get(path.toString());
		
		List<WebElement> paras = driver.findElements(By.name("td"));
		BryanTable bryanTable = new BryanTable(paras,2);
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
