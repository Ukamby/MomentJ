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
     * @param epoch The epoch value.
     * @return A moment representing this epoch offset.
     */
    public static Moment moment(long epoch) {
        return new Moment(epoch);
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
