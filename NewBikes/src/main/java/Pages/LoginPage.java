/*package Pages;

import org.openqa.selenium.By;

import Base.Base;

public class LoginPage extends Base {
	By lclose = By.id("alternate-login-close");
	By login = By.id("des_lIcon");
	By googleSignIn = By.xpath("(//span[text()='Continue with Google'])");
	By email = By.xpath("(//input[@type='email'])");
	By submit = By.xpath(
			"(//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b'])");
	By error = By.xpath("(//div[@class='o6cuMc'])");

	public void clickLogin() // Method to click Login
	{
		logger = report.createTest("Displaying used car");
		try {
			driver.findElement(login).click();
			Thread.sleep(5000);
			String login1 = "Login/Register to";
			String ver = driver.findElement(By.xpath(
					"//span[@class='hd fnt-20 fnt-black fnt-m rel i-b ml-10 lh-24 txt-l login-title headingText default']"))
					.getText();
			if (ver.contains(login1))
				reportPass("Used Cars in chennai are displayed");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void clickGoogleSignIn() throws InterruptedException // Method to click Login
	{
		logger = report.createTest("Error Checking after signup");
		driver.findElement(googleSignIn).click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		driver.findElement(email).sendKeys(" ");
		driver.findElement(submit).click();
		Thread.sleep(2000);
	}

	public void captureErrorMessage() // Method to capture error message
	{
		System.out.println("*******************************************************");
		System.out.println("              Error Obtained during Signup:");
		System.out.println("*******************************************************");
		String errorMessage = driver.findElement(error).getText();
		System.out.println("Error Message = " + errorMessage);
	}

}*/
package Pages;

import org.openqa.selenium.By;

import Base.Base;

public class LoginPage extends Base {
	By lclose = By.id("alternate-login-close");
	By login = By.id("des_lIcon");
	By googleSignIn = By.xpath("(//span[text()='Continue with Google'])");
	By email = By.xpath("(//input[@type='email'])");
	By submit = By.xpath(
			"//span[text()='Next']");
	By error = By.xpath("(//div[@class='o6cuMc'])");

	public void clickLogin() // Method to click Login
	{
		logger = report.createTest("Displaying used car");
		try {
			driver.findElement(login).click();
			Thread.sleep(5000);
			String login1 = "Login/Register to";
			String ver = driver.findElement(By.xpath(
					"//span[text()='Continue with Google']"))
					.getText();
			if (ver.contains(login1))
				reportPass("Used Cars in chennai are displayed");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void clickGoogleSignIn() throws InterruptedException // Method to click Login
	{
		logger = report.createTest("Error Checking after signup");
		driver.findElement(googleSignIn).click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		driver.findElement(email).sendKeys("Ironman@gml.com");
		driver.findElement(submit).click();
		Thread.sleep(2000);
	}

	public void captureErrorMessage() // Method to capture error message
	{
		System.out.println("*******************************************************");
		System.out.println("              Error Obtained during Signup:");
		System.out.println("*******************************************************");
		String errorMessage = driver.findElement(error).getText();
		System.out.println("Error Message = " + errorMessage);
	}

}

