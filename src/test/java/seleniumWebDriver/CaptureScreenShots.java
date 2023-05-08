package seleniumWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShots {

	public static void main(String[] args) throws IOException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
//		take screeshot of full page
		/*TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\screenshot.png");
		FileUtils.copyFile(src, trg);*/
		
//		take screenshot of a section/portion of  page
		/*WebElement sec =driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = sec.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\features.png");
		FileUtils.copyFile(src, trg);*/
		
//		take screenshot of element on a page
		WebElement ele =driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
		
		driver.quit();
		

	}

}
