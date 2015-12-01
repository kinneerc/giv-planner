package edu.allegheny.vanschedule;
/**
 * Time representation
 * @author Cody Kinneer
 */
public class Time {

    private int hour;
    private int minuite;

    public Time (int hour, int minute){
        setHour(hour);
        setMinute(minute);
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minuite;
    }

    public void setHour(int hour){
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
    }

    public void setMinute(int minute){
        if (minuite >= 0 && minute <= 59)
            this.minute = minute;
    }

    //TODO make this work

    /**
     * Returns the difference from another Time in minutes
     * @param time the time to compute difference from
     * @return the difference between this time and the input time in minutes
     */
    public int getDiff(Time time){
        //getting the difference between the current object and the time of another object
        //consider changing parameter to taking in an object?
        int hour2 = time.getHour();
        int minute2 = time.getMinute();
        int hourAmount = abs(hour - hour2);
        int minAmount = abs(minute - minute2);

        return 0;
    }

    public static Time parse(String in){
        return new Time(0,0);
    }

}
