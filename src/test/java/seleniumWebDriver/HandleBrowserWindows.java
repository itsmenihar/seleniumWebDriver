package seleniumWebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

//1:- getWindowHandle()
		/*
		 * String windowID = driver.getWindowHandle(); System.out.println(windowID);
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

//2:-getWindowHandles()
		Set<String> windowIDs = driver.getWindowHandles(); // return ID's of multiple browser windows

		// first method - iterator
		/*
		 * Iterator<String> it = windowIDs.iterator();
		 * 
		 * String parentWindowID = it.next(); String childWindowID = it.next();
		 * 
		 * System.out.println(parentWindowID); System.out.println(childWindowID);
		 */

		// Second method -using List & ArrayList
		List<String> windowsIDList = new ArrayList<String>(windowIDs);
		/*
		 * String parentWindowID = windowsIDList.get(0); // parent window ID String
		 * childWindowID = windowsIDList.get(1); // child window ID
		 * 
		 * System.out.println("Parent window ID:" + parentWindowID);
		 * System.out.println("Child window ID:" + childWindowID);
		 */

//How to usr window's ID for switching
		/*
		 * driver.switchTo().window(parentWindowID);
		 * System.out.println("Parent window title:" + driver.getTitle());
		 * driver.switchTo().window(childWindowID);
		 * System.out.println("Child window title:" + driver.getTitle());
		 */

//For each loop
		for(String winID : windowsIDList) {
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
		}
		
//How to close specific browser window
		for(String winID : windowsIDList) {
			String title = driver.switchTo().window(winID).getTitle();
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}

	}

}
