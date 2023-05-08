package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerExample2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.dummyticket.com/");
		WebElement buyTicketBtn = driver.findElement(By.xpath(
				"//div[contains(@class,'ffb-id-1bt552nb buttons-el-wrapper text-center text-md-left fg-text-light fg-wow fadeInUp')]//a[contains(@class,'btn-w-auto fg-text-light ffb-button1-1')]"));
		buyTicketBtn.click();

		WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
		dob.click();

//select month
		WebElement monDropDown = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		selectOptionsFromDropdown(monDropDown, "Feb");

		WebElement yearDropDown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		selectOptionsFromDropdown(yearDropDown, "1965");

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for (WebElement date : allDates) {
			String targetDate = date.getText();
			if (targetDate.equals("25")) {
				date.click();
				break;
			}
		}

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
