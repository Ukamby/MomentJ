package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * cs language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageCS extends MomentLanguage {
	private static String[] months = new String[]{"leden","únor","březen","duben","květen","červen","červenec","srpen","září","říjen","listopad","prosinec"};
	private static final String[] monthsShort = new String[]{"led","úno","bře","dub","kvě","čvn","čvc","srp","zář","říj","lis","pro"};
	private static final String[] weekdays = new String[]{"neděle","pondělí","úterý","středa","čtvrtek","pátek","sobota"};
	private static final String[] weekdaysShort = new String[]{"ne","po","út","st","čt","pá","so"};
	private static final String[] weekdaysMin = new String[]{"ne","po","út","st","čt","pá","so"};

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
