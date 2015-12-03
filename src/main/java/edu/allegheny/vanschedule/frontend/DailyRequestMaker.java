package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/*
* @author Brandon Ginoza
*
* DailyRequestMaker
*
* Create a list of Requests for a day
 */

public class DailyRequestMaker {

	/*
	* getDailyRequest()
	* 
	* @param String[][]
	* @return List<Request>
	*
	* Take in an array of all the ride requests for a day.
	* Then turn each of those array items into Request objects.
	* Put them all into a list.
	 */
	public static List<Request> getDailyRequests(String[][] requests) {

		List<Request> reqs = new ArrayList<Request>();

		// loop through each of the request in the array and make them into
		// Request objects
		for (int i = 0; i < requests.length; i++) {
			Request req = makeRequest(requests[i]);
			reqs.add(req);
		}

		return reqs;

	} // getDailyRequests

	/*
	* makeRequest()
	* 
	* @param String[]
	* @return Request
	*
	* Take in the information of the ride request in String array format.
	* Create a new Request.
	 */

	public static Request makeRequest(String[] info) {
		
		//need to make the times and place into objects
		String name = info[1];
		String email = info[2];
		Time arrive = parseTime(info[7]);
		Time depart = parseTime(info[8]);
		Place site = new Place(info[4]);
		Request request = new Request(site,arrive,depart,name,email);

		return request;

	} // makeRequest

	/*
	* parseTime()
	* 
	* @param String
	* @return Time
	*
	* Take a string representation of a time. 
	* Return it as a Time object.
	 */
	
	public static Time parseTime(String t) {
		String[] initial = t.split("\\s+");
		String[] hourMinute = initial[0].split(":");
		Time tempTime;

		// check if null
		// if so return -1,-1
		if (t.equals("")) {
			tempTime = new Time(-1,-1);
			return tempTime;
		}

		// if it is not null
		else {
				// if it is am do not add 12 to time
				if (initial[1].equals("AM")) {
					if (hourMinute[0].equals("12")) {
						int hourAM = 0;
						int minuteAM = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hourAM,minuteAM);
					} // inner if
					else {
						int hour = Integer.parseInt(hourMinute[0]);
						int minute = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hour,minute);
					} // inner else
				} // inner if

				// if pm add 12 to time
				else {
					if (hourMinute[0].equals("12")) {
						int hourPMT = Integer.parseInt(hourMinute[0]);
						int minutePMT = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hourPMT,minutePMT);
					} // inner if
					else {
						int hourPM = Integer.parseInt(hourMinute[0]);
						int minutePM = Integer.parseInt(hourMinute[1]);
						hourPM = hourPM + 12;
						tempTime = new Time(hourPM,minutePM);
					} // inner else
				} // inner else
			} // big else (not null)
			return tempTime;
		
	} // parseTime

} // DailyRequestMaker









