package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ms-my language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageMS_MY extends MomentLanguage {
	private static String[] months = new String[]{"Januari","Februari","Mac","April","Mei","Jun","Julai","Ogos","September","Oktober","November","Disember"};
	private static final String[] monthsShort = new String[]{"Jan","Feb","Mac","Apr","Mei","Jun","Jul","Ogs","Sep","Okt","Nov","Dis"};
	private static final String[] weekdays = new String[]{"Ahad","Isnin","Selasa","Rabu","Khamis","Jumaat","Sabtu"};
	private static final String[] weekdaysShort = new String[]{"Ahd","Isn","Sel","Rab","Kha","Jum","Sab"};
	private static final String[] weekdaysMin = new String[]{"Ah","Is","Sl","Rb","Km","Jm","Sb"};
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
