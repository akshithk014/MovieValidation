package com.Assignment.Tests;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Assignemnt.config.ConfigReader;
import com.Assignment.DriverFactory.TestBase;
import com.Assignment.Pages.*;
import com.Assignment.Utils.CommonUtil;
import com.Assignment.Utils.Movie;

import java.text.ParseException;

public class MovieInfoTest {
	
	static WebDriver driver;
	static ImdbPage imdb;
	static WikiPage wiki;
	static CommonUtil commonUtil;
	static ConfigReader readConfig;
	
	
	@BeforeTest
	public static void BeforeTest() {
		driver = TestBase.initDriver();
		imdb = new ImdbPage(driver);
		wiki = new WikiPage(driver);	
		commonUtil = new CommonUtil(driver);
		readConfig = new ConfigReader();
	}
	@Test(priority = 1)
	public static void ValidateMovieInfo() throws ParseException {
		String movie = "Pushpa: The Rise";
		String movie2 = "K.G.F: Chapter 1";
		//Get Movie info From IMDB
		commonUtil.getUrl(readConfig.getConfigData().getProperty("url1"));
		imdb.searchMovie(movie);
		imdb.SelectMovieFromSearchDropdown(movie);
		Date ImdbRelase = imdb.getReleaseDate();
		String ImdbCountry = imdb.getCountry();
		//Get Movie info From WIKI
		commonUtil.openNewTab();
		commonUtil.getUrl(readConfig.getConfigData().getProperty("url2"));
		wiki.searchMovie(movie);
		wiki.SelectMovieFromSearchDropdown(movie);
		Date WikibRelase = wiki.getReleaseDate();
		String WikiCountry = wiki.getCountry();
		//Assert.assertTrue(ImdbCountry.equals(WikiCountry) && ImdbRelase.equals(WikibRelase), "\nIMDB Movie Info:\nRelease Date: "+ImdbRelase+"\nCountry: "+ImdbCountry+"\nWIKI Movie Info:\nRelease Date: "+WikibRelase+"\nCountry: "+WikiCountry+"\n");
		Assert.assertEquals(ImdbRelase, WikibRelase);
		Assert.assertEquals(ImdbCountry, WikiCountry);
	}
	@AfterTest
	public static void AfterTest() {
		driver.quit();
	}

}
