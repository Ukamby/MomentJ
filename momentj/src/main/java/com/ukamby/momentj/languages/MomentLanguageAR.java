package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ar language constants for MomentJ.
 *
 * User: luke
 * Date: 18/6/2013
 */
public abstract class MomentLanguageAR extends MomentLanguage {
	private static String[] months = new String[]{"يناير/ كانون الثاني","فبراير/ شباط","مارس/ آذار","أبريل/ نيسان","مايو/ أيار","يونيو/ حزيران","يوليو/ تموز","أغسطس/ آب","سبتمبر/ أيلول","أكتوبر/ تشرين الأول","نوفمبر/ تشرين الثاني","ديسمبر/ كانون الأول"};
	private static final String[] monthsShort = new String[]{"يناير/ كانون الثاني","فبراير/ شباط","مارس/ آذار","أبريل/ نيسان","مايو/ أيار","يونيو/ حزيران","يوليو/ تموز","أغسطس/ آب","سبتمبر/ أيلول","أكتوبر/ تشرين الأول","نوفمبر/ تشرين الثاني","ديسمبر/ كانون الأول"};
	private static final String[] weekdays = new String[]{"الأحد","الإثنين","الثلاثاء","الأربعاء","الخميس","الجمعة","السبت"};
	private static final String[] weekdaysShort = new String[]{"الأحد","الإثنين","الثلاثاء","الأربعاء","الخميس","الجمعة","السبت"};
	private static final String[] weekdaysMin = new String[]{"ح","ن","ث","ر","خ","ج","س"};
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
