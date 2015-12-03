package edu.allegheny.vanschedule;

import java.util.List;

public class Trip {

	private Place start;
	private Place end;
	private double travelTime;
	
	/**
	 * get the time needed to make this trip
	 * @return travelTime in minutes
	 */
	public double getTravelTime(){
	    return Double.MAX_VALUE;
    }

	public Trip(Place start, Place end, double travelTime){
		this.start = start;
		this.end = end;
		this.travelTime = travelTime;
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




}
