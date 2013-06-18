package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * is language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageIS extends MomentLanguage {
	private static String[] months = new String[]{"janúar","febrúar","mars","apríl","maí","júní","júlí","ágúst","september","október","nóvember","desember"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","maí","jún","júl","ágú","sep","okt","nóv","des"};
	private static final String[] weekdays = new String[]{"sunnudagur","mánudagur","þriðjudagur","miðvikudagur","fimmtudagur","föstudagur","laugardagur"};
	private static final String[] weekdaysShort = new String[]{"sun","mán","þri","mið","fim","fös","lau"};
	private static final String[] weekdaysMin = new String[]{"Su","Má","Þr","Mi","Fi","Fö","La"};
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
