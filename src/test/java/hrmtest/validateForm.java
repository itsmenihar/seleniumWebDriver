package hrmtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validateForm {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://localhost:8085/apps/kartonline");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("nihar");
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("sahu");
		driver.findElement(By.cssSelector("#input-email")).sendKeys("niharsahu@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("niharsahu123@");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//div[@id='alert']")).getText();
		System.out.println(msg);

	}

}
