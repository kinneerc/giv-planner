package edu.allegheny.vanschedule;

public class VanSchedule {
    int VANSEATS = 5;
    List<Request> requestList = new ArrayList<Request>();
    //need to populate requestList

    int sizeList = requestList.size();
    int i = 0;
    /*the first step we take is to get a new list in order, so the requests with the earliest
     * desiredArrival times are first.
     */
    List<Request> arrivalList = requestList;
    while(i < sizeList-1){
        if(arrivalList[i].getDesiredArrival() > arrivalList[i++].getDesiredArrival()){
            Request temp = requestList[i];
            requestList[i] = requestList[i++];
            requestList[i++] = temp;
        }i++;
    }
    //now we have a sorted arrivalList


    /*While we're at it, we're going to sort the desiredDeparture times too! */
    List<Request> departureList = requestList;
    i = 0;
    while(i < sizeList-1){
        if(departureList[i].getDesiredDeparture() > departureList[i++].getDesiredDeparture()){
            Request temp = requestList[i];
            requestList[i] = requestList[i++];
            requestList[i++] = temp;
        }i++;
    }

    /*ARRIVAL SHUTTLE:
     * We are going to take the first x times while x < 5 and the times are within 30 minutes.
     * Those requests will then be processed for how what their stops are, and figure out the most efficient route.
     */

    int startTime = arrivalList[0].getDesiredArrival() + 30; //takes however many rides are within 30 minutes of each other to arrange shuttles.
    i = 1;
    while (i < sizeList-1){
        while (startTime > ){

        }
    }

}
