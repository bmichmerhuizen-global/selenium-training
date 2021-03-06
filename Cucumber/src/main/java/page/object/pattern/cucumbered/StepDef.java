package page.object.pattern.cucumbered;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import capital.TestScript;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

public class StepDef {
	WebDriver driver;
	String bodyText;
	Path cashflowBase;
	private CalcPage calcPage = null;
	private HomePage homePage = null;
	private ResultPage resultPage = null;
	
	@Before
	public void setUp() throws Throwable {
		cashflowBase = java.nio.file.Paths.get(TestScript.class.getClassLoader().getResource("CashFlow").toURI());
		URL resource = TestScript.class.getClassLoader().getResource("exes/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", resource.getPath().toString());		
		driver = new FirefoxDriver();
		
	}
	@After
	public void tearDown() throws Throwable{
		driver.close();
	}
	
	
	@Given("^the user is at the calculator$")
	public void atCalculator() throws Throwable {
		homePage = new HomePage(driver);
		calcPage = homePage.getCalc();
	}
	
	@When("^the user enters (\\d+) for income$")
	public void setIncome(int income) throws Throwable {
		calcPage.setIncome(income);
	}

	@When("^enters (\\d+) for credit rating$")
	public void setCredit(int credit) throws Throwable {
		calcPage.setCredit(credit);
	}

	@When("^enters (\\d+) for days of employment$")
	public void setEmployment(int emp) throws Throwable {
		calcPage.setEmployment(emp);
	}
	@Then("^the calculator provides the message \"([^\"]*)\"$")
	public void getMessage(String message) throws Throwable {
		 resultPage  = calcPage.submit();
	     
	     assertTrue(resultPage.hasString(message));
	}
	@Then("^gives a maximum limit of (\\d+)$")
	public void getLimit(int limit) throws Throwable {
		if(resultPage == null) throw new CucumberException("improper page access");
		
		assertTrue(resultPage.hasString("$"+Integer.toString(limit)));
	}
	
	@Then("^the page title is \"([^\"]*)\"$")
	public void the_page_title_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue("un-expected page title", driver.getTitle().equals(arg1));
	}

	@Given("^the user is at the \"([^\"]*)\" page$")
	public void the_user_is_at_the_page(String arg1) throws Throwable {
		Path calculator = cashflowBase.resolve("index.html");
		driver.get(calculator.toUri().toString());
		driver.findElement(By.xpath("//*[@id=\"navlist\"]/li/a[contains(text(),\""+arg1+"\")]")).click();
	}

	@Then("^the page contains \"([^\"]*)\"$")
	public void the_page_contains(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		this.bodyText = driver.findElement(By.tagName("body")).getText();
	     assertTrue(this.bodyText.contains(arg1));
	}
	@When("^the user clicks the \"([^\"]*)\" link$")
	public void the_user_clicks_the_link(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navlist\"]/li/a[contains(text(),\""+arg1+"\")]")).click();
	}
}
