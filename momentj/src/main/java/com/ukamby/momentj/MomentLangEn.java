package com.ukamby.momentj;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User: luke
 * Date: 24/05/13
 * Time: 9:56 PM
 */
public class MomentLangEn extends MomentLang {
    private static final String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
    private static final String[] monthsShort = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private static final String[] weekdays = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private static final String[] weekdaysShort = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    private static final String[] weekdaysMin = new String[]{"Su","Mo","Tu","We","Th","Fr","Sa"};
    private static final Map<String, String> longDateFormat;
    static {
        Map<String, String> map = new HashMap<>();
        map.put("LT", "h:mm A");
        map.put("L", "MM/DD/YYYY");
        map.put("LL", "MMMM D YYYY");
        map.put("LLL", "MMMM D YYYY LT");
        map.put("LLLL" , "dddd, MMMM D YYYY LT");
        longDateFormat = Collections.unmodifiableMap(map);
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
}
