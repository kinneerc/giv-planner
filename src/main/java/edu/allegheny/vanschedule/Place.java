package edu.allegheny.vanschedule;

public class Place {

    protected String name;
    private String address;

    public Place(String name){
        this.name = name;
        this.address = name + ", Meadville PA";
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public static Place getAllegheny(){
    	return new Place("Allegheny College");
    }

}
