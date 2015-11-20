package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTime {

    @Test
    public void testTime(){
        Time time = new Time(10,5);
        assertEquals(time.getHour(),10);
        assertEquals(time.getMinuite(),5);

        time = new Time(24,60);
        assertEquals(time.getHour() == 24,false);
        assertEquals(time.getMinuite() == 60,false);

    }

    @Test
    public void testGetHour(){

        Time time = new Time(18,58);
        assertEquals(time.getHour(),18);

        time = new Time(28,-2);
        assertEquals(time.getHour() == 28,false);


    }

    @Test 
    public void testGetMinuite(){

        Time time = new Time(20,50);
        assertEquals(time.getMinuite(),50);

        time = new Time(-20,-70);
        assertEquals(time.getMinuite() == -70,false);

    }

    @Test 
    public void testSetHour(){

        Time time = new Time(18,58);

        time.setHour(20);
        assertEquals(time.getHour(),20);
        time.setHour(-30);
        assertEquals(time.getHour() == -30,false);


    }

    @Test 
    public void testSetMinuite(){
         Time time = new Time(23,59);

        time.setMinuite(0);
        assertEquals(time.getMinuite(),0);

        time.setMinuite(-25);
        assertEquals(time.getMinuite() == -25,false);


    }

    @Test 
    public void testGetDiff(){

        Time a = new Time(0,0);
        Time b = new Time(0,10);

        assertEquals(a.getDiff(b),10);

        assertEquals(b.getDiff(a),-10);

        a = new Time(0,10);

        assertEquals(a.getDiff(b),0);


        b = new Time(1,10);

        assertEquals(a.getDiff(b),60);

        assertEquals(b.getDiff(a),-60);

        a = new Time(1,10);

        assertEquals(a.getDiff(b),0);

    }



}
