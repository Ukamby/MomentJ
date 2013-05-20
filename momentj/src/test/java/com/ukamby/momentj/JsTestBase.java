package com.ukamby.momentj;

import org.junit.Before;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * User: luke
 * Date: 20/05/13
 * Time: 4:30 PM
 */
public class JsTestBase {
    protected TestHelper test;

    @Before
    public void setup() {
        test = new TestHelper();
    }

    protected Date dateWithMilliseconds(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Date date = new Date(year, month, day, hour, minute, second);
        date.setTime(date.getTime() + millisecond);
        return date;
    }

    protected static class TestHelper {
        private Integer expectedTestCount = null;
        private int actualTestCount = 0;

        public void expect(int expectedTestCount) {
            this.expectedTestCount = expectedTestCount;
        }

        public void equal(String actual, String expected, String message) {
            assertEquals(message, expected, actual);
            actualTestCount++;
        }

        public void done() {
            if( expectedTestCount != null ){
                assertEquals("Didn't assert expected number of test cases.", (int)expectedTestCount, actualTestCount);
            }
        }
    }
}
