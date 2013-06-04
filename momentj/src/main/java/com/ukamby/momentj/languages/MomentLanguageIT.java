package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * it language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageIT extends MomentLanguage {
	private static String[] months = new String[]{"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
	private static final String[] monthsShort = new String[]{"Gen","Feb","Mar","Apr","Mag","Giu","Lug","Ago","Set","Ott","Nov","Dic"};
	private static final String[] weekdays = new String[]{"Domenica","Lunedì","Martedì","Mercoledì","Giovedì","Venerdì","Sabato"};
	private static final String[] weekdaysShort = new String[]{"Dom","Lun","Mar","Mer","Gio","Ven","Sab"};
	private static final String[] weekdaysMin = new String[]{"D","L","Ma","Me","G","V","S"};

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
