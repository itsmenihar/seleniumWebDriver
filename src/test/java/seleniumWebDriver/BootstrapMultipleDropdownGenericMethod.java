package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapMultipleDropdownGenericMethod {
	 static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> allProductType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		selectDropDownList(allProductType,"EMI");
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> allProduct = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		selectDropDownList(allProduct,"Lifecare");

	}
	public static void selectDropDownList(List<WebElement> options, String value) {
		for(WebElement option : options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
		
	}

}
