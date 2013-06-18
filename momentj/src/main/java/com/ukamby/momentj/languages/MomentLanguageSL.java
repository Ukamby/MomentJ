package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sl language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageSL extends MomentLanguage {
	private static String[] months = new String[]{"januar","februar","marec","april","maj","junij","julij","avgust","september","oktober","november","december"};
	private static final String[] monthsShort = new String[]{"jan.","feb.","mar.","apr.","maj.","jun.","jul.","avg.","sep.","okt.","nov.","dec."};
	private static final String[] weekdays = new String[]{"nedelja","ponedeljek","torek","sreda","četrtek","petek","sobota"};
	private static final String[] weekdaysShort = new String[]{"ned.","pon.","tor.","sre.","čet.","pet.","sob."};
	private static final String[] weekdaysMin = new String[]{"ne","po","to","sr","če","pe","so"};
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
