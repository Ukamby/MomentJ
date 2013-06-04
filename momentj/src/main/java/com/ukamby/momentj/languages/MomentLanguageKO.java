package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ko language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageKO extends MomentLanguage {
	private static String[] months = new String[]{"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};
	private static final String[] monthsShort = new String[]{"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};
	private static final String[] weekdays = new String[]{"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	private static final String[] weekdaysShort = new String[]{"일","월","화","수","목","금","토"};
	private static final String[] weekdaysMin = new String[]{"일","월","화","수","목","금","토"};

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
