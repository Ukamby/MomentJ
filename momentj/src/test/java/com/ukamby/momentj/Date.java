package com.ukamby.momentj;

/**
 * Created by RubyAir on 22/05/13.
 */
public class Date extends java.util.Date{

    public Date() {
    }

    public Date(long date) {
        super(date);
    }

    public Date(int year, int month, int date) {
        super(year, month, date);
    }

    public Date(int year, int month, int date, int hrs, int min) {
        super(year, month, date, hrs, min);
    }

    public Date(int year, int month, int date, int hrs, int min, int sec) {
        super(year, month, date, hrs, min, sec);
    }

    public Date(int year, int month, int date, int hrs, int min, int sec, int milliseconds) {
        super(year, month, date, hrs, min, sec);
        this.setTime(getTime() + milliseconds);
    }

    public Date(String s) {
        super(s);
    }
}
