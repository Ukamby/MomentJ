package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ne language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageNE extends MomentLanguage {
	private static String[] months = new String[]{"जनवरी","फेब्रुवरी","मार्च","अप्रिल","मई","जुन","जुलाई","अगष्ट","सेप्टेम्बर","अक्टोबर","नोभेम्बर","डिसेम्बर"};
	private static final String[] monthsShort = new String[]{"जन.","फेब्रु.","मार्च","अप्रि.","मई","जुन","जुलाई.","अग.","सेप्ट.","अक्टो.","नोभे.","डिसे."};
	private static final String[] weekdays = new String[]{"आइतबार","सोमबार","मङ्गलबार","बुधबार","बिहिबार","शुक्रबार","शनिबार"};
	private static final String[] weekdaysShort = new String[]{"आइत.","सोम.","मङ्गल.","बुध.","बिहि.","शुक्र.","शनि."};
	private static final String[] weekdaysMin = new String[]{"आइ.","सो.","मङ्","बु.","बि.","शु.","श."};
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
