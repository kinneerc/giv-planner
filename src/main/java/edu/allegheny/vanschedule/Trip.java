package edu.allegheny.vanschedule;

import java.util.List;

public class Trip {
	
	private static List<Trip> allTrips;

	private Place start;
	private Place end;
	
	public double getTravelTime(){
	    return Double.MAX_VALUE;
    }

	public Trip(Place start, Place end){
		this.start = start;
		this.end = end;
	}
	
	/**
	 * @return the start
	 */
	public Place getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Place start) {
		this.start = start;
	}

	public static List<Trip> getTrips(){
	    return allTrips;
    }




}
