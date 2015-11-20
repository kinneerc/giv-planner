package edu.allegheny.vanschedule;

public class Place {

    private String name;
    private String address;

    public Place(String name){
        this.name = name;
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

}
