package com.ukamby.momentj;

import org.junit.Test;

import java.util.Date;

import static com.ukamby.momentj.Moment.moment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: luke
 * Date: 18/05/13
 * Time: 5:01 PM
 */
public class MomentTest {
    @Test
    public void constructFromEpochMilliseconds(){
        Date now = new Date();
        long epoch = now.getTime();
        Moment m = moment(epoch);

        assertEquals(epoch, m.toUnixEpoch());
    }

    @Test
    public void constructFromEpochSeconds(){
        Moment m = Moment.unix(237691800l);

        assertEquals(237691800000l, m.toUnixEpoch());
    }

    @Test
    public void getCurrentMoment(){
        long currentEpochTimestamp = System.currentTimeMillis();
        Moment m = moment();

        assertTrue(m.toUnixEpoch() > 0);
        assertTrue(m.toUnixEpoch() >= currentEpochTimestamp);
        assertTrue(m.toUnixEpoch() < Long.MAX_VALUE);
    }
}
