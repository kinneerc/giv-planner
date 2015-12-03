package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.Request;

import java.util.List;
import java.util.Arrays;

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
		List<Request> monday = DailyRequestMaker.getDailyRequests(allDayReqs[0]);
		List<Request> tuesday = DailyRequestMaker.getDailyRequests(allDayReqs[1]);
		List<Request> wednesday = DailyRequestMaker.getDailyRequests(allDayReqs[2]);
		List<Request> thursday = DailyRequestMaker.getDailyRequests(allDayReqs[3]);
		List<Request> friday = DailyRequestMaker.getDailyRequests(allDayReqs[4]);

		// call backend

	} // makeDailyRequests

}