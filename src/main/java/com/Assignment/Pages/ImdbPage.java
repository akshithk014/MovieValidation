package com.Assignment.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Assignment.Utils.CommonUtil;

public class ImdbPage {
	static WebDriver driver;
	static CommonUtil commonUtils = new CommonUtil(driver);
	
	
	//By Locators
	 static By SearchBox = By.id("suggestion-search");
	 static By ImdbRelDate = By.xpath("//li[@data-testid='title-details-releasedate']/div");
	 static By ImdbCountry = By.xpath("//li[@data-testid='title-details-origin']/div");
	
	

	public ImdbPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchMovie(String movie) {
		driver.findElement(SearchBox).sendKeys(movie);
	}
	public void SelectMovieFromSearchDropdown(String movie) {
		//By SearchItem = By.xpath("//li[@id='react-autowhatever-1--item-0']/a//div[contains(text(),'"+movie+"')]");
		By SearchItem = By.xpath("//a[@data-testid='search-result--const']//div[contains(text(),'"+movie+"')]");
		commonUtils.waitUntilVisibility(5, SearchItem);
		driver.findElement(SearchItem).click();
	}
	public Date getReleaseDate() throws ParseException {
		commonUtils.waitUntilVisibility(5, ImdbRelDate);
		String RelDateStr = driver.findElement(ImdbRelDate).getText().split("\\(")[0].trim();
		SimpleDateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
		Date ReleaseDateIMDB = df.parse(RelDateStr);
		return ReleaseDateIMDB;
	}
	public String getCountry() {
		commonUtils.waitUntilVisibility(5, ImdbCountry);
		return driver.findElement(ImdbCountry).getText().toString();
	}
	
	

}
