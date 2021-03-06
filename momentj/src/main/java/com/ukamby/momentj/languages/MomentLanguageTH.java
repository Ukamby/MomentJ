package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * th language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageTH extends MomentLanguage {
	private static String[] months = new String[]{"มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"};
	private static final String[] monthsShort = new String[]{"มกรา","กุมภา","มีนา","เมษา","พฤษภา","มิถุนา","กรกฎา","สิงหา","กันยา","ตุลา","พฤศจิกา","ธันวา"};
	private static final String[] weekdays = new String[]{"อาทิตย์","จันทร์","อังคาร","พุธ","พฤหัสบดี","ศุกร์","เสาร์"};
	private static final String[] weekdaysShort = new String[]{"อาทิตย์","จันทร์","อังคาร","พุธ","พฤหัส","ศุกร์","เสาร์"};
	private static final String[] weekdaysMin = new String[]{"อา.","จ.","อ.","พ.","พฤ.","ศ.","ส."};
    private static final Map<String, Integer> week = createWeek();

    /**
     * dow : The first day of the week.
     * doy : The day number of the beginning of the year for this locale.
     */
    private static final Map<String, Integer> createWeek() {
        Map<String, Integer> map = new HashMap<>();
        map.put("dow", 0);
        map.put("doy", 6);
        return Collections.unmodifiableMap(map);
    }
    

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
