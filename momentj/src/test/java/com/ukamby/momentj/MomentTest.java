package com.ukamby.momentj;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * User: luke
 * Date: 18/05/13
 * Time: 5:01 PM
 */
public class MomentTest {
    @Test
    public void constructFromEpoch(){
        Date now = new Date();
        long epoch = now.getTime();
        Moment moment = Moment.fromUnixEpoch(epoch);

        assertEquals(epoch, moment.toUnixEpoch());
    }
}
