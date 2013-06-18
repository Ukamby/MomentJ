package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sk language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageSK extends MomentLanguage {
	private static String[] months = new String[]{"január","február","marec","apríl","máj","jún","júl","august","september","október","november","december"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","máj","jún","júl","aug","sep","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"nedeľa","pondelok","utorok","streda","štvrtok","piatok","sobota"};
	private static final String[] weekdaysShort = new String[]{"ne","po","ut","st","št","pi","so"};
	private static final String[] weekdaysMin = new String[]{"ne","po","ut","st","št","pi","so"};
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
