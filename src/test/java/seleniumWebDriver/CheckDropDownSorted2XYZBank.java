package seleniumWebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted2XYZBank {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the Url
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on the Live Posting event
		driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
		// click on the dropdown element
		WebElement drpElement = driver.findElement(By.name("userSelect"));
		Select drpSelect = new Select(drpElement);

		// List all the webelement
		List<WebElement> options = drpSelect.getOptions();

		// create one original list and temp list
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();

		// Add all the option text in original list and temp list
		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		// Sort the temp list only with the help of Collections method
		Collections.sort(tempList);

		// compare the temp list with original list
		if (tempList.equals(originalList)) {
			System.out.println("DropDown Sorted..!");
		} else {
			System.out.println("DropDown Unsorted..!");
		}

	}

}
