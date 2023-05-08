package seleniumWebDriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//How to capture cookies from the browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		//How to print cookies from the browser
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}
		
		//How to add cookie to the browser
		Cookie cookieObj = new Cookie("MyCookie22","oishwhgo156");
		driver.manage().addCookie(cookieObj);
		cookies =driver.manage().getCookies();
		System.out.println("Size of the cookie "+ cookies.size());
		
		
		//How to delete cookie from browser
//		driver.manage().deleteCookie(cookieObj);
		driver.manage().deleteCookieNamed("MyCookie22");
		cookies = driver.manage().getCookies();
		System.out.println("After deletion of cookie:"+cookies.size());
		
		//How to delete all the cookie from the browser
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("After deletion of cookie:"+cookies.size());

	}

}
