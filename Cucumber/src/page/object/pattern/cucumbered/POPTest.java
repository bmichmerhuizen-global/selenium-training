package page.object.pattern.cucumbered;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions()
public class POPTest {
	static WebDriver driver;
	HomePage home;
	CalcPage calculator;
	ResultPage result;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
    @After
    public void tearDown() {
    	this.home = null;
    	this.calculator = null;
    	this.result = null;
    }

	@Before
	public void setUp() throws Exception {
		this.home = new HomePage(driver);
		this.home.getCalc();
		this.calculator = new CalcPage(driver);
	}

	


	@Test
	public void valid() {
		// input data and submit
		this.calculator.loadData(50000, 750, 180);
		this.calculator.submit();

		// Verify Result
		this.result = new ResultPage(driver);
		assertTrue("Wrong Page", result.hasString("Please apply Today!!"));
		assertTrue("Wrong Amount", result.hasString("$5000"));
	}

	@Test
	public void income() {
		this.calculator.loadData(49999, 750, 180);
		this.calculator.submit();

		// Verify Result
		this.result = new ResultPage(driver);
		assertTrue("Wrong Page", result.hasString("Your Income is too low"));
		assertTrue("Wrong Amount", result.hasString("$0"));

	}
	
	@Test
	public void credit() {
		this.calculator.loadData(50000, 749, 180);
		this.calculator.submit();

		// Verify Result
		this.result = new ResultPage(driver);
		assertTrue("Wrong Page", result.hasString("Your credit rating is not good enough"));
		assertTrue("Wrong Amount", result.hasString("$0"));

	}
	
	@Test
	public void emp() {
		this.calculator.loadData(50000, 750, 179);
		this.calculator.submit();

		// Verify Result
		this.result = new ResultPage(driver);
		assertTrue("Wrong Page", result.hasString("You have not worked long enough"));
		assertTrue("Wrong Amount", result.hasString("$0"));

	}



}
