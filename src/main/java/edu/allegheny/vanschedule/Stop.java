package edu.allegheny.vanschedule;

import java.util.ArrayList;
import java.util.List;

public class Stop extends Place {

    private Time arrival;
    private Time departure;
    
    private List<String> people;
    private List<String> emails;

    public List<String> getPeople() {
		return people;
	}

	public void setPeople(List<String> people) {
		this.people = people;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Stop(Place p){
        super(p.getName());
        this.emails = new ArrayList<String>();
        this.people = new ArrayList<String>();
    }

    public void setArrival(Time arrival){
        this.arrival = arrival;
    }

    public void setDeparture(Time departure){
        this.departure = departure;
    }

    public Time getArrival(){
        return arrival;
    }

    public Time getDeparture(){
        return departure;
    }
    
    @Override
    public String toString(){
    	
    	String ans = arrival + " " + getName() + " " + departure;
    	
		return ans;
    	
    }

}
