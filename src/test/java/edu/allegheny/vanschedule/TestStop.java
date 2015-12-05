package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestStop {

    @Test
    public void testStop(){
      Place p = new Place("Here");
      Stop s = new Stop(p);

      assertEquals("Here",s.getName());

    }

    @Test
    public void testGetArrival(){
      Place p = new Place("Here");
      Stop s = new Stop(p);
      Time t = new Time(10,20);
      s.setArrival(t);

      Time actual = s.getArrival();

      assertEquals(actual.getHour(), t.getHour());
      assertEquals(actual.getMinute(), t.getMinute());
    }

    @Test
    public void testGetDeparture(){
      Place p = new Place("There");
      Stop s = new Stop(p);
      Time t = new Time(11,30);
      s.setDeparture(t);

      Time actual = s.getDeparture();

      assertEquals(actual.getHour(), t.getHour());
      assertEquals(actual.getMinute(), t.getMinute());
    }

    @Test
    public void testSetArrival(){
      Place p = new Place("Here");
      Stop s = new Stop(p);
      Time t = new Time(10,20);
      s.setArrival(t);

      Time actual = s.getArrival();

      assertEquals(actual.getHour(), t.getHour());
      assertEquals(actual.getMinute(), t.getMinute());
    }

    @Test
    public void testSetDeparture(){
      Place p = new Place("There");
      Stop s = new Stop(p);
      Time t = new Time(11,30);
      s.setDeparture(t);

      Time actual = s.getDeparture();

      assertEquals(actual.getHour(), t.getHour());
      assertEquals(actual.getMinute(), t.getMinute());
    }

    @Test
    public void testToString(){
      Place p = new Place("There");
      Stop s = new Stop(p);
      Time a = new Time(11,30);
      Time d = new Time(13,30);
      s.setArrival(a);
      s.setDeparture(d);

      Time arrival = s.getArrival();
      Time depart = s.getDeparture();

      /* Time actual = s.getDeparture(); */
      String expected = arrival +" "+ p.getName() +" "+ depart;

      assertEquals(expected, s.toString());
    }


}
