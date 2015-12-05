package edu.allegheny.vanschedule;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestRoute {

    @Test
    public void testRoute(){
    }

    @Test
    public void testOtherRoute(){
      Place p = new Place("Here");
      Trip2 t = new Trip2(p);
      List<Trip2> l = new ArrayList<Trip2>();
      Route r = new Route(l);

    }

    @Test
    public void testSetStops(){
      List<Stop> l = new ArrayList<Stop>();

      Place p = new Place("Here");
      Place pTwo = new Place("There");
      Stop x = new Stop(p);
      Stop y = new Stop(pTwo);

      l.add(x);
      l.add(y);

      Route r = new Route();

      r.setStops(l);
      List<Stop> actual = r.getStops();

      assertEquals(actual, l);

    }

    @Test
    public void testGetStops(){
      List<Stop> l = new ArrayList<Stop>();

      Place p = new Place("Here");
      Place pTwo = new Place("There");
      Stop x = new Stop(p);
      Stop y = new Stop(pTwo);

      l.add(x);
      l.add(y);

      Route r = new Route();

      r.setStops(l);
      List<Stop> actual = r.getStops();

      assertEquals(actual, l);

    }

    @Test
    public void testToString(){
      List<Stop> l = new ArrayList<Stop>();

      Place p = new Place("Here");
      Place pTwo = new Place("There");
      Stop x = new Stop(p);
      Stop y = new Stop(pTwo);

      l.add(x);
      l.add(y);

      Route r = new Route();

      r.setStops(l);
      List<Stop> actual = r.getStops();

      String expected = "";

      for (Stop s : actual)
        expected += s + "\n";

      assertEquals(expected, r.toString());

    }
}
