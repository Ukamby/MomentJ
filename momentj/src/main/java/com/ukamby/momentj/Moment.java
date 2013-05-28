package com.ukamby.momentj;

import com.ukamby.momentj.languages.MomentLanguage;
import com.ukamby.momentj.languages.MomentLanguageEn;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Moment represents a moment in time.
 *
 * It provides utilities for interacting with that moment.
 *
 * User: luke
 * Date: 18/05/13
 * Time: 5:00 PM
 */
public class Moment {
	public static final String VERSION = "0.1";
	private static MomentLanguage lang = new MomentLanguageEn();

    private long value;
    private Moment(long value) {
        this.value = value;
    }

    public static void setLanguage(MomentLanguage language){
        lang = language;
    }
    public static MomentLanguage getLanguage(){
        return lang;
    }

    /**
     * Create a new moment based on the unix epoch timestamp value in milliseconds (milliseconds since Jan 1, 1970 00:00:00.000 UTC).
     *
     * @param epochMillis The number of milliseconds since January 1st 1970, 00:00:00.000.
     * @return A moment representing this unix epoch offset.
     */
    public static Moment moment(long epochMillis) {
        return new Moment(epochMillis);
    }

    /**
     * Create a clone moment (a new instance of moment at the same point in time as the given moment).
     *
     * @param moment The moment to clone.
     */
    public static Moment moment(Moment moment) {
        return new Moment(moment.toUnixEpoch());
    }

    /**
     * Create a new moment based on a Date instance.
     *
     * @param date the date to base this moment on.
     * @return A moment representing the given date.
     */
    public static Moment moment(Date date) {
        return moment(date.getTime());
    }

    /**
     * Create a new moment based on a Calendar instance.
     *
     * @param calendar the calendar to base this moment on.
     * @return A moment representing the given calendar date.
     */
    public static Moment moment(Calendar calendar) {
        return moment(calendar.getTimeInMillis());
    }

    /**
     * Create a new moment based on the unix epoch timestamp value in seconds (seconds since Jan 1, 1970 00:00:00 UTC).
     *
     * @param epochSeconds The number of seconds since January 1st 1970, 00:00:00.
     * @return A moment representing this unix epoch offset.
     */
    public static Moment unix(long epochSeconds) {
        return moment(epochSeconds * 1000);
    }

    /**
     * Get the current moment right now.
     */
    public static Moment moment(){
        return moment(System.currentTimeMillis());
    }

    /**
     * Return the unix epoch value of the moment.
     */
    public long toUnixEpoch() {
        return value;
    }

    public String lang(String yy) {
        return "TODO";
    }
    public String format(String yy) {
        /*
        Relevant bits of javascript to implement this function from:
        https://raw.github.com/timrwood/moment/2.0.0/moment.js

        // format tokens
        formattingTokens = /(\[[^\[]*\])|(\\)?(Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|YYYYY|YYYY|YY|a|A|hh?|HH?|mm?|ss?|SS?S?|X|zz?|ZZ?|.)/g,
        localFormattingTokens = /(\[[^\[]*\])|(\\)?(LT|LL?L?L?|l{1,4})/g,

        format : function (inputString) {
            var output = formatMoment(this, inputString || moment.defaultFormat);
            return this.lang().postformat(output);
        },

        // format date using native date object
        function formatMoment(m, format) {
            var i = 5;

            function replaceLongDateFormatTokens(input) {
                return m.lang().longDateFormat(input) || input;
            }

            while (i-- && localFormattingTokens.test(format)) {
                format = format.replace(localFormattingTokens, replaceLongDateFormatTokens);
            }

            if (!formatFunctions[format]) {
                formatFunctions[format] = makeFormatFunction(format);
            }

            return formatFunctions[format](m);
        }

        function makeFormatFunction(format) {
            var array = format.match(formattingTokens), i, length;

            for (i = 0, length = array.length; i < length; i++) {
                if (formatTokenFunctions[array[i]]) {
                    array[i] = formatTokenFunctions[array[i]];
                } else {
                    array[i] = removeFormattingTokens(array[i]);
                }
            }

            return function (mom) {
                var output = "";
                for (i = 0; i < length; i++) {
                    output += typeof array[i].call === 'function' ? array[i].call(mom, format) : array[i];
                }
                return output;
            };
        }

        formatTokenFunctions = {
            M    : function () {
                return this.month() + 1;
            },
            MMM  : function (format) {
                return this.lang().monthsShort(this, format);
            },
            MMMM : function (format) {
                return this.lang().months(this, format);
            },
            D    : function () {
                return this.date();
            },
            DDD  : function () {
                return this.dayOfYear();
            },
            d    : function () {
                return this.day();
            },
            dd   : function (format) {
                return this.lang().weekdaysMin(this, format);
            },
            ddd  : function (format) {
                return this.lang().weekdaysShort(this, format);
            },
            dddd : function (format) {
                return this.lang().weekdays(this, format);
            },
            w    : function () {
                return this.week();
            },
            W    : function () {
                return this.isoWeek();
            },
            YY   : function () {
                return leftZeroFill(this.year() % 100, 2);
            },
            YYYY : function () {
                return leftZeroFill(this.year(), 4);
            },
            YYYYY : function () {
                return leftZeroFill(this.year(), 5);
            },
            a    : function () {
                return this.lang().meridiem(this.hours(), this.minutes(), true);
            },
            A    : function () {
                return this.lang().meridiem(this.hours(), this.minutes(), false);
            },
            H    : function () {
                return this.hours();
            },
            h    : function () {
                return this.hours() % 12 || 12;
            },
            m    : function () {
                return this.minutes();
            },
            s    : function () {
                return this.seconds();
            },
            S    : function () {
                return ~~(this.milliseconds() / 100);
            },
            SS   : function () {
                return leftZeroFill(~~(this.milliseconds() / 10), 2);
            },
            SSS  : function () {
                return leftZeroFill(this.milliseconds(), 3);
            },
            Z    : function () {
                var a = -this.zone(),
                    b = "+";
                if (a < 0) {
                    a = -a;
                    b = "-";
                }
                return b + leftZeroFill(~~(a / 60), 2) + ":" + leftZeroFill(~~a % 60, 2);
            },
            ZZ   : function () {
                var a = -this.zone(),
                    b = "+";
                if (a < 0) {
                    a = -a;
                    b = "-";
                }
                return b + leftZeroFill(~~(10 * a / 6), 4);
            },
            X    : function () {
                return this.unix();
            }
        };

        function removeFormattingTokens(input) {
            if (input.match(/\[.*\]/)) {
                return input.replace(/^\[|\]$/g, "");
            }
            return input.replace(/\\/g, "");
        }

        //built in language (English):

        Language.prototype = {
            set : function (config) {
                var prop, i;
                for (i in config) {
                    prop = config[i];
                    if (typeof prop === 'function') {
                        this[i] = prop;
                    } else {
                        this['_' + i] = prop;
                    }
                }
            },

            _months : "January_February_March_April_May_June_July_August_September_October_November_December".split("_"),
            months : function (m) {
                return this._months[m.month()];
            },

            _monthsShort : "Jan_Feb_Mar_Apr_May_Jun_Jul_Aug_Sep_Oct_Nov_Dec".split("_"),
            monthsShort : function (m) {
                return this._monthsShort[m.month()];
            },

            monthsParse : function (monthName) {
                var i, mom, regex, output;

                if (!this._monthsParse) {
                    this._monthsParse = [];
                }

                for (i = 0; i < 12; i++) {
                    // make the regex if we don't have it already
                    if (!this._monthsParse[i]) {
                        mom = moment([2000, i]);
                        regex = '^' + this.months(mom, '') + '|^' + this.monthsShort(mom, '');
                        this._monthsParse[i] = new RegExp(regex.replace('.', ''), 'i');
                    }
                    // test the regex
                    if (this._monthsParse[i].test(monthName)) {
                        return i;
                    }
                }
            },

            _weekdays : "Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),
            weekdays : function (m) {
                return this._weekdays[m.day()];
            },

            _weekdaysShort : "Sun_Mon_Tue_Wed_Thu_Fri_Sat".split("_"),
            weekdaysShort : function (m) {
                return this._weekdaysShort[m.day()];
            },

            _weekdaysMin : "Su_Mo_Tu_We_Th_Fr_Sa".split("_"),
            weekdaysMin : function (m) {
                return this._weekdaysMin[m.day()];
            },

            _longDateFormat : {
                LT : "h:mm A",
                L : "MM/DD/YYYY",
                LL : "MMMM D YYYY",
                LLL : "MMMM D YYYY LT",
                LLLL : "dddd, MMMM D YYYY LT"
            },
            longDateFormat : function (key) {
                var output = this._longDateFormat[key];
                if (!output && this._longDateFormat[key.toUpperCase()]) {
                    output = this._longDateFormat[key.toUpperCase()].replace(/MMMM|MM|DD|dddd/g, function (val) {
                        return val.slice(1);
                    });
                    this._longDateFormat[key] = output;
                }
                return output;
            },

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

        //german language file: https://raw.github.com/timrwood/moment/2.0.0/lang/de.js

        // moment.js language configuration
        // language : german (de)
        // author : lluchs : https://github.com/lluchs

        require('../moment').lang('de', {
            months : "Januar_Februar_März_April_Mai_Juni_Juli_August_September_Oktober_November_Dezember".split("_"),
            monthsShort : "Jan._Febr._Mrz._Apr._Mai_Jun._Jul._Aug._Sept._Okt._Nov._Dez.".split("_"),
            weekdays : "Sonntag_Montag_Dienstag_Mittwoch_Donnerstag_Freitag_Samstag".split("_"),
            weekdaysShort : "So._Mo._Di._Mi._Do._Fr._Sa.".split("_"),
            weekdaysMin : "So_Mo_Di_Mi_Do_Fr_Sa".split("_"),
            longDateFormat : {
                LT: "H:mm U\\hr",
                L : "DD.MM.YYYY",
                LL : "D. MMMM YYYY",
                LLL : "D. MMMM YYYY LT",
                LLLL : "dddd, D. MMMM YYYY LT"
            },
            calendar : {
                sameDay: "[Heute um] LT",
                sameElse: "L",
                nextDay: '[Morgen um] LT',
                nextWeek: 'dddd [um] LT',
                lastDay: '[Gestern um] LT',
                lastWeek: '[letzten] dddd [um] LT'
            },
            relativeTime : {
                future : "in %s",
                past : "vor %s",
                s : "ein paar Sekunden",
                m : "einer Minute",
                mm : "%d Minuten",
                h : "einer Stunde",
                hh : "%d Stunden",
                d : "einem Tag",
                dd : "%d Tagen",
                M : "einem Monat",
                MM : "%d Monaten",
                y : "einem Jahr",
                yy : "%d Jahren"
            },
            ordinal : '%d.',
            week : {
                dow : 1, // Monday is the first day of the week.
                doy : 4  // The week that contains Jan 4th is the first week of the year.
            }
        });

        */
        // todo
        return "TODO";
    }

    public void milliseconds(int i) {
        // todo
    }

    public int zone() {
        // todo
        return 0;
    }

    public void match(Pattern regex) {
        // todo
    }

    public boolean isDST() {
        // todo
        return false;
    }

    public int month() {
        return 0;  //return the month portion as an integer 0-11
    }

    public int day() {
        return 0;  //Return the weekday portion as an integer 0-6 where 0 = Sunday
    }

    public Moment add(String measure, int amount) {
        if( "d".equals(measure) ){
            return new Moment(value + amount * 24 * 60 * 60 * 1000);
        }else{
            throw new RuntimeException("not implemented");
        }
    }

    public int dayOfYear() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public int year() {
        return 0;//To change body of created methods use File | Settings | File Templates.
    }
}
