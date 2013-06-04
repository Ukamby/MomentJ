package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * nl language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageNL extends MomentLanguage {
	private static String[] months = new String[]{"januari","februari","maart","april","mei","juni","juli","augustus","september","oktober","november","december"};
	private static final String[] weekdays = new String[]{"zondag","maandag","dinsdag","woensdag","donderdag","vrijdag","zaterdag"};
	private static final String[] weekdaysShort = new String[]{"zo.","ma.","di.","wo.","do.","vr.","za."};
	private static final String[] weekdaysMin = new String[]{"Zo","Ma","Di","Wo","Do","Vr","Za"};

    @Override
    String[] getMonths() {
        return months;
    }

    abstract String[] getMonthsShort();

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
