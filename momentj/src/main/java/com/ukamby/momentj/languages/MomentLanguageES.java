package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * es language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageES extends MomentLanguage {
	private static String[] months = new String[]{"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
	private static final String[] monthsShort = new String[]{"ene.","feb.","mar.","abr.","may.","jun.","jul.","ago.","sep.","oct.","nov.","dic."};
	private static final String[] weekdays = new String[]{"domingo","lunes","martes","miércoles","jueves","viernes","sábado"};
	private static final String[] weekdaysShort = new String[]{"dom.","lun.","mar.","mié.","jue.","vie.","sáb."};
	private static final String[] weekdaysMin = new String[]{"Do","Lu","Ma","Mi","Ju","Vi","Sá"};

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
