package edu.allegheny.vanschedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.allegheny.vanschedule.frontend.GoogleMaps;

public class CodysScheduler {

	static Place allegheny = Place.getAllegheny();
	
	static GoogleMaps map;
	
	public static Route schedule(List<Request> reqs){
		
		// chart map
		try {
			initializeMap(reqs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// break requests down into the requested stops
		// TODO SJ, modify StopRequest to hold info Brandon needs
		List<StopRequest> sreqs = getStopRequests(reqs);
		
		// now sort by the desired time
		Collections.sort(sreqs);	
		
		// go through the stops, and check for
		// when the bus can come back to gheny
		backTrips(sreqs);
		
		// remove redundant stops ina trip
		// TODO, enforce max 6 people limit
		removeStops(sreqs);
		
		// TODO SJ optional
		fixSamePlaceSameTime(sreqs);
		
		// TODO fix allegheny college departure times
		
		
		// now convert the requested stops to a route
		return toRoute(sreqs);
		
		
	}
	
	

	private static void fixSamePlaceSameTime(List<StopRequest> sreqs) {
		// TODO SJs method
		
	}



	private static void removeStops(List<StopRequest> sreqs) {
		
		StopRequest at;
		
		ArrayList<String> visited = new ArrayList<String>();
		
		for(int count = 0; count < sreqs.size()-1; count++){
			
			// we are at this place
			at = sreqs.get(count);
			
			// it back at gheny, reset
			if (at.getSite().name.equals(allegheny.name)){
				visited = new ArrayList<String>();
				continue;
			}
			
			// if we've already been here this trip, dont go here again
			if (visited.contains(at.getSite().name)){
				sreqs.remove(count);
				count--;
			}else{
				visited.add(at.getSite().name);
			}
			
		}
		
	}



	private static void backTrips(List<StopRequest> sreqs) {
		
		final int BACK_TIME = 15; 
		
		StopRequest at; 
		
		// iterate through stops
		for(int count = 0; count < sreqs.size()-1; count++){
			// we are at this place
			at = sreqs.get(count);
			// consider if we have time to back to gheny 
			// and still arrive at the next stop
			
			StopRequest next = sreqs.get(count+1);
			
			// figure out how much time we have between stops
			int time = at.getDesiredTime().getDiff(next.getDesiredTime());

			// enough time for back trip?
			if (time >= BACK_TIME*2){
				// if there is enough time to go back, then do it
				Time bt = Time.addMinutes(at.getDesiredTime(),BACK_TIME);
				StopRequest back = new StopRequest(allegheny,bt);
				// add to the list
				sreqs.add(count+1,back);
				count++;
			}
			
			/*
			// skip to the next stop if the next stop is allegheny
			if (next.getSite().name.equals(allegheny.name)){
				count++;
				continue;
			}
			*/
			
			
		}
		
	}



	private static Route toRoute(List<StopRequest> sreqs) {
		
		Route r = new Route();
		
		try {
			addAlleghenyStartEnd(sreqs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (StopRequest sr : sreqs){
			
			// TODO SJ, add brandons info here
			r.addStop(sr.toStop());
			
		}
		
		return r;
	}



	private static void addAlleghenyStartEnd(List<StopRequest> sreqs) throws Exception {
		
		// ask google how long to go from alleghey to the first stop
		double ttime = map.getTravelTimeDir(allegheny, sreqs.get(0).getSite());
		
		// clone time of first stop for the new allegheny first stop
		Time ft = sreqs.get(0).getDesiredTime().clone();// clone time of first stop for the new allegheny first stop
		
		// leave gheny to arrive at first stop just on time
		ft.addMinutes((int) -ttime);
		
		// create the stop request
		StopRequest f = new StopRequest(allegheny,ft);
		// add to list
		sreqs.add(0,f);
		
		// now do the same for the end of the list
		// ask google how long to go from last stop to gheny
		double ltime = map.getTravelTimeDir(sreqs.get(sreqs.size()-1).getSite(),allegheny);
		
		// clone time of first stop for the new allegheny first stop
		Time lt = sreqs.get(sreqs.size()-1).getDesiredTime().clone();
		
		lt.addMinutes((int) ltime);
		
		StopRequest l = new StopRequest(allegheny, lt);
		sreqs.add(l);
		
	}



	private static void initializeMap(List<Request> reqs) throws Exception {
		/*
		ArrayList<Place> places = new ArrayList<Place>();
		
		// add Allegheny college to the list of places
		places.add(allegheny);
		
		for (Request r : reqs)
			places.add(r.getSite());
		
		
		map = new GoogleMaps(places);
		*/
		
		map = new GoogleMaps();
		
		// TODO Auto-generated method stub
		
	}

	private static List<StopRequest> getStopRequests(List<Request> reqs) {
		
		ArrayList<StopRequest> ans = new ArrayList<StopRequest>();
		for (Request r : reqs){
			ans.addAll(StopRequest.getStopRequests(r));
		}
		
		return ans;
	}

}
