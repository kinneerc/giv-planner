package edu.allegheny.vanschedule.frontend;


import com.google.maps.*;
import com.google.maps.model.*;

/**
 * This class is in charge of getting time information from google maps for the stops that we want
 * @author Cody Kinneer
 */
public class GoogleMaps {

    private static String apiKey = "AIzaSyBiplH2PqwslW7IPn9eaWPOftwIJnJgMuM";

    private GeoApiContext context;

    public GoogleMaps(){
        context = new GeoApiContext().setApiKey(apiKey);
    }

    public DistanceMatrixApiRequest callGMaps(String[] origins, String[] destinations){
        return DistanceMatrixApi.getDistanceMatrix(context, origins, destinations); 
    }
    
    // testing purposes only
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

}
