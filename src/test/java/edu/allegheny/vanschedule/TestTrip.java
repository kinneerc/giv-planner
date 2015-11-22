package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTrip {

    @Test
    public void testGetStart(){
      Place s = new Place("Here");
      Place e = new Place("There");
      Trip t = new Trip(s,e);

      Place actual = t.getStart();

      assertEquals(s.getName(), actual.getName());

    }

    @Test
    public void testSetStart(){
      Place s = new Place("Here");
      Place e = new Place("There");
      Trip t = new Trip(s,e);

      t.setStart(s);
      Place actual = t.getStart();

      assertEquals(s.getName(), actual.getName());

    }
}
