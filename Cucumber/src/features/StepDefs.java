package features;

import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

	WebDriver driver;
	String bodyText;
	Path cashflowBase;

	@Before
	public void setUp() throws Throwable {
		Path path = java.nio.file.Paths.get("src/logs.txt");
		 
		
		System.setProperty("webdriver.gecko.driver", Paths.get("resources", "exes","geckodriver.exe").toUri().toString());
		
		System.setProperty("webdriver.chrome.driver", Paths.get("resources", "exes","chromedriver.exe").toUri().toString());
		
		System.setProperty("webdriver.IE.driver", Paths.get("resources", "exes","IEDriverServer.exe").toUri().toString());
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,path.toString());
		driver = new FirefoxDriver();
		cashflowBase = java.nio.file.Paths.get("resources/CashFlow");
		
	}


	@Given("^the user is at the calculator$")
	public void atCalculator() throws Throwable {
		Path calculator = cashflowBase.resolve("index.html");
		driver.get(calculator.toUri().toString());
		driver.findElement(By.cssSelector("a[href*='calc'")).click();
	}

	@When("^the user enters (\\d+) for income$")
	public void setIncome(int income) throws Throwable {
		driver.findElement(By.id("income")).sendKeys(Integer.toString(income));
	}

	@When("^enters (\\d+) for credit rating$")
	public void setCredit(int credit) throws Throwable {
		driver.findElement(By.id("credit")).sendKeys(Integer.toString(credit));
	}

	@When("^enters (\\d+) for days of employment$")
	public void setEmployment(int emp) throws Throwable {
		driver.findElement(By.id("employment")).sendKeys(Integer.toString(emp));
	}

	@Then("^the calculator provides the message \"([^\"]*)\"$")
	public void getMessage(String message) throws Throwable {
		 driver.findElement(By.name("Calc")).click();
	     this.bodyText = driver.findElement(By.tagName("body")).getText();
	     assertTrue(this.bodyText.contains(message));
	}

	@Then("^gives a maximum limit of (\\d+)$")
	public void getLimit(int limit) throws Throwable {
		assertTrue(this.bodyText.contains("$"+Integer.toString(limit)));
	}
	
	@After
	public void cleanUp () throws Throwable{
		driver.close();
	}

}
