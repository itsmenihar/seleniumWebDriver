package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrames {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

//1:-First frame
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium.chrome']")).click();
		driver.switchTo().defaultContent();

//2:- Second frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//a[normalize-space()='ChromeOptions']")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(3000);
//3:- Third frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();

	}

}
