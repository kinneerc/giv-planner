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
public String getName(){
    return name;
}
public String getEmail(){
    return email;
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

private Stop findStop(Route route){
	for (Stop s : route.getStops()){
		if (s.getName().equals(site.getName())){
			return s;
		}
	}
	return null;
}

public boolean satisfied(Route route) {
	Stop s = findStop(route);
	if (s != null)
		return true;
	else
		return false;
}

public int waitTime(Route route){
	Stop s = findStop(route);
	int diff = -desiredArrival.getDiff(s.getArrival());
	if (diff >= 0)
		return diff;
	else
		return 0; 
}

public int lateTime(Route route){
	Stop s = findStop(route);
	int diff = desiredArrival.getDiff(s.getArrival());
	if (diff >= 0)
		return diff;
	else
		return 0; 
}


}
