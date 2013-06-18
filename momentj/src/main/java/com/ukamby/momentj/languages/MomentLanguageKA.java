package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ka language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageKA extends MomentLanguage {
	private static final String[] monthsShort = new String[]{"იან","თებ","მარ","აპრ","მაი","ივნ","ივლ","აგვ","სექ","ოქტ","ნოე","დეკ"};
	private static final String[] weekdaysShort = new String[]{"კვი","ორშ","სამ","ოთხ","ხუთ","პარ","შაბ"};
	private static final String[] weekdaysMin = new String[]{"კვ","ორ","სა","ოთ","ხუ","პა","შა"};
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
