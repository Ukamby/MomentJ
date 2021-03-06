package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * nn language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageNN extends MomentLanguage {
	private static String[] months = new String[]{"januar","februar","mars","april","mai","juni","juli","august","september","oktober","november","desember"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","mai","jun","jul","aug","sep","okt","nov","des"};
	private static final String[] weekdays = new String[]{"sundag","måndag","tysdag","onsdag","torsdag","fredag","laurdag"};
	private static final String[] weekdaysShort = new String[]{"sun","mån","tys","ons","tor","fre","lau"};
	private static final String[] weekdaysMin = new String[]{"su","må","ty","on","to","fr","lø"};
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
