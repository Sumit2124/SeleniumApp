package Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import Driver.Driver_setup;
import utils.ExtentReportManager;

public class Base {
	
	public static WebDriver driver;

	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	String URL = "https://www.zigwheels.com/";

	
	@BeforeClass
	@Parameters("Browser")
	public void driverSetup(String Browser) {
			// Intializing ChromeDriver
				if (Browser.equals("Chrome")) {
					driver = Driver_setup.getChromeWebDriver();
					System.out.println("Chrome Driver Started");

				} else {
					// Intializing Firefox Driver
					driver = Driver_setup.getFirefoxWebDriver();
					System.out.println("Firefox Driver Started in headless mode");

				}				
		driver.manage().window().maximize(); // To maximize the window
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // Waiting time to page the load completely
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // Adding driver waits to timeouts

	}

	public void openUrl() // Method to open URL for smoke test
	{
		logger = report.createTest("Opening Url");
		try {
			driver.manage().window().maximize(); // To maximize the window

			driver.get(URL);
			reportPass("URL opened");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
		takeScreenShotOnFailure();
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	public void Screenshoot(String fileName) throws IOException {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/Screenshot/" + fileName + ".png");
		Files.copy(srcFile, destFile);
	}

	// To take Screenshot when test gets failed
	public void takeScreenShotOnFailure() {

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshot/FailedCases/Screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshot/FailedCases/Screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeBrowser() // method to close the browser
	{
		driver.quit(); // To close the browser
		report.flush(); // To save the reports
		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
		} catch (Exception e) {
		}
	}
}
