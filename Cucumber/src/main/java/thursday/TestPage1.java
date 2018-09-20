package thursday;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import capital.TestScript;

public class TestPage1 {

	public static void main(String[] args) {
		// Create Driver
		URL path = TestScript.class.getClassLoader().getResource("TestPages/test1.html");
		URL resource = TestScript.class.getClassLoader().getResource("exes/geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", resource.getPath().toString());
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get(path.toString());

		

		WebElement para = driver.findElement(By.tagName("p"));
		WebElement input1 = driver.findElement(By.name("firstname"));
		WebElement input2 = driver.findElement(By.name("lastname"));
		WebElement tablecell = driver.findElement(By.id("cell"));

	
		
//	System.out.printf("Para getText: |%s|\n",para.getText());
//	System.out.printf("Para innerHTML: |%s|\n",para.getAttribute("innerHTML"));
//	System.out.printf("Para language: |%s|\n",para.getAttribute("lang"));
	
//	System.out.printf("input1 getText: |%s|\n",input1.getText());
//	System.out.printf("input1 innerHTML: |%s|\n",input1.getAttribute("innerHTML"));
//	System.out.printf("input1 l: |%s|\n",input1.getAttribute("innerHTML"));
	
	
//	System.out.printf("input1 value: |%s|\n",input1.getAttribute("Value"));
//	System.out.printf("input2 value: |%s|\n",input2.getAttribute("Value"));
    
  //	input1.sendKeys("babaloo");
	//input2.clear();

	//System.out.printf("input1 value: |%s|\n",input1.getAttribute("Value"));
	//System.out.printf("input2 value: |%s|\n",input2.getAttribute("Value"));
		System.out.printf("tablecell getText: |%s|\n",tablecell.getText());
		System.out.printf("tablecell innerHTML: |%s|\n",tablecell.getAttribute("innerHTML"));
		driver.close();
	}

}
