package edu.allegheny.vanschedule;

import java.util.List;
import java.util.ArrayList;

public class Route {
	
private List<Stop> stops;

public Route(){
	stops = new ArrayList<Stop>();
}

/**
 * @return the stops
 */
public List<Stop> getStops() {
	return stops;
}

/**
 * @param stops the stops to set
 */
public void setStops(List<Stop> stops) {
	this.stops = stops;
}

public void addStop(Stop stop){
	stops.add(stop);
}

}
