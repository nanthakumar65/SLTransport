package com.example.demo.Util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import com.example.demo.data.CountryData;

public class DateUtil {
	
	static DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy");
	
	static  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
	public static Date convertDateFormat(String inputDate) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(inputDate, inputFormatter);
		return Date.from(zonedDateTime.toInstant());
	}
	
	public static ArrayList<String> getAllCountry() {
		String[] countryCodes = Locale.getISOCountries();
        ArrayList<String> arrayList = new ArrayList<>();
        
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            arrayList.add(locale.getDisplayCountry());
        }
		return arrayList;
	}
}
