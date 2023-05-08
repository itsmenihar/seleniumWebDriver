package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://demo.opencart.com/admin/");

		WebElement userNameBox = driver.findElement(By.name("username"));
		WebElement passwordBox = driver.findElement(By.name("password"));

		userNameBox.clear();
		userNameBox.sendKeys("demo");
		passwordBox.clear();
		passwordBox.sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// important security notification
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();

//Sales->Orders
		driver.findElement(By.cssSelector(".parent[href='#collapse-4']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

//total number of pages
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println("Total number of pages: " + total_pages);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");

//Find how many rows are exists in each page
		for (int p = 1; p <= total_pages; p++) {
			WebElement active_page = driver
					.findElement(By.xpath("//ul[@class='pagination']//li//span[text()='" + p + "']"));
			System.out.println("Active page" + active_page.getText());

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))
					.size();
			System.out.println("Number of rows" + rows);

//Read all the rows from each page

			for (int r = 1; r <= rows; r++) {
				String orderID = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + r + "]/td[2]"))
						.getText();
				String customer = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + r + "]/td[4]"))
						.getText();
				String status = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + r + "]/td[5]"))
						.getText();
				if (status.equals("Pending")) {
					System.out.println(orderID + "      " + customer + "      " + status);
				}
			}

			String pageNo = Integer.toString(p + 1);
			try {
				WebElement nextPage = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageNo + "']"));
				nextPage.click();
			} catch (Exception e) {

			}

		}

	}

}
