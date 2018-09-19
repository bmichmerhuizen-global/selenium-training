package page.object.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalcPage {
	private WebDriver driver;

	public CalcPage(WebDriver d) {
		driver = d;
	}

	public void loadData(int income, int credit, int emp) {

		driver.findElement(By.id("income")).sendKeys(Integer.toString(income));
		driver.findElement(By.id("credit")).sendKeys(Integer.toString(credit));
		driver.findElement(By.id("employment")).sendKeys(Integer.toString(emp));
	}

	public void submit() {
		driver.findElement(By.name("Calc")).click();
	}

}
