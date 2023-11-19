package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpencartComparison {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8085/apps/techmart");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iMac");
		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).click();
		Actions ac = new Actions(driver);
		ac.scrollByAmount(0, 200);
		driver.findElement(By.xpath("//img[@title='iMac']")).click();
		WebElement comp = driver.findElement(By.xpath("//div[@class='col-sm']//form//button[2]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ac.scrollByAmount(0, 200);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-sm']//form//button[2]")));
		ac.moveToElement(comp).perform();
		WebElement toolTip = driver.findElement(By.cssSelector(".tooltip-inner"));
		System.out.println(toolTip.getText());

		comp.click();

	}

}
