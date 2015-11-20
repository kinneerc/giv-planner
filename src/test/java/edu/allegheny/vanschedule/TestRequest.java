package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRequest {

    @Test
    public void testGetDesiredArrival(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      Time actual = r.getDesiredArrival();

    	assertEquals(a.getHour(),actual.getHour());
      assertEquals(a.getMinuite(),actual.getMinuite());
    }

    @Test
    public void testSetDesiredArrival(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      r.setDesiredArrival(a);
      Time actual = r.getDesiredArrival();

    	assertEquals(a.getHour(),actual.getHour());
      assertEquals(a.getMinuite(),actual.getMinuite());
    }

    @Test
    public void testGetDesiredDeparture(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      Time actual = r.getDesiredDeparture();

    	assertEquals(d.getHour(),actual.getHour());
      assertEquals(d.getMinuite(),actual.getMinuite());
    }

    @Test
    public void testSetDesiredDeparture(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      r.setDesiredDeparture(d);
      Time actual = r.getDesiredArrival();

    	assertEquals(d.getHour(),actual.getHour());
      assertEquals(d.getMinuite(),actual.getMinuite());
    }

    @Test
    public void testGetSite(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      Place actual = r.getSite();

    	assertEquals(p.getName(),actual.getName());
    }

    @Test
    public void testSetSite(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      r.setSite(p);
      Place actual = r.getSite();

    	assertEquals(p.getName(),actual.getName());
    }
}
