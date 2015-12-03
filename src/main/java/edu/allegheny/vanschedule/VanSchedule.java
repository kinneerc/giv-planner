package edu.allegheny.vanschedule;
import java.util.*;
import java.util.ArrayList;
public class VanSchedule {
    int i = 0;
    ArrayList<Request> requestList;
    int sizeList;
    int VANSEATS;

    public VanSchedule(ArrayList<Request> RequestList){
        requestList = RequestList;
        VANSEATS = 6;
        sizeList = requestList.size();
        //private int i = 0;

    }
    /*the first step we take is to get a new list in order, so the requests with the earliest
     * desiredArrival times are first.
     */
    public ArrayList schedule(){
        ArrayList<Request> arrivalList = new ArrayList<Request>();

        while(requestList.isEmpty() == false){
            arrivalList.set(i, requestList.get(i));
            i++;
        }
        i = 0;
        while(i < (sizeList-1)){
            if(((arrivalList.get(i)).getDesiredArrival()).getHour() > ((arrivalList.get(i+1)).getDesiredArrival()).getHour()){
                Request temp = requestList.get(i);
                requestList.set(i, requestList.get(i+1));
                requestList.set(i+1, temp);
            }i++;
        }
        //now we have a sorted arrivalList


        /*While we're at it, we're going to sort the desiredDeparture times too! */
        ArrayList<Request> departureList = requestList;
        i = 0;
        while(i < sizeList-1){
            if(((departureList.get(i)).getDesiredDeparture()).getHour() > ((departureList.get(i+1)).getDesiredDeparture()).getHour()){
                Request temp = requestList.get(i);
                requestList.set(i, requestList.get(i+1));//not using right array list
                requestList.set(i+1, temp);
            }i++;
        }

        /*ARRIVAL SHUTTLE:
         * We are going to take the first x times while x < 5 and the times are within 30 minutes.
         * Those requests will then be processed for how what their stops are, and figure out the most efficient route.
         */

        int startTime = ((arrivalList.get(0)).getDesiredArrival()).getMinute() + 30; //takes however many rides are within 30 minutes of each other to arrange shuttles.
        i = 0;
        int cap = 0;
        ArrayList<Request> trip1 = new ArrayList<Request>();
        ArrayList<Request> trip2 = new ArrayList<Request>();
            ArrayList<Request> trip3 = new ArrayList<Request>();
            while (i < sizeList-1){ //while there are Requests
                if (cap < 5){   //we want to get requests within 30 minutes of each other
                    /*what we do is check if the next one is within 30 minutes of the first
                     *we then need to continue this process while there is still room in the van (5 seats? Variable above)
                     *create as many van trips as necessary, store each set of requests in a trip as a Route object
                     */
                    trip1.add(arrivalList.get(i));
                    if (((arrivalList.get(i)).getDesiredArrival()).getDiff(((arrivalList.get(i+1)).getDesiredArrival())) < 30){
                        trip1.add(arrivalList.get(i+1));
                        i++;

                    }

                }
                i++;
            }
            return trip1;
        }
    }

