package hrmtest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HrModule {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8081/app/hrm/wp-login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("user_login")).sendKeys("hrm_admin");
		driver.findElement(By.id("user_pass")).sendKeys("hrm@root");
		driver.findElement(By.id("wp-submit")).click();
//		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='WP ERP']"))).build().perform();
		List<WebElement> options = driver
				.findElements(By.xpath("//li[@id='toplevel_page_erp']/ul[@class='wp-submenu wp-submenu-wrap']/li/a"));
		wait.until(ExpectedConditions.visibilityOfAllElements(options));

		for (WebElement neededmodule : options) {
			if (neededmodule.getText().equals("HR")) {
				act.moveToElement(neededmodule).click().perform();
				break;
			}
		}

		driver.findElement(By.xpath("//a[normalize-space()='View Employees']")).click();
		driver.findElement(By.xpath("//a[@id='erp-employee-new']")).click();
		try {
			driver.findElement(By.xpath("//span[@id='select2-worktype-container']")).click();
			List<WebElement> empTypes = driver.findElements(
					By.xpath("//span//span[@class='select2-results']//ul[@id='select2-worktype-results']/li"));
			for (WebElement type : empTypes) {
				String fullTime = type.getText();
				if (fullTime.equalsIgnoreCase("Full Time")) {
					type.click();
				}
			}
		} catch (StaleElementReferenceException st) {
			System.out.println(st.toString());
		}
		try {
			driver.findElement(By.xpath("//div[@class='col-3']//span[@id='select2-workstatus-container']")).click();
			List<WebElement> empStatus = driver.findElements(
					By.xpath("//span//span[@class='select2-results']//ul[@id='select2-workstatus-results']/li"));
			for (WebElement status : empStatus) {
				String active = status.getText();
				if (active.equalsIgnoreCase("Active")) {
					status.click();
				}
			}
		} catch (StaleElementReferenceException st) {
			System.out.println(st.toString());
		}

//		Actions actions = new Actions(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		ArrayList<String> links = new ArrayList<String>();
//		for (WebElement element : options) {
//			actions.moveToElement(element).perform();
//			links.add(driver.getCurrentUrl());
//		}
//
//		for (String link : links) {
//			js.executeScript(String.format("window.open('%s', '_blank');", link));
//		}
	}

}
