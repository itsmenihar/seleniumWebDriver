package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

//1:-Counting the number of rows 
		int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("Number of rows present in the table is: " + row);

//2:-Counting the number of columns
		int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		System.out.println("Number of columns present in the table is: " + col);

//3:-Retrieve the specific row/column data
		/*
		 * String companyName =
		 * driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[5]/td[1]")).
		 * getText(); System.out.println("Name of the company is: " + companyName);
		 */

//4:-Retrieve all the data from the table
		/*
		 * for (int r = 2; r <= row; r++) { for (int c = 1; c <= col; c++) { String data
		 * = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + r +
		 * "]/td[" + c + "]")) .getText(); System.out.print(data + "      "); }
		 * System.out.println(); }
		 */

//5:-Retrieve stable version and release data of Java row
		for (int r = 2; r <= row; r++) {
			String company = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + r + "]/td[1]"))
					.getText();
			if (company.equals("Centro comercial Moctezuma")) {
				String contact = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + r + "]/td[2]"))
						.getText();
				String country = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + r + "]/td[3]"))
						.getText();
				System.out.println(company + "   " + contact + "   " + country);

			}
		}
		driver.quit();

	}

}
