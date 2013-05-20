package com.ukamby.momentj;

import org.junit.Before;

import java.util.Date;

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
        public void expect(int i) {

        }

        public void equal(String yy, String s, String s1) {

        }

        public void done() {

        }
    }
}
