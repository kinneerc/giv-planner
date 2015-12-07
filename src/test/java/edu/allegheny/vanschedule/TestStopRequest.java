package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class TestStopRequest {
    @Test
    public void testStopRequests(){
      Place p = new Place("Here");
      Time t = new Time(10,55);
      StopRequest sr = new StopRequest(p,t);
    }

    @Test
    public void testGetStopRequests(){
      Place p = new Place("Here");
      Time a = new Time(10,55);
      Time d = new Time(11,30);

      Time t = new Time(10,55);
      StopRequest sr = new StopRequest(p,t);

      Request r = new Request(p,a,d);
      List<StopRequest> actual = sr.getStopRequests(r);

      StopRequest sOne = new StopRequest(r.getSite(),r.getDesiredArrival());
      StopRequest sTwo = new StopRequest(r.getSite(),r.getDesiredDeparture());

      List<StopRequest> expected = Arrays.asList(sOne,sTwo);

      boolean testEq = actual.equals(expected);

      assertEquals(true, testEq);

    }

    /* @Test */
    /* public void testToStop(){ */
    /*   Place p = new Place("Here"); */
    /*   Time t = new Time(10,55); */
    /*   StopRequest sr = new StopRequest(p,t); */
    /*  */
    /*   Stop expected = new Stop(p); */
    /*   expected.setArrival(Time.addMinutes(desiredTime,-2)); */
    /*   expected.setDeparture(Time.addMinutes(desiredTime,2)); */
    /*  */
    /*   Stop actual = sr.toStop(); */
    /*  */
    /* } */

    @Test
    public void testCompareTo(){
    }

    @Test
    public void testGetSite(){
    }

    @Test
    public void testSetSite(){
    }

    @Test
    public void testGetDesiredTime(){
    }

    @Test
    public void testSetDesiredTime(){
    }

    @Test
    public void testIsCanBeEarly(){
    }

    @Test
    public void testSetCanBeEarly(){
    }

    @Test
    public void testIsCanBeLate(){
    }

    @Test
    public void testSetCanBeLate(){
    }

}
