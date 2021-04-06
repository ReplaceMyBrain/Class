package com.javalec.base;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		//Calendar
		
		Calendar calendar = Calendar.getInstance(); //new 안씀!
		
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH) +1 ;
		int day = calendar.get(calendar.DAY_OF_MONTH);
		
		int hour = calendar.get(calendar.HOUR_OF_DAY);
		int minute = calendar.get(calendar.MINUTE);
		int second = calendar.get(calendar.SECOND);
		
		System.out.println(year + ":" + month + ":" + day);
		System.out.println(hour + ":" + minute + ":" + second);
		
		
	

	}

}
