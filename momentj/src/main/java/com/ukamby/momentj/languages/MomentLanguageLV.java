package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * lv language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageLV extends MomentLanguage {
	private static String[] months = new String[]{"janvāris","februāris","marts","aprīlis","maijs","jūnijs","jūlijs","augusts","septembris","oktobris","novembris","decembris"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","mai","jūn","jūl","aug","sep","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"svētdiena","pirmdiena","otrdiena","trešdiena","ceturtdiena","piektdiena","sestdiena"};
	private static final String[] weekdaysShort = new String[]{"Sv","P","O","T","C","Pk","S"};
	private static final String[] weekdaysMin = new String[]{"Sv","P","O","T","C","Pk","S"};

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
