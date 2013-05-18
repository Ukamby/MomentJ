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
     * Create a new moment based on the epoch value (ticks since Unix was created).
     *
     * @param epoch The epoch value.
     * @return A moment representing this epoch offset.
     */
    public static Moment fromUnixEpoch(long epoch) {
        return new Moment(epoch);
    }

    /**
     * Return the unix epoch value of the moment.
     */
    public long toUnixEpoch() {
        return value;
    }
}
