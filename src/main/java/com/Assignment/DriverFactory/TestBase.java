package com.Assignment.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static WebDriver driver;
	
	public static WebDriver initDriver() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		return driver;
	}

}
