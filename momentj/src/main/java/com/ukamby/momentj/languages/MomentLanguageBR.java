package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * br language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageBR extends MomentLanguage {
	private static String[] months = new String[]{"Genver","C'hwevrer","Meurzh","Ebrel","Mae","Mezheven","Gouere","Eost","Gwengolo","Here","Du","Kerzu"};
	private static final String[] monthsShort = new String[]{"Gen","C'hwe","Meu","Ebr","Mae","Eve","Gou","Eos","Gwe","Her","Du","Ker"};
	private static final String[] weekdays = new String[]{"Sul","Lun","Meurzh","Merc'her","Yaou","Gwener","Sadorn"};
	private static final String[] weekdaysShort = new String[]{"Sul","Lun","Meu","Mer","Yao","Gwe","Sad"};
	private static final String[] weekdaysMin = new String[]{"Su","Lu","Me","Mer","Ya","Gw","Sa"};
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
