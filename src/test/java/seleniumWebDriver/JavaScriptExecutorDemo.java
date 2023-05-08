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

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");

//		Drawing border and take screenshot
		/*
		 * WebElement logo =
		 * driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 * JavaScriptUtil.drawBorder(logo, driver);
		 * 
		 * TakesScreenshot tc = (TakesScreenshot)driver; File src =
		 * tc.getScreenshotAs(OutputType.FILE); File trg = new
		 * File(".\\screenshots\\logo.png"); FileUtils.copyFile(src, trg);
		 */

//		Getting title of the page
		
		 String title = JavaScriptUtil.getTitleByJS(driver);
		 System.out.println(title);
		 

//		click an element
		
		 /* WebElement regd =
		  driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]"));
		  JavaScriptUtil.clickByJS(regd, driver);*/
		 

//		Generate alert
//		JavaScriptUtil.generateAlertMsg(driver, "This is my alert...!");

//		Refreshing the pages
//		JavaScriptUtil.refreshPages(driver);

//		scrolling down
//		JavaScriptUtil.scrollingPageDown(driver);
//
//		Thread.sleep(3000);

//		scrolling up
//		JavaScriptUtil.scrollingPageUp(driver);
		
//		Zooming the page
//		JavaScriptUtil.zoomPageByJS(driver);
		 
//		 flashing the element
		 WebElement logo =
				 driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 JavaScriptUtil.flash(logo, driver);

	}

}
