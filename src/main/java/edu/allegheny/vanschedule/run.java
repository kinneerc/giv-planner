package edu.allegheny.vanschedule;
import java.util.ArrayList;
public class run{
    public static void main(String[]args){
        ArrayList<Request> listofRequests = new ArrayList<Request>();
        Request a = new Request();
        Request b = new Request();
        Request c = new Request();
        Time time1 = new Time(10,05);
        Time time2 = new Time(12,10);
        Time time3 = new Time(12,15);
        a.setDesiredArrival(time1);
        a.setDesiredDeparture(time2);
        b.setDesiredArrival(time1);
        b.setDesiredDeparture(time3);
        c.setDesiredArrival(time1);
        c.setDesiredDeparture(time1);
        listofRequests.add(a);
        listofRequests.add(b);
        listofRequests.add(c);
        VanSchedule vanSchedule = new VanSchedule(listofRequests);
        vanSchedule.schedule();
    }

}
