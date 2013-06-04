package com.ukamby.momentj.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * pt-br language constants for MomentJ.
 *
 * User: luke
 * Date: 4/6/2013
 */
public abstract class MomentLanguagePT_BR extends MomentLanguage {
	private static String[] months = new String[]{"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
	private static final String[] monthsShort = new String[]{"Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"};
	private static final String[] weekdays = new String[]{"Domingo","Segunda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira","Sábado"};
	private static final String[] weekdaysShort = new String[]{"Dom","Seg","Ter","Qua","Qui","Sex","Sáb"};
	private static final String[] weekdaysMin = new String[]{"Dom","2ª","3ª","4ª","5ª","6ª","Sáb"};

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