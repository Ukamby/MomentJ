package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * uk language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageUK extends MomentLanguage {
	private static final String[] monthsShort = new String[]{"січ","лют","бер","кві","тра","чер","лип","сер","вер","жов","лис","гру"};
	private static final String[] weekdaysShort = new String[]{"нед","пон","вів","срд","чет","птн","суб"};
	private static final String[] weekdaysMin = new String[]{"нд","пн","вт","ср","чт","пт","сб"};

    abstract String[] getMonths();

    @Override
    String[] getMonthsShort() {
        return monthsShort;
    }

    abstract String[] getWeekdays();

    @Override
    String[] getWeekdaysShort() {
        return weekdaysShort;
    }

    @Override
    String[] getWeekdaysMin() {
        return weekdaysMin;
    }

}
