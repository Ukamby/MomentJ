package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * eo language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageEO extends MomentLanguage {
	private static String[] months = new String[]{"januaro","februaro","marto","aprilo","majo","junio","julio","aŭgusto","septembro","oktobro","novembro","decembro"};
	private static final String[] monthsShort = new String[]{"jan","feb","mar","apr","maj","jun","jul","aŭg","sep","okt","nov","dec"};
	private static final String[] weekdays = new String[]{"Dimanĉo","Lundo","Mardo","Merkredo","Ĵaŭdo","Vendredo","Sabato"};
	private static final String[] weekdaysShort = new String[]{"Dim","Lun","Mard","Merk","Ĵaŭ","Ven","Sab"};
	private static final String[] weekdaysMin = new String[]{"Di","Lu","Ma","Me","Ĵa","Ve","Sa"};

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
