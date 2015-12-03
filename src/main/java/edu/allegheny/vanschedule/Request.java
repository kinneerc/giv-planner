package edu.allegheny.vanschedule;

public class Request {

private String name;
private String email;
private Time desiredArrival;
private Time desiredDeparture;
private Place site;


public Request(Place p, Time arrive, Time depart) {

	desiredArrival = arrive;
	desiredDeparture = depart;
	site = p;

}
public Request(Place p, Time arrive, Time depart, String n, String e){
    desiredArrival = arrive;
    desiredDeparture = depart;
    site = p;
    name = n;
    email = e;
}
public Request(){
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

/**@ginozab: Hey before I get too far, how are you formatting the time for the Re, is it 12 hr or 24 hr?
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
