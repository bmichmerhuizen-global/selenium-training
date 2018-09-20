package simple.jUnit;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cash {
    static WebDriver driver;
    
	// initialize web driver
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\geckodriver.exe");	
		driver = new FirefoxDriver();

	}
    @AfterClass
    public static void tearDownAfterClass() {
    	driver.close();
    }

	@Before
	public void setUp() throws Exception {
		//driver.wait(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/CashFlow/index.html");
		driver.findElement(By.cssSelector("a[href*='calc'")).click();
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void valid() {
		// input data and submit
        driver.findElement(By.id("income")).sendKeys("50000");
        driver.findElement(By.id("credit")).sendKeys("750");
        driver.findElement(By.id("employment")).sendKeys("180");
        driver.findElement(By.name("Calc")).click();
        
        // extract text from result
        String result = driver.findElement(By.tagName("body")).getText();
		assertTrue("Wrong Page",result.contains("Please apply Today!!"));
		assertTrue("Wrong Amount",result.contains("$5000"));
	}
	
	@Test
	public void income() {
		// input data and submit
        driver.findElement(By.id("income")).sendKeys("49999");
        driver.findElement(By.id("credit")).sendKeys("750");
        driver.findElement(By.id("employment")).sendKeys("180");
        driver.findElement(By.name("Calc")).click();
        
        // extract text from result
        String result = driver.findElement(By.tagName("body")).getText();
		assertTrue("Wrong Page",result.contains("Your Income is too low"));
		assertTrue("Wrong Amount",result.contains("$0"));
	}

}
