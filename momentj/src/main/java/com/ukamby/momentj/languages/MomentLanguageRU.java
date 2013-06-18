package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ru language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageRU extends MomentLanguage {
	private static final String[] monthsShort = new String[]{"янв","фев","мар","апр","май","июн","июл","авг","сен","окт","ноя","дек"};
	private static final String[] weekdaysShort = new String[]{"вск","пнд","втр","срд","чтв","птн","сбт"};
	private static final String[] weekdaysMin = new String[]{"вс","пн","вт","ср","чт","пт","сб"};
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
    

    abstract String[] getMonths();

    @Override
    String[] getMonthsShort() {
        return monthsShort;
    }

    abstract String[] getWeekdays();

    @Override
    String[] getWeekdaysShort() {
        return weekdaysShort;
    }

    @Override
    String[] getWeekdaysMin() {
        return weekdaysMin;
    }

}
