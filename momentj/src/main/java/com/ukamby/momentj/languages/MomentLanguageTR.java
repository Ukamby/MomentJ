package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * tr language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageTR extends MomentLanguage {
	private static String[] months = new String[]{"Ocak","Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık"};
	private static final String[] monthsShort = new String[]{"Oca","Şub","Mar","Nis","May","Haz","Tem","Ağu","Eyl","Eki","Kas","Ara"};
	private static final String[] weekdays = new String[]{"Pazar","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi"};
	private static final String[] weekdaysShort = new String[]{"Paz","Pts","Sal","Çar","Per","Cum","Cts"};
	private static final String[] weekdaysMin = new String[]{"Pz","Pt","Sa","Ça","Pe","Cu","Ct"};

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
