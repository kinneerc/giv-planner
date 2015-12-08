package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


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
		
		System.out.println(printDate());
		
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
		TripGrouping.groupStops(mondayRoute);
		TripGrouping.groupStops(tuesdayRoute);
		TripGrouping.groupStops(wednesdayRoute);
		TripGrouping.groupStops(thursdayRoute);
		TripGrouping.groupStops(fridayRoute);

	} // makeDailyRequests
	
	public static String printDate() {
	    Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	    return ft.format(date);
	}

}