package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
//Min slider
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the min slider:" + min_slider.getLocation()); // 59, 250
		System.out.println("Height and width of the min slider:" + min_slider.getSize()); // 21,21

		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 110, 0).perform();

//Afetr draging the min slider
		System.out.println("Location of the min slider:" + min_slider.getLocation()); // 170, 250
		System.out.println("Height and width of the min slider:" + min_slider.getSize()); // 21,21

//Max slider
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of max slider:" + max_slider.getLocation());
		System.out.println("Height and width of the max slider:" + max_slider.getSize());
		act.dragAndDropBy(max_slider, -50, 0).perform();

//After draging the max slider 
		System.out.println("Location of max slider:" + max_slider.getLocation());
		System.out.println("Height and width of the max slider:" + max_slider.getSize());

	}

}
