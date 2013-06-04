package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * hu language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageHU extends MomentLanguage {
	private static String[] months = new String[]{"január","február","március","április","május","június","július","augusztus","szeptember","október","november","december"};
	private static final String[] monthsShort = new String[]{"jan","feb","márc","ápr","máj","jún","júl","aug","szept","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"vasárnap","hétfő","kedd","szerda","csütörtök","péntek","szombat"};
	private static final String[] weekdaysShort = new String[]{"v","h","k","sze","cs","p","szo"};

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

    abstract String[] getWeekdaysMin();

}
