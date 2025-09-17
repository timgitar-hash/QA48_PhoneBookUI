package com.phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class BaseHelper {
	WebDriver driver;

	public BaseHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;


	}

	public void type(By locator, String text) {
		if (text != null) {

			click(locator);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public boolean isAlertDisplayed() {

		Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.alertIsPresent());
		if (alert == null) {
			return false;
		} else {
			driver.switchTo().alert();
			alert.accept();
			return true;
		}
	}

	public String takeScreenshot() {
		File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
		try {
			Files.copy(tmp.toPath(), screenshot.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return screenshot.getAbsolutePath();
	}
}
