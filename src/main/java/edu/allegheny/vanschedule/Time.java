package edu.allegheny.vanschedule;
/**
 * Time representation
 * @author Cody Kinneer
 */
public class Time {

	private int minutes;
	
    private int hour;
    
    private int minute;
    
    
    private int hourB;
    private int minB;
    private int minDiff;
    private int hourDiff;

    public Time (int hour, int minute){
        setHour(hour);
        setMinute(minute);
    }
    public Time(){}

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public void setHour(int hour){
        if (hour >= 0 && hour <= 23){
            this.hour = hour;
            this.minutes = minute + 60 * hour;
        }
    }

    public void setMinute(int minute){
        if (minute >= 0 && minute <= 59){
            this.minute = minute;
            this.minutes = minute + hour * 60;
        }
    }
    
    public void addMinutes(int mins){
    	
    	minutes += mins;
    	
    	hour = minutes / 60;
    	minute = minutes % 60;
    	
    }
    
    public static Time addMinutes(Time t, int mins){
    	Time nt = t.clone();
    	nt.addMinutes(mins);
    	return nt;
    }

    //TODO make this work

    /**
     * Returns the difference from another Time in minutes
     * @param time the time to compute difference from
     * @return the difference between this time and the input time in minutes
     */
    public int getDiff(Time time){  //returns the time difference in minutes
        //time = t;
    	/*
        hourB = time.getHour();
        minB = time.getMinute();
        hourDiff = hour - hourB;
        minDiff = minute - minB;
        minDiff = hourDiff*60 + minDiff;
        return -minDiff;
        */
    	return time.minutes - minutes;
    }

    /*
	* parseTime()
	* 
	* @param String
	* @return Time
	*
	* Take a string representation of a time. 
	* Return it as a Time object.
	 */
    
    public Time clone() {
    	
    	return new Time(hour,minute);
   
    }
	
	public static Time parse(String t) {
		String[] initial = t.split("\\s+");
		String[] hourMinute = initial[0].split(":");
		Time tempTime;

		// check if null
		// if so return -1,-1
		if (t.equals("")) {
			tempTime = new Time(-1,-1);
			return tempTime;
		}

		// if it is not null
		else {
				// if it is am do not add 12 to time
				if (initial[1].toUpperCase().equals("AM")) {
					if (hourMinute[0].equals("12")) {
						int hourAM = 0;
						int minuteAM = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hourAM,minuteAM);
					} // inner if
					else {
						int hour = Integer.parseInt(hourMinute[0]);
						int minute = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hour,minute);
					} // inner else
				} // inner if

				// if pm add 12 to time
				else {
					if (hourMinute[0].equals("12")) {
						int hourPMT = Integer.parseInt(hourMinute[0]);
						int minutePMT = Integer.parseInt(hourMinute[1]);
						tempTime = new Time(hourPMT,minutePMT);
					} // inner if
					else {
						int hourPM = Integer.parseInt(hourMinute[0]);
						int minutePM = Integer.parseInt(hourMinute[1]);
						hourPM = hourPM + 12;
						tempTime = new Time(hourPM,minutePM);
					} // inner else
				} // inner else
			} // big else (not null)
			return tempTime;
		
	} // parseTime
    
    
	@Override
	public String toString(){
		return hour + ":" + minute;
	}

}
