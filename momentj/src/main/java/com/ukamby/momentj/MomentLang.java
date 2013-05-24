package com.ukamby.momentj;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides localised strings for date/time parsing per locale.
 *
 * To convert arrays from the JS, use this regex:
 * e.g. source: Jan_Feb_Mar_Apr_May_Jun_Jul_Aug_Sep_Oct_Nov_Dec
 * Regex:       (.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)
 * Replace:     private static String[] monthsShort = new String[]\{"$1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12"};
 *
 * e.g. source  Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday
 * Regex:       (.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)
 * Replace:     private static String[] weekdays = new String[]\{"$1","$2","$3","$4","$5","$6","$7"};
 *
 * User: luke
 * Date: 24/05/13
 * Time: 8:47 PM
 */
public abstract class MomentLang {

    public static final Pattern DATE_PARTS = Pattern.compile("MMMM|MM|DD|dddd");

    abstract String[] getMonths();
    abstract String[] getMonthsShort();
    abstract String[] getWeekdays();
    abstract String[] getWeekdaysShort();
    abstract String[] getWeekdaysMin();
    abstract Map<String, String> getLongDateFormat();

    public String months(Moment m){
        return getMonths()[m.month()];
    }

    public String monthsShort(Moment m){
        return getMonthsShort()[m.month()];
    }

    public Integer monthsParse (String monthName){
        String[] months = getMonths();
        for( int i = 0; i < 12; i++ ){
            if( months[i].equalsIgnoreCase(monthName) || months[i].equalsIgnoreCase(monthName) ){
                return i;
            }
        }
        return null;
    }

    public String weekdays(Moment m){
        return getWeekdays()[m.day()];
    }

    public String weekdaysShort(Moment m){
        return getWeekdaysShort()[m.day()];
    }

    public String weekdaysMin(Moment m){
        return getWeekdaysMin()[m.day()];
    }
//
//    public String longDateFormat(String key){
//        Map<String, String> longDateFormat = getLongDateFormat();
//        String output = longDateFormat.get(key);
//        if (output == null && longDateFormat.get(key.toUpperCase()) != null ) {
//            String format = longDateFormat.get(key.toUpperCase());
//            Matcher matcher = DATE_PARTS.matcher(format);
//            while( matcher.find() ){
//                System.out.println(format.substring(matcher.start(), matcher.end()));
//            }
//            output = format.replace(DATE_PARTS, /g, function (val) {
//                return val.slice(1);
//            });
//            longDateFormat.put(key, output);
//        }
//        return output;
//    }




    /*

        meridiem : function (hours, minutes, isLower) {
            if (hours > 11) {
                return isLower ? 'pm' : 'PM';
            } else {
                return isLower ? 'am' : 'AM';
            }
        },

        _calendar : {
            sameDay : '[Today at] LT',
                    nextDay : '[Tomorrow at] LT',
                    nextWeek : 'dddd [at] LT',
                    lastDay : '[Yesterday at] LT',
                    lastWeek : '[last] dddd [at] LT',
                    sameElse : 'L'
        },
        calendar : function (key, mom) {
            var output = this._calendar[key];
            return typeof output === 'function' ? output.apply(mom) : output;
        },

        _relativeTime : {
            future : "in %s",
                    past : "%s ago",
                    s : "a few seconds",
                    m : "a minute",
                    mm : "%d minutes",
                    h : "an hour",
                    hh : "%d hours",
                    d : "a day",
                    dd : "%d days",
                    M : "a month",
                    MM : "%d months",
                    y : "a year",
                    yy : "%d years"
        },
        relativeTime : function (number, withoutSuffix, string, isFuture) {
            var output = this._relativeTime[string];
            return (typeof output === 'function') ?
            output(number, withoutSuffix, string, isFuture) :
            output.replace(/%d/i, number);
        },
        pastFuture : function (diff, output) {
            var format = this._relativeTime[diff > 0 ? 'future' : 'past'];
            return typeof format === 'function' ? format(output) : format.replace(/%s/i, output);
        },

        ordinal : function (number) {
            return this._ordinal.replace("%d", number);
        },
        _ordinal : "%d",

                preparse : function (string) {
            return string;
        },

        postformat : function (string) {
            return string;
        },

        week : function (mom) {
            return weekOfYear(mom, this._week.dow, this._week.doy);
        },
        _week : {
            dow : 0, // Sunday is the first day of the week.
                    doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    };

    // Loads a language definition into the `languages` cache.  The function
    // takes a key and optionally values.  If not in the browser and no values
    // are provided, it will load the language file module.  As a convenience,
    // this function also returns the language values.
    function loadLang(key, values) {
        values.abbr = key;
        if (!languages[key]) {
            languages[key] = new Language();
        }
        languages[key].set(values);
        return languages[key];
    }

    // Determines which language definition to use and returns it.
    //
    // With no parameters, it will return the global language.  If you
    // pass in a language key, such as 'en', it will return the
    // definition for 'en', so long as 'en' has already been loaded using
    // moment.lang.
    function getLangDefinition(key) {
        if (!key) {
            return moment.fn._lang;
        }
        if (!languages[key] && hasModule) {
            require('./lang/' + key);
        }
        return languages[key];
    }
    */
}
