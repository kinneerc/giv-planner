package edu.allegheny.vanschedule;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestTrip2 {

    @Test
    public void testSetDepartureTime(){
      Place p = new Place("Here");
      Trip2 tr = new Trip2(p);

      Time t = new Time(10,10);

      tr.setdepartureTime(t);
      Time expected = new Time(9,55);
      Time actual = tr.getDepartureTime();

      assertEquals(actual.getHour(), expected.getHour());
      assertEquals(actual.getMinute(), expected.getMinute());

      t = new Time(10,55);

      tr.setdepartureTime(t);
      expected = new Time(10,40);
      actual = tr.getDepartureTime();

      assertEquals(actual.getHour(), expected.getHour());
      assertEquals(actual.getMinute(), expected.getMinute());


      t = new Time(10,15);

      tr.setdepartureTime(t);
      expected = new Time(10,00);
      actual = tr.getDepartureTime();

      assertEquals(actual.getHour(), expected.getHour());
      assertEquals(actual.getMinute(), expected.getMinute());

    }

    @Test
    public void testAddPerson(){
      Place p = new Place("Here");
      Trip2 tr = new Trip2(p);
      String n = "name";

      tr.addPerson(n);
      ArrayList<String> list = tr.getPersonList();
      String actual = list.get(0);

      assertEquals(actual,"name");

      n = "";

      tr.addPerson(n);
      list = tr.getPersonList();
      actual = list.get(1);

      assertEquals(actual,"");
    }

    @Test
    public void testAddEmail(){
      Place p = new Place("Here");
      Trip2 tr = new Trip2(p);
      String e = "name@test.edu";

      tr.addEmail(e);
      ArrayList<String> elist = tr.getEmailList();
      String actual = elist.get(0);

      assertEquals(actual,"name@test.edu");

      e = "";

      tr.addEmail(e);
      elist = tr.getEmailList();
      actual = elist.get(1);

      assertEquals(actual,"");
    }

}
