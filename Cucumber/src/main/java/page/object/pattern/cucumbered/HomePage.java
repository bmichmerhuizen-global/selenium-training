package page.object.pattern.cucumbered;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	public class HomePage {
		private WebDriver driver;

		public HomePage(WebDriver d) {
			driver = d;
			driver.get("file:///C:\\cashflow\\index.html");
		}
		public CalcPage getCalc() {
			driver.findElement(By.cssSelector("a[href*='calc'")).click();
			return new CalcPage(driver);
		}


	}
