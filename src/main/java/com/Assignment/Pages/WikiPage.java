package com.Assignment.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Assignment.Utils.CommonUtil;

public class WikiPage {
	
	static WebDriver driver;
	static CommonUtil commonUtils = new CommonUtil(driver);
	
	//By Locators
	static By SearchBox = By.id("searchInput");
	static By WikiReleaseDate = By.xpath("//table[@class='infobox vevent']//div[contains(text(),'Release date')]/ancestor::tr/td");
	static By WikiCountry = By.xpath("//table[@class='infobox vevent']//th[contains(text(),'Country')]/parent::tr/td");
	
	public WikiPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchMovie(String movie) {
		driver.findElement(SearchBox).sendKeys(movie);
	}
	public void SelectMovieFromSearchDropdown(String movie) {
		By SearchItem = By.xpath("//*[@class='suggestions-results']/a[@title = '"+movie+"']");
		commonUtils.waitUntilVisibility(5, SearchItem);
		driver.findElement(SearchItem).click();
	}
	public Date getReleaseDate() throws ParseException {
		commonUtils.waitUntilVisibility(5, WikiReleaseDate);
		String RelDateStr = driver.findElement(WikiReleaseDate).getText();
		SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
		Date ReleaseDateWiki = df.parse(RelDateStr);
		return ReleaseDateWiki;
	}
	public String getCountry() {
		commonUtils.waitUntilVisibility(5, WikiCountry);
		return driver.findElement(WikiCountry).getText().toString();
	}

}
