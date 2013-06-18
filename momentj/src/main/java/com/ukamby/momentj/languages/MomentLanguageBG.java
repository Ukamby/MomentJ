package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * bg language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageBG extends MomentLanguage {
	private static String[] months = new String[]{"януари","февруари","март","април","май","юни","юли","август","септември","октомври","ноември","декември"};
	private static final String[] monthsShort = new String[]{"янр","фев","мар","апр","май","юни","юли","авг","сеп","окт","ное","дек"};
	private static final String[] weekdays = new String[]{"неделя","понеделник","вторник","сряда","четвъртък","петък","събота"};
	private static final String[] weekdaysShort = new String[]{"нед","пон","вто","сря","чет","пет","съб"};
	private static final String[] weekdaysMin = new String[]{"нд","пн","вт","ср","чт","пт","сб"};
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
