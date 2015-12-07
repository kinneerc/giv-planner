package edu.allegheny.vanschedule;

import java.util.*;

public class StopRequest implements Comparable<StopRequest> {
	
	private Place site;
	private Time desiredTime;
	private boolean canBeEarly;
	
	private List<String> people;
	private List<String> emails;
	
private boolean canBeLate;
	
	public List<String> getPeople() {
	return people;
}

public void setPeople(List<String> people) {
	this.people = new ArrayList<String>(people);
}

public List<String> getEmails() {
	return emails;
}

public void setEmails(List<String> emails) {
	this.emails = new ArrayList<String>(emails);
}

	public StopRequest(Place p, Time t){
		this.site = p;
		this.desiredTime = t;
		this.emails = new ArrayList<String>();
		this.people = new ArrayList<String>();
	}
	
	public static List<StopRequest> getStopRequests(Request r){
		
		StopRequest a = new StopRequest(r.getSite(),r.getDesiredArrival());
		a.canBeEarly = true;
		a.setPeople(Arrays.asList(r.getName()));
		a.setEmails(Arrays.asList(r.getEmail()));
		
		StopRequest d = new StopRequest(r.getSite(), r.getDesiredDeparture());
		d.canBeLate = true;
		d.setPeople(Arrays.asList(r.getName()));
		d.setEmails(Arrays.asList(r.getEmail()));
		
		return Arrays.asList(a,d);
	}
	
	public Stop toStop(){
		Stop s = new Stop(site);
		
		s.setArrival(Time.addMinutes(desiredTime,-2));
		s.setDeparture(Time.addMinutes(desiredTime,2));
		s.setEmails(emails);
		s.setPeople(people);
		
		return s;
	}

	@Override
	public int compareTo(StopRequest o) {
		// TODO Auto-generated method stub
		return o.desiredTime.getDiff(desiredTime);
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

	/**
	 * @return the desiredTime
	 */
	public Time getDesiredTime() {
		return desiredTime;
	}

	/**
	 * @param desiredTime the desiredTime to set
	 */
	public void setDesiredTime(Time desiredTime) {
		this.desiredTime = desiredTime;
	}

	/**
	 * @return the canBeEarly
	 */
	public boolean isCanBeEarly() {
		return canBeEarly;
	}

	/**
	 * @param canBeEarly the canBeEarly to set
	 */
	public void setCanBeEarly(boolean canBeEarly) {
		this.canBeEarly = canBeEarly;
	}

	/**
	 * @return the canBeLate
	 */
	public boolean isCanBeLate() {
		return canBeLate;
	}

	/**
	 * @param canBeLate the canBeLate to set
	 */
	public void setCanBeLate(boolean canBeLate) {
		this.canBeLate = canBeLate;
	}


}
