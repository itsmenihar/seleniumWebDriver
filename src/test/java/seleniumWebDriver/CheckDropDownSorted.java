package seleniumWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		

		// Navigate to the Url
		driver.get("https://www.twoplugs.com/");

		// click on the Live Posting event
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		// click on the dropdown element
		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpSelect = new Select(drpElement);

		// List all the webelement
		List<WebElement> option1 = drpSelect.getOptions();

		// create one original list and temp list
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();
		
		//printing the original list and temp list in console
		System.out.println(originalList);
		System.out.println(tempList);

		// Add all the option text in original list and temp list
		for (WebElement option : option1) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		// Sort the temp list only with the help of Collections method
		Collections.sort(tempList);
		
		//after sorted printing the temp list in console
		System.out.println(tempList);

		// compare the temp list with original list
		if (tempList.equals(originalList)) {
			System.out.println("DropDown Sorted..!");
		} else {
			System.out.println("DropDown Unsorted..!");
		}
		driver.close();

	}

}
