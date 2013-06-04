package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * eu language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageEU extends MomentLanguage {
	private static String[] months = new String[]{"urtarrila","otsaila","martxoa","apirila","maiatza","ekaina","uztaila","abuztua","iraila","urria","azaroa","abendua"};
	private static final String[] monthsShort = new String[]{"urt.","ots.","mar.","api.","mai.","eka.","uzt.","abu.","ira.","urr.","aza.","abe."};
	private static final String[] weekdays = new String[]{"igandea","astelehena","asteartea","asteazkena","osteguna","ostirala","larunbata"};
	private static final String[] weekdaysShort = new String[]{"ig.","al.","ar.","az.","og.","ol.","lr."};
	private static final String[] weekdaysMin = new String[]{"ig","al","ar","az","og","ol","lr"};

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
