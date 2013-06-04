package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * da language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageDA extends MomentLanguage {
	private static String[] months = new String[]{"Januar","Februar","Marts","April","Maj","Juni","Juli","August","September","Oktober","November","December"};
	private static final String[] monthsShort = new String[]{"Jan","Feb","Mar","Apr","Maj","Jun","Jul","Aug","Sep","Okt","Nov","Dec"};
	private static final String[] weekdays = new String[]{"Søndag","Mandag","Tirsdag","Onsdag","Torsdag","Fredag","Lørdag"};
	private static final String[] weekdaysShort = new String[]{"Søn","Man","Tir","Ons","Tor","Fre","Lør"};
	private static final String[] weekdaysMin = new String[]{"Sø","Ma","Ti","On","To","Fr","Lø"};

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
