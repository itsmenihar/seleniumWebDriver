package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://text-compare.com/");
		WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		input1.sendKeys("Hi everyone!");
		Actions act = new Actions(driver);

//		CTRL + A
		act.keyDown(Keys.CONTROL).sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();

//		CTRL + C
		act.keyDown(Keys.CONTROL).sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();

//		TAB
		act.sendKeys(Keys.TAB).perform();

//		CTRL + A
		act.keyDown(Keys.CONTROL).sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();

		if (input1.getAttribute("value").equals(input2.getAttribute("value"))) {
			System.out.println("Text copied successfully");
		} else {
			System.out.println("Text not copied");
		}
		driver.quit();

	}

}
