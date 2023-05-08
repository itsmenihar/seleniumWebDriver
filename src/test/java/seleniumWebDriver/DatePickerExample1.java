package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerExample1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/datepicker/");

		String year = "2023";
		String month = "December";
		String date = "31";

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();

		while (true) {
			String monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			String arr[] = monthYear.split(" ");
			String mon = arr[0];
			String yr = arr[1];

			if (month.equals(mon) && year.equals(yr)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for (WebElement ele : allDates) {
			String targetDate = ele.getText();
			if (targetDate.equals(date)) {
				ele.click();
				break;
			}
		}

	}

}
