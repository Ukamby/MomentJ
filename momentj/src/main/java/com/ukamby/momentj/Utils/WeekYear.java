package com.ukamby.momentj.utils;

/**
 * Result structure for getting the week number and year of a moment in the weekOfYear() function.
 *
 * User: luke
 * Date: 28/05/13
 * Time: 10:11 PM
 */
public class WeekYear {
    private int weekNumber;
    private int year;

    public WeekYear(int weekNumber, int year) {
        this.weekNumber = weekNumber;
        this.year = year;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int getYear() {
        return year;
    }
}
