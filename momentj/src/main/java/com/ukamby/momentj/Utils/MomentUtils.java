package com.ukamby.momentj.utils;

import com.ukamby.momentj.Moment;

import static com.ukamby.momentj.Moment.moment;

/**
 * Global functions that were declared on the self-executing function and referenced as closures all over MomentJS.
 *
 * User: luke
 * Date: 28/05/13
 * Time: 9:57 PM
 */
public class MomentUtils {

    /**
     * Week of year calculator.
     *
     * @param mom The moment for which to determine the week number.
     * @param firstDayOfWeek firstDayOfWeek 0 = sun, 6 = sat, the day of the week that starts the week (usually sunday or monday)
     * @param firstDayOfWeekOfYear firstDayOfWeekOfYear 0 = sun, 6 = sat the first week is the week that contains the first of this day of the week (eg. ISO weeks use thursday (4))
     * @return The week number of the given moment.
     */
    public static WeekYear weekOfYear(Moment mom, int firstDayOfWeek, int firstDayOfWeekOfYear) {
        int end = firstDayOfWeekOfYear - firstDayOfWeek,
                daysToDayOfWeek = firstDayOfWeekOfYear - mom.day();

        if (daysToDayOfWeek > end) {
            daysToDayOfWeek -= 7;
        }

        if (daysToDayOfWeek < end - 7) {
            daysToDayOfWeek += 7;
        }

        Moment adjustedMoment = moment(mom).add("d", daysToDayOfWeek);
        return new WeekYear(
                (int) Math.ceil(adjustedMoment.dayOfYear() / 7),
                adjustedMoment.year()
        );
    }


}
