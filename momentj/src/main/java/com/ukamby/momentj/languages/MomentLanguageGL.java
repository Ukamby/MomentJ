package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * gl language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageGL extends MomentLanguage {
	private static String[] months = new String[]{"Xaneiro","Febreiro","Marzo","Abril","Maio","Xuño","Xullo","Agosto","Setembro","Octubro","Novembro","Decembro"};
	private static final String[] monthsShort = new String[]{"Xan.","Feb.","Mar.","Abr.","Mai.","Xuñ.","Xul.","Ago.","Set.","Out.","Nov.","Dec."};
	private static final String[] weekdays = new String[]{"Domingo","Luns","Martes","Mércores","Xoves","Venres","Sábado"};
	private static final String[] weekdaysShort = new String[]{"Dom.","Lun.","Mar.","Mér.","Xov.","Ven.","Sáb."};
	private static final String[] weekdaysMin = new String[]{"Do","Lu","Ma","Mé","Xo","Ve","Sá"};
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
