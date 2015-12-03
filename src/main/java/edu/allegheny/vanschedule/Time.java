package edu.allegheny.vanschedule;
/**
 * Time representation
 * @author Cody Kinneer
 */
public class Time {

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
        // if (hour >= 0 && hour <= 23)
        //     this.hour = hour;
        this.hour = hour;
    }

    public void setMinute(int minute){
        // if (minute >= 0 && minute <= 59)
        //     this.minute = minute;
        this.minute = minute;
    }

    //TODO make this work

    /**
     * Returns the difference from another Time in minutes
     * @param time the time to compute difference from
     * @return the difference between this time and the input time in minutes
     */
    public int getDiff(Time time){  //returns the time difference in minutes
        //time = t;
        hourB = time.getHour();
        minB = time.getMinute();
        hourDiff = hour - hourB;
        minDiff = minute - minB;
        minDiff = hourDiff*60 + minDiff;
        return minDiff;
    }

    public static Time parse(String in){
        return new Time(0,0);
    }

}
