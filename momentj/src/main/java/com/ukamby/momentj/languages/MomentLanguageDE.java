package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * de language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageDE extends MomentLanguage {
	private static String[] months = new String[]{"Januar","Februar","März","April","Mai","Juni","Juli","August","September","Oktober","November","Dezember"};
	private static final String[] monthsShort = new String[]{"Jan.","Febr.","Mrz.","Apr.","Mai","Jun.","Jul.","Aug.","Sept.","Okt.","Nov.","Dez."};
	private static final String[] weekdays = new String[]{"Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"};
	private static final String[] weekdaysShort = new String[]{"So.","Mo.","Di.","Mi.","Do.","Fr.","Sa."};
	private static final String[] weekdaysMin = new String[]{"So","Mo","Di","Mi","Do","Fr","Sa"};

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
