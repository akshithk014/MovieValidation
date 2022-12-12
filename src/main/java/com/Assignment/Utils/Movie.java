package com.Assignment.Utils;

import java.util.Date;

public class Movie {
	
	Date ReleaseDate;
	String Country;
	
	public Movie(Date ReleaseDate, String Country){
		this.ReleaseDate = ReleaseDate;
		this.Country = Country;
	}
	
	public void setReleaseDate(Date date) {
		ReleaseDate = date;
	}
	public void setCountry(String con) {
		Country = con;
	}
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	
	public String getCountry() {
		return Country;
	}

}
