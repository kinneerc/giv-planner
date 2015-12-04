package edu.allegheny.vanschedule;

public class Stop extends Place {

    private Time arrival;
    private Time departure;

    public Stop(Place p){
        super(p.getName());
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
    	
    	String address;
    	
    	if ((address = getAddress()) == null)
    		address = getName();
    	else 
    		address = getName() + " : " + address;
    	
    	
    	String ans = arrival + " " + address + " " + departure;
    	
		return ans;
    	
    }

}
