package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sl language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageSL extends MomentLanguage {
	private static String[] months = new String[]{"januar","februar","marec","april","maj","junij","julij","avgust","september","oktober","november","december"};
	private static final String[] monthsShort = new String[]{"jan.","feb.","mar.","apr.","maj.","jun.","jul.","avg.","sep.","okt.","nov.","dec."};
	private static final String[] weekdays = new String[]{"nedelja","ponedeljek","torek","sreda","četrtek","petek","sobota"};
	private static final String[] weekdaysShort = new String[]{"ned.","pon.","tor.","sre.","čet.","pet.","sob."};
	private static final String[] weekdaysMin = new String[]{"ne","po","to","sr","če","pe","so"};

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
