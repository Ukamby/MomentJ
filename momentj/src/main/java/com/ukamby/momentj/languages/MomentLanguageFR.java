package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * fr language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageFR extends MomentLanguage {
	private static String[] months = new String[]{"janvier","février","mars","avril","mai","juin","juillet","août","septembre","octobre","novembre","décembre"};
	private static final String[] monthsShort = new String[]{"janv.","févr.","mars","avr.","mai","juin","juil.","août","sept.","oct.","nov.","déc."};
	private static final String[] weekdays = new String[]{"dimanche","lundi","mardi","mercredi","jeudi","vendredi","samedi"};
	private static final String[] weekdaysShort = new String[]{"dim.","lun.","mar.","mer.","jeu.","ven.","sam."};
	private static final String[] weekdaysMin = new String[]{"Di","Lu","Ma","Me","Je","Ve","Sa"};
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
