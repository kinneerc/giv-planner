package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRequest {

    @Test
    public void testRequest(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);
      Request r = new Request(p,a,d,"Name","name@test.edu");

    }

    @Test
    public void testNextRequest(){
      Request r = new Request();

    }

    @Test
    public void testGetName(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

      Request r = new Request(p,a,d,"Name","name@test.edu");
      String actual = r.getName();
      assertEquals("Name", actual);

      r = new Request(p,a,d,"Name LastName","name@test.edu");
      actual = r.getName();
      assertEquals("Name LastName", actual);

    }

    @Test
    public void testGetEmail(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

      Request r = new Request(p,a,d,"Name","name@test.edu");
      String actual = r.getEmail();
      assertEquals("name@test.edu", actual);

      r = new Request(p,a,d,"Name","name_lastname@test.edu");
      actual = r.getEmail();
      assertEquals("name_lastname@test.edu", actual);

      r = new Request(p,a,d,"Name","name_lastname.morenames@test.edu");
      actual = r.getEmail();
      assertEquals("name_lastname.morenames@test.edu", actual);
    }

    @Test
    public void testGetDesiredArrival(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      Time actual = r.getDesiredArrival();

    	assertEquals(a.getHour(),actual.getHour());
      assertEquals(a.getMinute(),actual.getMinute());
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
      assertEquals(a.getMinute(),actual.getMinute());
    }

    @Test
    public void testGetDesiredDeparture(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

    	Request r = new Request(p,a,d);
      Time actual = r.getDesiredDeparture();

    	assertEquals(d.getHour(),actual.getHour());
      assertEquals(d.getMinute(),actual.getMinute());
    }

    @Test
    public void testSetDesiredDeparture(){
      Place p = new Place("2nd District");
      Time a = new Time(10,20);
      Time d = new Time(12,30);

      Request r = new Request(p,a,new Time(5,55));
      r.setDesiredDeparture(d);
      Time actual = r.getDesiredDeparture();

      assertEquals(d.getHour(),actual.getHour());
      assertEquals(d.getMinute(),actual.getMinute());
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
    
    @Test
    public void testSatisfied(){
    	 Place p = new Place("2nd District");
         Time a = new Time(10,20);
         Time d = new Time(12,30);

       	Request r = new Request(p,a,d);
       	Route route = new Route();
       	
       Stop s = new Stop(p);
       
       s.setArrival(a);
       s.setDeparture(d);
       
       route.addStop(s);
       
       assertEquals(true,r.satisfied(route));
       	
       	
    }
    
    @Test
    public void testWaitTime(){
    	Place p = new Place("2nd District");
        Time a = new Time(10,20);
        Time d = new Time(12,30);

      	Request r = new Request(p,a,d);
      	Route route = new Route();
      	
      Stop s = new Stop(p);
      
      s.setArrival(a);
      s.setDeparture(d);
      
      route.addStop(s);
      
      assertEquals(0,r.waitTime(route));
      
      s.setArrival(new Time(10,10));
      
      assertEquals(10,r.waitTime(route));
      
      s.setArrival(new Time(10,30));
      
      assertEquals(0,r.waitTime(route));
      
    }
    
    @Test
    public void testLateTime(){
    	Place p = new Place("2nd District");
        Time a = new Time(10,20);
        Time d = new Time(12,30);

      	Request r = new Request(p,a,d);
      	Route route = new Route();
      	
      Stop s = new Stop(p);
      
      s.setArrival(a);
      s.setDeparture(d);
      
      route.addStop(s);
      
      assertEquals(0,r.lateTime(route));
      
      s.setArrival(new Time(10,10));
      
      assertEquals(0,r.lateTime(route));
      
      s.setArrival(new Time(10,30));
      
      assertEquals(10,r.lateTime(route));
      
    }
}
