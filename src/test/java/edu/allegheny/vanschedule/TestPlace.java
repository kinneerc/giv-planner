package edu.allegheny.vanschedule;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPlace {

    @Test
    public void testPlace(){
    	Place p = new Place("2nd District");
    	assertEquals("2nd District",p.getName());
    }

    @Test
    public void testGetName(){
    	Place p = new Place("1st District");
    	assertEquals("1st District",p.getName());
    }

    @Test
    public void testGetAddress(){
    	Place p = new Place("Test Place");
    	assertEquals("Test Place, Meadville PA",p.getAddress());
    }

    @Test
    public void testGetAllegheny(){
    	Place p = new Place("Test Place");
      Place allegheny = p.getAllegheny();

    	assertEquals("Allegheny College",allegheny.getName());
    }

}
