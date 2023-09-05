package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_setup {
	private static WebDriver driver;

	public static WebDriver getChromeWebDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

	public static WebDriver getFirefoxWebDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}

}
