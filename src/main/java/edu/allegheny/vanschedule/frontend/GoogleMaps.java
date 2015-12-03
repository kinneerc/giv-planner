package edu.allegheny.vanschedule.frontend;


import java.util.List;

import com.google.maps.*;
import com.google.maps.model.*;

import edu.allegheny.vanschedule.Place;

/**
 * This class is in charge of getting time information from google maps for the stops that we want
 * @author Cody Kinneer
 */
public class GoogleMaps {

    private static String apiKey = "AIzaSyBiplH2PqwslW7IPn9eaWPOftwIJnJgMuM";

    private GeoApiContext context;
    
    private List<Place> places;
    
    private DistanceMatrix ans;

    public GoogleMaps(List<Place> places) throws Exception{
        context = new GeoApiContext().setApiKey(apiKey);
        this.places = places;
        
        ans = callGMaps(getPlaceList());
        
    }
    
    /**
     * Get the travel time between two places
     * @param source Place
     * @param dest Place
     * @return the number of minutes to travel from source to dest
     */
    public double getTravelTime(Place source, Place dest){
    	
    	int sourceI = places.indexOf(source);
    	int destI = places.indexOf(dest);
    	
    	DistanceMatrixRow[] rows =  ans.rows;
    	
    	DistanceMatrixRow t = rows[sourceI];
    	
    	DistanceMatrixElement e = t.elements[destI];
    	
    	return e.duration.inSeconds / 60.0;
    	
    }

    private String[] getPlaceList(){
    	
    	String[] placeString = new String[places.size()];
    	
    	for(int i = 0; i < places.size(); i++){
    		placeString[i] = places.get(i).getName() + ", Meadville PA";
    	}
    	
		return placeString;
 
    }
    
    public DistanceMatrix callGMaps(String[] origins) throws Exception{
        return DistanceMatrixApi.getDistanceMatrix(context, origins, origins).await(); 
    }
    
    // testing purposes only
    /*
    public static void main(String[] args){
    	GoogleMaps gm = new GoogleMaps();
    	DistanceMatrixApiRequest req = gm.callGMaps(new String[] {"Allegheny College, Meadville PA"},new String[] {"Super S Buffet, Erie PA"});
    	try {
			DistanceMatrix ans = req.await();
			System.out.println(ans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
    */

}
