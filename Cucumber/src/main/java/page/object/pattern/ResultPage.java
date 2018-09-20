package page.object.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
	private WebDriver driver;

	public ResultPage(WebDriver d) {
		driver = d;
	}
	public boolean hasString(String text) {
		String body = driver.findElement(By.tagName("body")).getText();
		return body.contains(text);
	}

}
