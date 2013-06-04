package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * el language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageEL extends MomentLanguage {
	private static final String[] monthsShort = new String[]{"Ιαν","Φεβ","Μαρ","Απρ","Μαϊ","Ιουν","Ιουλ","Αυγ","Σεπ","Οκτ","Νοε","Δεκ"};
	private static final String[] weekdays = new String[]{"Κυριακή","Δευτέρα","Τρίτη","Τετάρτη","Πέμπτη","Παρασκευή","Σάββατο"};
	private static final String[] weekdaysShort = new String[]{"Κυρ","Δευ","Τρι","Τετ","Πεμ","Παρ","Σαβ"};
	private static final String[] weekdaysMin = new String[]{"Κυ","Δε","Τρ","Τε","Πε","Πα","Σα"};

    abstract String[] getMonths();

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
