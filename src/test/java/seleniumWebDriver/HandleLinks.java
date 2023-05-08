package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

//linkText and partialLinkText WebElement locator		
		/*
		 * driver.findElement(By.linkText("Best Sellers")).click();
		 * System.out.println(driver.getTitle());
		 * driver.findElement(By.partialLinkText("Best")).click();
		 */

//How to capture all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println("Number of links present :" +links.size());

//		Using normal for loop
		/*
		 * for(int i=0; i<=links.size(); i++) {
		 * System.out.println(links.get(i).getText());
		 * System.out.println(links.get(i).getAttribute("href")); }
		 */
		
//Using for each loop
		for(WebElement link : links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
	}

}
