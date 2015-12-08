package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import java.util.List;
import java.util.ArrayList;

public class TripGrouping {
	
	public static void groupStops(Route r) {
		
		List<Stop> s = r.getStops();
		
		int counter = 0;
		while(true) {
			
			if (counter == s.size()) {
				break;
			} // if size
			
			else {
				
				if (s.get(counter).getName().equals("Allegheny College")) {
					List<Stop> tripSingle = new ArrayList<Stop>();
					
					while(true) {
						tripSingle.add(s.get(counter));
						System.out.println(s.get(counter).getName());
						counter++;
						
						if ((counter+1) == s.size()) {
							counter++;
							break;
						}
						
						if (s.get(counter).getName().equals("Allegheny College")) {
							break;
						} // inner if next is allegheny college
						
					} // inner while
				} // if allegheny college
			} // else
				System.out.println();
			
		} // while
		
	} // groupStops()
	
} // TripGrouping class
