package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.util.ArrayList;

public class TripGrouping {
	
	/*
	 * @param Route
	 * @return void
	 * 
	 * This method takes in a route and separates 
	 * each trip by stops
	 * Then calls CreateCalendarEvent class with new 
	 * list of stops that are grouped by trip
	 */
	
	public static void groupStops(Route r) {
		
		List<Stop> s = r.getStops();
		
		int counter = 0;
		while(true) {
			// check to make sure we dont go out of bounds
			if (counter == s.size()) {
				break;
			} // if size
			
			else {
				// find each allegheny stop so we can make new trip list
				if (s.get(counter).getName().equals("Allegheny College")) {
					List<Stop> tripSingle = new ArrayList<Stop>();
					
					// put in each stop for a trip
					while(true) {
						// add stop to trip
						tripSingle.add(s.get(counter));
						//System.out.println(s.get(counter).getName());
						counter++;
						
						// check counter position
						if ((counter+1) == s.size()) {
							counter++;
							break;
						}
						
						// if we found another allegheny stop that means there is 
						// a new trip
						if (s.get(counter).getName().equals("Allegheny College")) {
							break;
						} // inner if next is allegheny college
						
					} // inner while
					
					System.out.println("\n\n");
					// call the createEvents() with each individual trip list
					CreateCalendarEvents.createEvents(tripSingle);
				} // if allegheny college
			} // else
				//System.out.println();
			
		} // while
		
	} // groupStops()
	
} // TripGrouping class
