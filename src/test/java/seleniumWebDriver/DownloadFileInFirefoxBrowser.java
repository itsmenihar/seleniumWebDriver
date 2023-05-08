package seleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileInFirefoxBrowser {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "\\Downloads";
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("plugins.always_open_pdf_externally", true); //for pdf download
		fp.setPreference("pdfjs.disabled", true);
		fp.setPreference("browser.helpApps.neverAsk.saveToDisk", "application/pdf");
		fp.setPreference("browser.download.folderList", 2);
		fp.setPreference("browser.download.dir",location );
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fp);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://file-examples.com/");

	}

}
