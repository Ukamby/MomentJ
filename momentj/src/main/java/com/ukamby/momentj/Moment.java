package com.ukamby.momentj;

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
    private long value;
    private Moment(long value) {
        this.value = value;
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
        return new Moment(System.currentTimeMillis());
    }

    /**
     * Return the unix epoch value of the moment.
     */
    public long toUnixEpoch() {
        return value;
    }
}
