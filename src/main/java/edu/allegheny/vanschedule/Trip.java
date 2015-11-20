package edu.allegheny.vanschedule;

public class Trip {
	
	private Place start;
	private Place end;
	
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


}
