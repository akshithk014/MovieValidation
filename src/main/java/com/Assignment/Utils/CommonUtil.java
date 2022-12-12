package com.Assignment.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {
	static WebDriver driver;

	public CommonUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void waitUntilVisibility(int timeInSeconds,By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}

}
