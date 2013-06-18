package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * cv language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageCV extends MomentLanguage {
	private static String[] months = new String[]{"кăрлач","нарăс","пуш","ака","май","çĕртме","утă","çурла","авăн","юпа","чӳк","раштав"};
	private static final String[] monthsShort = new String[]{"кăр","нар","пуш","ака","май","çĕр","утă","çур","ав","юпа","чӳк","раш"};
	private static final String[] weekdays = new String[]{"вырсарникун","тунтикун","ытларикун","юнкун","кĕçнерникун","эрнекун","шăматкун"};
	private static final String[] weekdaysShort = new String[]{"выр","тун","ытл","юн","кĕç","эрн","шăм"};
	private static final String[] weekdaysMin = new String[]{"вр","тн","ыт","юн","кç","эр","шм"};
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
