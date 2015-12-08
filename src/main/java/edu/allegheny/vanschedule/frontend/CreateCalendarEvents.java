package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

public class CreateCalendarEvents {
	/*
	 * @param List<Stops>
	 * @return void
	 * 
	 * This method takes in list calls other functions 
	 * to make summary, arrival time and depart time
	 * Then calls googlecalendarapi
	 */
	public static void createEvents(List<Stop> s) {
		String summary = makeSummary(s);
		//System.out.println(summary);
		String location = getLocation(s);
		//System.out.println("Location: " + location);
		String[] arrival = arrivalTime(s);
		//System.out.println(arrival[0] + " " + arrival[1]);
		String[] depart = departTime(s);
		//System.out.println(depart[0] + " " + depart[1]);
		
		try {
			GoogleCalendar.addToCalendar(summary,location,arrival,depart);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * @param List<Stops>
	 * @return String
	 * 
	 * This method creates the summary for an event
	 */
	
	public static String makeSummary(List<Stop> s) {
		StringBuilder sb = new StringBuilder();
		String sum = "";
		
		// for each stop
		for (int i = 1; i < s.size(); i++) {
			// add the destination
			sb.append(s.get(i).getArrival().toString() + " " + s.get(i).getName() + ": ");
			// for each person in that stop
			for (int j = 0; j < s.get(i).getPeople().size(); j++) {
				// add the persons name
				// if statements to get correct "," format
				if (j < s.get(i).getPeople().size()-1) {
					sb.append(s.get(i).getPeople().get(j) + ", ");
				}
				else {
					sb.append(s.get(i).getPeople().get(j) + " -- ");
				} // else
			} // inner for
			sb.append("\n");
		} // outer for
		
		// return summary
		return sb.toString();
	}// makeSummary()
	
	/*
	 * @param List<Stop>
	 * @return String[]
	 * 
	 * This method creates the beginning time for event
	 */
	
	public static String[] arrivalTime(List<Stop> s) {
		Stop first = s.get(0);
		Time begin = first.getDeparture();
		String[] timeSplit = begin.toString().split(":");
		return timeSplit;
	}
	
	/*
	 * @param List<Stop>
	 * @return String[]
	 * 
	 * This method creates the end time for an event
	 */
	
	public static String[] departTime(List<Stop> s) {
		Stop last = s.get(s.size()-1);
		Time end = last.getDeparture();
		String[] endTimeSplit = end.toString().split(":");
		return endTimeSplit;
	}
	/*
	 * @param List<Stop>
	 * @return String
	 * 
	 * This gets the location of the first stop in the list
	 */
	
	public static String getLocation(List<Stop> s) {
		return s.get(1).getName();
	}
}
