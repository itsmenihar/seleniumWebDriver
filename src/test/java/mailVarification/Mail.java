package mailVarification;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mail {
	public static void main(String[] args) {
		String email = "niharranjansahu2@gmail.com";
		String password = "Niharsarita22@";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://mail.google.com/");
		WebElement email_Field = driver.findElement(By.xpath("//input[@id='identifierId']"));
		email_Field.sendKeys(email);
		WebElement next_Button_1 = driver.findElement(By.xpath("//span[text()='Next']"));
		next_Button_1.click();
		WebElement pass_Input = driver.findElement(By.xpath("//input[@name='Passwd']"));
		wait.until(ExpectedConditions.visibilityOf(pass_Input));
		pass_Input.sendKeys(password);
		WebElement next_Button_2 = driver.findElement(By.xpath("//span[text()='Next']"));
		next_Button_2.click();
	}
}
