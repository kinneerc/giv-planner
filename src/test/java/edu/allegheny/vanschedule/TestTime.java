package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTime {

    @Test
    public void testTime(){
        Time time = new Time(10,5);
        
        assertEquals(10,time.getHour());
        assertEquals(5,time.getMinute());

        time = new Time(24,60);
        
        assertEquals(false,time.getHour() == 24);
        assertEquals(false,time.getMinute() == 60);

    }

    @Test
    public void testGetHour(){

        Time time = new Time(18,58);
        assertEquals(18,time.getHour());

        time = new Time(28,-2);
        assertEquals(false,time.getHour() == 28);


    }

    @Test 
    public void testGetMinuite(){

        Time time = new Time(20,50);
        assertEquals(50,time.getMinute());

        time = new Time(-20,-70);
        assertEquals(false,time.getMinute() == -70);

    }

    @Test 
    public void testSetHour(){

        Time time = new Time(18,58);

        time.setHour(20);
        assertEquals(20,time.getHour());
        time.setHour(-30);
        assertEquals(false,time.getHour() == -30);


    }

    @Test 
    public void testSetMinuite(){
         Time time = new Time(23,59);

        time.setMinute(0);
        assertEquals(0,time.getMinute());

        time.setMinute(-25);
        assertEquals(false,time.getMinute() == -25);


    }

    @Test 
    public void testGetDiff(){

        Time a = new Time(0,0);
        Time b = new Time(0,10);

        assertEquals(10,a.getDiff(b));

        assertEquals(-10,b.getDiff(a));

        a = new Time(0,10);

        assertEquals(0,a.getDiff(b));


        b = new Time(1,10);

        assertEquals(60,a.getDiff(b));

        assertEquals(-60,b.getDiff(a));

        a = new Time(1,10);

        assertEquals(0,a.getDiff(b));

    }

    @Test
    public void testParse(){
        Time a = Time.parse("1:55 AM");

        assertEquals(1,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("01:55 AM");

        assertEquals(1,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("01:55 am");

        assertEquals(1,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("1:55 PM");

        assertEquals(13,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("01:55 PM");

        assertEquals(13,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("01:55 pm");

        assertEquals(13,a.getHour());
        assertEquals(55,a.getMinute());

        a = Time.parse("12:55 am");

        assertEquals(0,a.getHour());
        assertEquals(55,a.getMinute());


        a = Time.parse("12:55 pm");

        assertEquals(12,a.getHour());
        assertEquals(55,a.getMinute());


    }



}
