package com.ukamby.momentj.languages;

import com.ukamby.momentj.Moment;
import com.ukamby.momentj.utils.MomentUtils;
import com.ukamby.momentj.utils.WeekYear;

import java.util.Map;
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
public abstract class MomentLanguage {
    public static final Pattern DATE_PARTS = Pattern.compile("MMMM|MM|DD|dddd");

    abstract String[] getMonths();
    abstract String[] getMonthsShort();
    abstract String[] getWeekdays();
    abstract String[] getWeekdaysShort();
    abstract String[] getWeekdaysMin();
    abstract Map<String, String> getLongDateFormat();
    abstract Map<String, String> getCalendar();
    public abstract String getMeridiem(int hours, int minutes, boolean isLower);
    abstract Map<String, String> getRelativeTime();
    protected String getOrdinal(){return "%d";}
    protected String preparse(String value){return value;}
    protected String postformat(String value){return value;}
    abstract Map<String, Integer> getWeek();

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

    /**
     * Convert the MomentJS specific date format string e.g. L to a more general date format string e.g. DD/MM/YYYY
     */
    public String longDateFormat(String format){
        Map<String, String> longDateFormat = getLongDateFormat();
        String output = longDateFormat.get(format);
        if (output == null && longDateFormat.get(format.toUpperCase()) != null ) {
            output = longDateFormat.get(format.toUpperCase());
        }
        return output;
    }

    /**
     * Map a term such as nextDay to actual formats such as [Tomorrow at] LT.
     */
    public String calendar(String format, Moment m){
        return getCalendar().get(format);
    }

    public String relativeTime(String numberValue, String withoutSuffix, String key, boolean isFuture){
        String output = getRelativeTime().get(key);
        return output.replace("%d", numberValue);
    }

    public String pastFuture(int diff, String output){
        String format = this.getRelativeTime().get(diff > 0 ? "future" : "past");
        return format.replace("%s", output);
    }

    public String ordinal(int number){
        return getOrdinal().replace("%d", Integer.toString(number));
    }

    public WeekYear week(Moment mom){
        return MomentUtils.weekOfYear(mom, getWeek().get("dow"), getWeek().get("doy"));
    }
}
