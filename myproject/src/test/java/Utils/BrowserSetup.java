package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

	
	public static WebDriver getWebDriver(String Browser) {
		
	
		WebDriver driver = null;
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		if(Browser.equalsIgnoreCase("explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		return driver;
		
	}
	
	
}
