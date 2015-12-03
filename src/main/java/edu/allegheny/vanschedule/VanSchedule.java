package edu.allegheny.vanschedule;
import java.util.*;
import java.util.ArrayList;
public class Scheduler {
    int i = 0;
    int b = 0;
    ArrayList<Request> requestList;
    int sizeList;
    int VANSEATS;
    int arrivalSize;
    Time aList = new Time();
    Time rList = new Time();
    ArrayList<Trip> tripList = new ArrayList<Trip>();


    public chedule(ArrayList<Request> RequestList){
        requestList = RequestList;
        VANSEATS = 6;
        sizeList = requestList.size();

    }
    //schedule class that will return a Route object, which will contain all the request objects for one van trip
    public ArrayList<Trip> arrivalSchedule(ArrayList<Request> arrivals){
        System.out.println("Creating a schedule for arrivals and departures!");
        ArrayList<Request> arrivalList = new ArrayList<Request>();  //use new array to sort the old one

        arrivalList.set(0, requestList.get(0));
        i = 1;
        while(i<sizeList){  //while arrivalList < requestlist
            arrivalSize = arrivalList.size();   //measure the size of the arrivalList
            b = 0;
            while(b < arrivalSize){   //go through all indexes of arrivalList if necessary
                aList = (arrivalList.get(b)).getDesiredArrival(); //
                rList = (requestList.get(i)).getDesiredArrival();
                if((aList.getDiff(rList)) >= 0){   //if the index's time is before the index being examined, add it to the list
                    b++;
                }if ((aList.getDiff(rList))<0){
                    arrivalList.add(b, requestList.get(i)); //set the current b list with the item from requestList
                    b = arrivalSize;
                }
            }i++;
        }
        //now we have a sorted arrivalList with the earliest desiredArrival times at the start of the list

        /*ARRIVAL SHUTTLE:
         * We are going to take the first x times while x < 5 and the times are within 30 minutes.
         * Those requests will then be processed for how what their stops are, and figure out the most efficient route.
         */

        i = 0;
        b = 0;
        int humans = 0;

        while (i < sizeList){ //while there are Requests
            Trip2 trip = new Trip2();
            trip.setDepartureTime((arrivalList.get(i)).getDesiredArrival());
            trip.addPerson((arrivalList.get(i)).getName());
            trip.addEmail((arrivalList.get(i)).getEmail());
            i++;
            while(humans <= VANSEATS){
                while(((trip.getDepartureTime()).getDiff((arrivalList.get(i)).getDesiredArrival())) <= 15){
                    trip.addPerson((arrivalList.get(i)).getName());
                    trip.addEmail((arrivalList.get(i)).getEmail());
                }
                humans++;
                i++;
            }
            humans = 0;
            tripList.add(trip);
        }
    }
}

