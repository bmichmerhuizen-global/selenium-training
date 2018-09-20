package page.object.pattern.cucumbered;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalcPage {
	private WebDriver driver;

	public CalcPage(WebDriver d) {
		driver = d;
	}

	public void loadData(int income, int credit, int emp) {

		setIncome(income);
		setCredit(credit);
		setEmployment(emp);
	}

	void setEmployment(int emp) {
		driver.findElement(By.id("employment")).sendKeys(Integer.toString(emp));
	}

	void setCredit(int credit) {
		driver.findElement(By.id("credit")).sendKeys(Integer.toString(credit));
	}

	void setIncome(int income) {
		driver.findElement(By.id("income")).sendKeys(Integer.toString(income));
	}

	public ResultPage submit() {
		driver.findElement(By.name("Calc")).click();
		return new ResultPage(driver);
	}

}
