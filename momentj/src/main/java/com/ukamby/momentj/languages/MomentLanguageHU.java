package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * hu language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageHU extends MomentLanguage {
	private static String[] months = new String[]{"január","február","március","április","május","június","július","augusztus","szeptember","október","november","december"};
	private static final String[] monthsShort = new String[]{"jan","feb","márc","ápr","máj","jún","júl","aug","szept","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"vasárnap","hétfő","kedd","szerda","csütörtök","péntek","szombat"};
	private static final String[] weekdaysShort = new String[]{"v","h","k","sze","cs","p","szo"};
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

    abstract String[] getWeekdaysMin();

}
