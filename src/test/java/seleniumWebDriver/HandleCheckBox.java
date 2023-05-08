package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");

// 1:-Select specific checkbox
//		driver.findElement(By.xpath("//input[@id='monday']")).click();

		// 2:-Select all the checkboxes
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total number of check boxes is:" + checkBoxes.size());

//2.1:-Using for loop
		/*
		 * for(int i=0;i<checkBoxes.size();i++) { checkBoxes.get(i).click(); }
		 */

//2.2:-Using for each loop
		/*
		 * for(WebElement chBox: checkBoxes) { chBox.click(); }
		 */

//3:-Select multiple check boxes by choices
		/*
		 * for(WebElement chBox: checkBoxes) { String choice = chBox.getAttribute("id");
		 * if(choice.equals("monday") || choice.equals("thursday")) { chBox.click(); } }
		 */

//4:-Select last two check boxes
		/*
		 * int totalNoOfCheckBoxes =checkBoxes.size(); for(int i=totalNoOfCheckBoxes-2;
		 * i<totalNoOfCheckBoxes ;i++) { checkBoxes.get(i).click(); }
		 */

//4.1:- Select first two check boxes
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (i < 2) {
				checkBoxes.get(i).click();
			}
		}

	}

}
