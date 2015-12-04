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
	public static ArrayList<Request> getDailyRequests(String[][] requests) {

		ArrayList<Request> reqs = new ArrayList<Request>();

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
		Time arrive = Time.parse(info[7]);
		Time depart = Time.parse(info[8]);
		Place site = new Place(info[4]);
		Request request = new Request(site,arrive,depart,name,email);

		return request;

	} // makeRequest

} // DailyRequestMaker









