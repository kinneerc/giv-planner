package edu.allegheny.vanschedule;

/**
 * Time representation
 * @author Cody Kinneer
 */
public class Time {

    private int hour;
    private int minuite;

    public Time (int hour, int minuite){
        this.hour = hour;
        this.minuite = minuite;
    }

    public int getHour(){
        return hour;
    }

    public int getMinuite(){
        return minuite;
    }

    public void setHour(int hour){
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
    }

    public void setMinuite(int minuite){
        if (minuite >= 0 && minuite <= 59)
            this.minuite = minuite;
    }

    //TODO make this work

    /**
     * Returns the differance from another Time in miniutes
     * @param time the time to compute differance from
     * @return the differance between this time and the input time in minuites
     */
    public int getDiff(Time time){
        return 0;
    }

}
