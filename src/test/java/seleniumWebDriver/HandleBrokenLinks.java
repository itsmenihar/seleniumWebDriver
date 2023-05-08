package seleniumWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLinks = 0;
		int validLinks = 0;
		for (WebElement ele : links) {
			String url = ele.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("Url is Empty");
				continue;
			}
			try {

				URL link = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) link.openConnection();
				conn.connect();
				if (conn.getResponseCode() >= 400) {
					System.out.println(conn.getResponseCode() + url + "is" + " Broken Link");
					brokenLinks++;
				} else {
					System.out.println(conn.getResponseCode() + url + "is" + " Valid Link");
					validLinks++;
				}
			} catch (Exception e) {

			}
		}
		System.out.println("Total number of broken links present in the page is :" + brokenLinks);
		System.out.println("Total number of valid links present in the page is :" + validLinks);
		driver.quit();

	}

}
