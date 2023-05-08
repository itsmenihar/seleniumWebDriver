package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdownGenericMethod {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://formstone.it/components/dropdown/demo/");
		WebElement selectStateDdp = driver.findElement(By.id("demo_label"));
		selectOptionsFromDropdown(selectStateDdp, "Hawaii");
		WebElement country = driver.findElement(By.id("demo_basic_2"));
		selectOptionsFromDropdown(country, "Indiana");
		driver.quit();
	}

	public static void selectOptionsFromDropdown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> allOptions = drp.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
