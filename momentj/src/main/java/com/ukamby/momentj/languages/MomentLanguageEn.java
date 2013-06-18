package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * English language constants for MomentJ.
 *
 * User: luke
 * Date: 24/05/13
 * Time: 9:56 PM
 */
public class MomentLanguageEn extends MomentLanguage {
    private static final String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
    private static final String[] monthsShort = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private static final String[] weekdays = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private static final String[] weekdaysShort = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    private static final String[] weekdaysMin = new String[]{"Su","Mo","Tu","We","Th","Fr","Sa"};
    private static final Map<String, String> longDateFormat = createLongDateFormat();
    private static final Map<String, String> calendar = createCalendar();
    private static final Map<String, String> relativeTime = createRelativeTime();
    private static final Map<String, Integer> week = createWeek();

    /**
     * dow : 0 // Sunday is the first day of the week.
     * doy : 6 // The week that contains Jan 1st is the first week of the year.
     */
    private static final Map<String, Integer> createWeek() {
        Map<String, Integer> map = new HashMap<>();
            /*
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
            */
        map.put("dow", 0);
        map.put("doy", 6);
        return Collections.unmodifiableMap(map);
    }

    private static Map<String, String> createRelativeTime() {
        Map<String,String> map = new HashMap<>();
        /*
        Regex: "(.+) : \"(.+)\",?"
        Replace: map.put("$1", "$2");
        Source:
                future : "in %s",
                yy : "%d years"
        */
        map.put("future", "in %s");
        map.put("past", "%s ago");
        map.put("s", "a few seconds");
        map.put("m", "a minute");
        map.put("mm", "%d minutes");
        map.put("h", "an hour");
        map.put("hh", "%d hours");
        map.put("d", "a day");
        map.put("dd", "%d days");
        map.put("M", "a month");
        map.put("MM", "%d months");
        map.put("y", "a year");
        map.put("yy", "%d years");
        return Collections.unmodifiableMap(map);
    }

    private static Map<String, String> createCalendar(){
        Map<String,String> map = new HashMap<>();
        map.put("sameDay", "[Today at] LT");
        map.put("nextDay", "[Tomorrow at] LT");
        map.put("nextWeek", "dddd [at] LT");
        map.put("lastDay", "[Yesterday at] LT");
        map.put("lastWeek", "[last] dddd [at] LT");
        map.put("sameElse", "L");
        return Collections.unmodifiableMap(map);
    }

    private static Map<String, String> createLongDateFormat() {
        Map<String, String> map = new HashMap<>();
        map.put("LT", "h:mm A");
        map.put("L", "MM/DD/YYYY");
        map.put("LL", "MMMM D YYYY");
        map.put("LLL", "MMMM D YYYY LT");
        map.put("LLLL" , "dddd, MMMM D YYYY LT");
        return Collections.unmodifiableMap(map);
    }

    @Override
    public String getMeridiem(int hours, int minutes, boolean isLower) {
        if (hours > 11) {
            return isLower ? "pm" : "PM";
        } else {
            return isLower ? "am" : "AM";
        }
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

    @Override
    Map<String, String> getLongDateFormat() {
        return longDateFormat;
    }

    @Override
    Map<String, String> getCalendar() {
        return calendar;
    }

    @Override
    Map<String, String> getRelativeTime() {
        return relativeTime;
    }

    @Override
    Map<String, Integer> getWeek() {
        return week;
    }
}
