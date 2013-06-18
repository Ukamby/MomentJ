package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * en-gb language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageEN_GB extends MomentLanguage {
	private static String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
	private static final String[] monthsShort = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private static final String[] weekdays = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private static final String[] weekdaysShort = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	private static final String[] weekdaysMin = new String[]{"Su","Mo","Tu","We","Th","Fr","Sa"};
    private static final Map<String, Integer> week = createWeek();

    /**
     * dow : The first day of the week.
     * doy : The day number of the beginning of the year for this locale.
     */
    private static final Map<String, Integer> createWeek() {
        Map<String, Integer> map = new HashMap<>();
        map.put("dow", 0);
        map.put("doy", 6);
        return Collections.unmodifiableMap(map);
    }
    

    @Override
    String[] getMonths() {
        return months;
    }

    @Override
    String[] getMonthsShort() {
        return monthsShort;
    }

    @Override
    String[] getWeekdays() {
        return weekdays;
    }

    @Override
    String[] getWeekdaysShort() {
        return weekdaysShort;
    }

    @Override
    String[] getWeekdaysMin() {
        return weekdaysMin;
    }

}
