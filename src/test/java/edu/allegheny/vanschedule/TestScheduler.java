package edu.allegheny.vanschedule;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScheduler {
	
	@Test
	public void testSchedule(){
	
		ArrayList<Request> reqs = new ArrayList<Request>();
		
		Request req1 = new Request(new Place("Botswana"),new Time(1,30),new Time(4,30));
		Request req2 = new Request(new Place("Iraq"),new Time(1,55),new Time(5,30));

		reqs.add(req1); reqs.add(req2);
		
		Route ans = Scheduler.schedule(reqs);
		
		assertEquals(req1.satisfied(ans),true);
		assertEquals(req2.satisfied(ans),true);
		
	}

}
