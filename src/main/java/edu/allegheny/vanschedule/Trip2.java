package edu.allegheny.vanschedule;
import java.util.ArrayList;

public class Trip2 extends Stop{
   Time time;
    String name;
    ArrayList<String> peopleList = new ArrayList<String>();
    String email;
    ArrayList<String> emailList = new ArrayList<String>();

    public Trip2(Place p){
        super(p);
    }

    public void setdepartureTime(Time t){
        time = t;
        int hour = time.getHour();
        int min = time.getMinute();
        if(min>= 15){
            min = min-15;
        }
        if(min< 15){
            hour = hour -1;
            min = min + 45; //adds an hour and subtracts 15 minutes
            time.setHour(hour);
            time.setMinute(min);
        }
    }

    public Time getDepartureTime(){
        return time;
    }

    public void addPerson(String n){
        name = n;
        peopleList.add(name);
    }
    public ArrayList<String> getPersonList(){
        return peopleList;
    }

    public void addEmail(String e){
        email = e;
        emailList.add(email);
    }

// arrival time at destinations
// destination

}
