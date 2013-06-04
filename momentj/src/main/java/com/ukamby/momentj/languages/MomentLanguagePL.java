package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * pl language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguagePL extends MomentLanguage {
	private static String[] months = new String[]{"styczeń","luty","marzec","kwiecień","maj","czerwiec","lipiec","sierpień","wrzesień","październik","listopad","grudzień"};
	private static final String[] monthsShort = new String[]{"sty","lut","mar","kwi","maj","cze","lip","sie","wrz","paź","lis","gru"};
	private static final String[] weekdays = new String[]{"niedziela","poniedziałek","wtorek","środa","czwartek","piątek","sobota"};
	private static final String[] weekdaysShort = new String[]{"nie","pon","wt","śr","czw","pt","sb"};
	private static final String[] weekdaysMin = new String[]{"N","Pn","Wt","Śr","Cz","Pt","So"};

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
