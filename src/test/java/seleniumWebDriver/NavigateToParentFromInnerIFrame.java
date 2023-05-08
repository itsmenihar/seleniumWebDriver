package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateToParentFromInnerIFrame {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		WebElement inele = driver.findElement(By.xpath("//h1[text()='This page is displayed in an iframe']"));
		String innerText = inele.getText();
		System.out.println("The text present in the inner frame is: " + innerText);

		driver.switchTo().parentFrame();
		WebElement outele = driver
				.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]"));
		String outerText = outele.getText();
		System.out.println("The text present on the outer frame is: " + outerText);

	}

}
