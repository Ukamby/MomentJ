package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * hi language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageHI extends MomentLanguage {
	private static String[] months = new String[]{"जनवरी","फ़रवरी","मार्च","अप्रैल","मई","जून","जुलाई","अगस्त","सितम्बर","अक्टूबर","नवम्बर","दिसम्बर"};
	private static final String[] monthsShort = new String[]{"जन.","फ़र.","मार्च","अप्रै.","मई","जून","जुल.","अग.","सित.","अक्टू.","नव.","दिस."};
	private static final String[] weekdays = new String[]{"रविवार","सोमवार","मंगलवार","बुधवार","गुरूवार","शुक्रवार","शनिवार"};
	private static final String[] weekdaysShort = new String[]{"रवि","सोम","मंगल","बुध","गुरू","शुक्र","शनि"};
	private static final String[] weekdaysMin = new String[]{"र","सो","मं","बु","गु","शु","श"};

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
