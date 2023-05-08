package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownWithSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formstone.it/components/dropdown/demo/");

		// Select a state drop down
		WebElement selectStateDrp = driver.findElement(By.id("demo_label"));
		Select targetElement = new Select(selectStateDrp);
//		targetElement.selectByValue("OH");
		List<WebElement> allOptions = targetElement.getOptions();
		Thread.sleep(3000);
		for (WebElement option : allOptions) {
			if (option.getText().equals("Ohio")) {
				option.click();
				break;
			}
		}

	}

}
