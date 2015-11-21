package edu.allegheny.vanschedule;

public class Request {
	
private Time desiredArrival;
private Time desiredDeparture;
private Place site;

public Request(Place p, Time arrive, Time depart) {
	
	desiredArrival = arrive;
	desiredDeparture = depart;
	site = p;

}

/**
 * @return the desiredArrival
 */
public Time getDesiredArrival() {
	return desiredArrival;
}

/**
 * @param desiredArrival the desiredArrival to set
 */
public void setDesiredArrival(Time desiredArrival) {
	this.desiredArrival = desiredArrival;
}

/**
 * @return the desiredDeparture
 */
public Time getDesiredDeparture() {
	return desiredDeparture;
}

/**
 * @param desiredDeparture the desiredDeparture to set
 */
public void setDesiredDeparture(Time desiredDeparture) {
	this.desiredDeparture = desiredDeparture;
}

/**
 * @return the site
 */
public Place getSite() {
	return site;
}

/**
 * @param site the site to set
 */
public void setSite(Place site) {
	this.site = site;
}

public boolean satisfied(Route route) {
	// TODO Auto-generated method stub
	return false;
}

public int waitTime(Route route){
	// TODO Auto-gen
	return Integer.MAX_VALUE;
}

public int lateTime(Route route){
	// TODO Auto-gen
	return Integer.MAX_VALUE;
}


}
