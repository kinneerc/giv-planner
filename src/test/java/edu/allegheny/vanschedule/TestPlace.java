package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPlace {

    @Test
    public void testPlace(){
    	Place p = new Place("2nd District");
    	assertEquals(p.getName(),"2nd District");
    }

    @Test
    public void testGetName(){
    	Place p = new Place("1st District");
    	assertEquals(p.getName(),"1st District");
    }

    @Test 
    public void testGetAddress(){
    	Place p = new Place("Test Place");
    	p.setAddress("11ws Wallaby Lane");
    	assertEquals(p.getAddress(),"11ws Wallaby Lane");
    }

    @Test 
    public void testSetAddress(){
    	Place p = new Place("Test Place");
    	p.setAddress("Wallaby Lane");
    	assertEquals(p.getAddress(),"Wallaby Lane");
    }

}
