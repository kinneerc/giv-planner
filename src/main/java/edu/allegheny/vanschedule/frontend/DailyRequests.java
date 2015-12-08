package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/*
* @author Brandon Ginoza
*
* DailyRequest
*
* Make a list of requests for each day.
* Call backend.
 */

public class DailyRequests {

	/*
	* makeDailyRequests
	* 
	* @param String[][][] 
	*
	* Create lists of Request objects for each day
	* Then call backend
	 */

	public static void makeDailyRequests(String[][][] allDayReqs) {
			
		// make a list of requests for each day of the week
		ArrayList<Request> monday = DailyRequestMaker.getDailyRequests(allDayReqs[0]);
		ArrayList<Request> tuesday = DailyRequestMaker.getDailyRequests(allDayReqs[1]);
		ArrayList<Request> wednesday = DailyRequestMaker.getDailyRequests(allDayReqs[2]);
		ArrayList<Request> thursday = DailyRequestMaker.getDailyRequests(allDayReqs[3]);
		ArrayList<Request> friday = DailyRequestMaker.getDailyRequests(allDayReqs[4]);

		// call backend for each day of the week
		// it will return a route
		Route mondayRoute = CodysScheduler.schedule(monday);
		Route tuesdayRoute = CodysScheduler.schedule(tuesday);
		Route wednesdayRoute = CodysScheduler.schedule(wednesday);
		Route thursdayRoute = CodysScheduler.schedule(thursday);
		Route fridayRoute = CodysScheduler.schedule(friday);

		// call the remaining front end code
		// this will add calendar events for each day route
		
		String date = printDate();
		int day = getDay();

		String[] mondayDate = GetMonday.findDate(date,day);
		TripGrouping.groupStops(mondayRoute,mondayDate);
		String[] tuesdayDate = GetMonday.getNextDay(mondayDate,1);
		TripGrouping.groupStops(tuesdayRoute,tuesdayDate);
		String[] wednesdayDate = GetMonday.getNextDay(mondayDate,1);
		TripGrouping.groupStops(wednesdayRoute,wednesdayDate);
		String[] thursdayDate = GetMonday.getNextDay(mondayDate,1);
		TripGrouping.groupStops(thursdayRoute,thursdayDate);
		String[] fridayDate = GetMonday.getNextDay(mondayDate,1);
		TripGrouping.groupStops(fridayRoute,fridayDate);

	} // makeDailyRequests
	
	/*
	 * @return int
	 * 
	 * Gets day of the week in int form
	 */
	
	public static int getDay() {
	    Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
	/*
	 * @return String
	 * 
	 * Method to get string date format
	 */
	
	public static String printDate() {
	    Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	    return ft.format(date);
	}

}