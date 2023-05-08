package seleniumWebDriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) throws InterruptedException {

		String location = System.getProperty("user.dir") + "\\Downloads\\";

		// Chrome,Edge

		HashMap<String,Object> preferences = new HashMap<String,Object>();
		preferences.put("download.default_directory", location);
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(options);

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(options);

		
		driver.manage().window().maximize();

		driver.get("https://file-examples.com/index.php/sample-documents-download/");

		WebElement advert = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//div[3]//a[1]"));
		if (advert.isDisplayed()) {
			advert.click();
		}

		WebElement btn = driver.findElement(By
				.xpath("//a[@href='https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/']"));
		btn.click();

	}

}
