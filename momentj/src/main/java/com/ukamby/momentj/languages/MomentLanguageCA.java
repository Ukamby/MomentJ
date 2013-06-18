package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ca language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageCA extends MomentLanguage {
	private static String[] months = new String[]{"Gener","Febrer","Març","Abril","Maig","Juny","Juliol","Agost","Setembre","Octubre","Novembre","Desembre"};
	private static final String[] monthsShort = new String[]{"Gen.","Febr.","Mar.","Abr.","Mai.","Jun.","Jul.","Ag.","Set.","Oct.","Nov.","Des."};
	private static final String[] weekdays = new String[]{"Diumenge","Dilluns","Dimarts","Dimecres","Dijous","Divendres","Dissabte"};
	private static final String[] weekdaysShort = new String[]{"Dg.","Dl.","Dt.","Dc.","Dj.","Dv.","Ds."};
	private static final String[] weekdaysMin = new String[]{"Dg","Dl","Dt","Dc","Dj","Dv","Ds"};
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
