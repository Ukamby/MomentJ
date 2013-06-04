package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * nb language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageNB extends MomentLanguage {
	private static String[] months = new String[]{"januar","februar","mars","april","mai","juni","juli","august","september","oktober","november","desember"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","mai","jun","jul","aug","sep","okt","nov","des"};
	private static final String[] weekdays = new String[]{"søndag","mandag","tirsdag","onsdag","torsdag","fredag","lørdag"};
	private static final String[] weekdaysShort = new String[]{"søn","man","tir","ons","tor","fre","lør"};
	private static final String[] weekdaysMin = new String[]{"sø","ma","ti","on","to","fr","lø"};

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
