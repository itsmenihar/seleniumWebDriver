package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQueryDropDownGenericMethod {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("justAnInputBox")).click();
//		selectChoiceValue(driver,"choice 2 1");
//		selectChoiceValue(driver,"choice 2 1","choice 6","choice 6 1","choice 6 2 3");
		selectChoiceValue(driver, "All");

	}

	public static void selectChoiceValue(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement item : choiceList) {
				String text = item.getText();
				for (String val : value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement item : choiceList) {
					item.click();
				}
			} catch (Exception e) {

			}
		}
	}

}
