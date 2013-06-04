package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ru language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageRU extends MomentLanguage {
	private static final String[] monthsShort = new String[]{"янв","фев","мар","апр","май","июн","июл","авг","сен","окт","ноя","дек"};
	private static final String[] weekdaysShort = new String[]{"вск","пнд","втр","срд","чтв","птн","сбт"};
	private static final String[] weekdaysMin = new String[]{"вс","пн","вт","ср","чт","пт","сб"};

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
