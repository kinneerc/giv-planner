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
		List<StopRequest> sreqs = getStopRequests(reqs);
		
		// now sort by the desired time
		Collections.sort(sreqs);	
		
		// now convert the requested stops to a route
		return toRoute(sreqs);
		
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
