package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ja language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageJA extends MomentLanguage {
	private static String[] months = new String[]{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
	private static final String[] monthsShort = new String[]{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
	private static final String[] weekdays = new String[]{"日曜日","月曜日","火曜日","水曜日","木曜日","金曜日","土曜日"};
	private static final String[] weekdaysShort = new String[]{"日","月","火","水","木","金","土"};
	private static final String[] weekdaysMin = new String[]{"日","月","火","水","木","金","土"};
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
