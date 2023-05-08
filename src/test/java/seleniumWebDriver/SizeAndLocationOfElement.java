package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));

//		Location Method 1
		System.out.println("Location of the BrandLogo(x,y):" + logo.getLocation());
		System.out.println("Location of the BrandLogo(x):" + logo.getLocation().getX());
		System.out.println("Location of the BrandLogo(y):" + logo.getLocation().getY());

//		Location Method 2
		System.out.println("Location of the BrandLogo(x):" + logo.getRect().getX());
		System.out.println("Location of the BrandLogo(y):" + logo.getRect().getY());

//		Size of an Element Method 1
		System.out.println("Width and height of an element" + logo.getSize());
		System.out.println("Width of the brand logo" + logo.getSize().getWidth());
		System.out.println("Height of the brand logo" + logo.getSize().getHeight());
		
//		Size of an Element Method 2
		System.out.println("Width of the brand logo" + logo.getRect().getDimension().getWidth());
		System.out.println("Height of the brand logo" + logo.getRect().getDimension().getHeight());
		

	}

}
