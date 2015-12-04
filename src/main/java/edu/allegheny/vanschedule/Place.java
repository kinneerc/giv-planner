package edu.allegheny.vanschedule;

import com.google.maps.model.PlacesSearchResult;

import edu.allegheny.vanschedule.frontend.GoogleMaps;

public class Place {

	private static GoogleMaps gmaps = new GoogleMaps();
	
	public static final Place ALLEGHENY = new Place("Allegheny College"); 
	
    protected String name;
    protected PlacesSearchResult psr;

    public Place(String name){
        this.name = name;
        psr = gmaps.getPlace(name + ", Meadville PA");
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return psr.formattedAddress;
    }
    
    public static Place getAllegheny(){
    	return ALLEGHENY;
    }

}
