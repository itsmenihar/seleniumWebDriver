package seleniumWebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertWindowPopup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//1:-Alert window with OK button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 * driver.switchTo().alert().accept();
		 */

//2:-Alert window with OK and Cancel button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		 * driver.switchTo().alert().accept(); driver.switchTo().alert().dismiss();
		 */

//3:-Alert window with input box, capture text from alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("The message displayed on alert is:" + alertWindow.getText());
		alertWindow.sendKeys("Hello");
		alertWindow.accept();

	}

}
