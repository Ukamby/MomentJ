package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ar-ma language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguageAR_MA extends MomentLanguage {
	private static String[] months = new String[]{"يناير","فبراير","مارس","أبريل","ماي","يونيو","يوليوز","غشت","شتنبر","أكتوبر","نونبر","دجنبر"};
	private static final String[] monthsShort = new String[]{"يناير","فبراير","مارس","أبريل","ماي","يونيو","يوليوز","غشت","شتنبر","أكتوبر","نونبر","دجنبر"};
	private static final String[] weekdays = new String[]{"الأحد","الإتنين","الثلاثاء","الأربعاء","الخميس","الجمعة","السبت"};
	private static final String[] weekdaysShort = new String[]{"احد","اتنين","ثلاثاء","اربعاء","خميس","جمعة","سبت"};
	private static final String[] weekdaysMin = new String[]{"ح","ن","ث","ر","خ","ج","س"};

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
