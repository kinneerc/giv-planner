package edu.allegheny.vanschedule.frontend;
import java.util.Arrays;

import edu.allegheny.vanschedule.*;



public class GetMonday {
	public static String[] findDate(String date, int weekday) {
		if (weekday != 2) {
			String[] dateArray = date.split("-");
			int monthDay = Integer.parseInt(dateArray[2]);
			int relativeDay = -(weekday-2);
			int endDay = monthDay+relativeDay;
			String endDayStr = "";
			
			if (endDay >= 10) {
				endDayStr = endDay + "";
			}
			else {
				endDayStr = "0" + endDay;
			}
			
			dateArray[2] = endDayStr;
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i < dateArray.length; i++) {
			   strBuilder.append( dateArray[i] );
			}
			String newString = strBuilder.toString();
			//System.out.println(newString);
			return dateArray;
		}
		
		else {
			return date.split("-");
		}
		
	}
	
	public static String[] getNextDay(String[] s, int d) {
		String[] nextDay = s;
		int day = Integer.parseInt(nextDay[2]);
		int targetDay = day + d;
		String StrDay = "";
		if (targetDay >= 10) {
			StrDay = "" + targetDay;
		}
		else {
			StrDay = "0" + targetDay;
		}
		
		nextDay[2] = StrDay;
		
		return nextDay;
	}
	
}
