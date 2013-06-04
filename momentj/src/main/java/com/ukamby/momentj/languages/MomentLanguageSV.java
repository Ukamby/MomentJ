package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sv language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageSV extends MomentLanguage {
	private static String[] months = new String[]{"januari","februari","mars","april","maj","juni","juli","augusti","september","oktober","november","december"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","maj","jun","jul","aug","sep","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"söndag","måndag","tisdag","onsdag","torsdag","fredag","lördag"};
	private static final String[] weekdaysShort = new String[]{"sön","mån","tis","ons","tor","fre","lör"};
	private static final String[] weekdaysMin = new String[]{"sö","må","ti","on","to","fr","lö"};

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
