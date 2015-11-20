package edu.allegheny.vanschedule;

import java.util.ArrayList;

import org.junit.Test;
import java.util.Random;

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
	
	@Test
	public void testScheduleRand(){
		
		Random rand = new Random();
		
		for (int trials = 0; trials < 50; trials++){ 
		
		ArrayList<Request> reqs = new ArrayList<Request>();
		
		for (int reqCount = 0; reqCount < 12; reqCount++){
			reqs.add(
					new Request(
							new Place(rand.nextLong()+""),
							new Time(rand.nextInt(11),rand.nextInt(60)),
							new Time(rand.nextInt(11)+12,rand.nextInt(60))));
		}
		
		Route ans = Scheduler.schedule(reqs);
		
		for (Request r : reqs)
			assertEquals(r.satisfied(ans),true);
		
	}
	}

}
