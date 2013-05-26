package com.ukamby.momentj;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * User: luke
 * Date: 20/05/13
 * Time: 4:30 PM
 */
public class JsTestBase {

    protected Moment moment;
    protected TestHelper test;

    @Before
    public void setup() {
        test = new TestHelper();
        moment = Moment.moment();
    }

    protected Moment moment(String s, String x) {
        return null;
    }
    protected Moment moment() {
        return null;
    }

    protected Moment moment(Date date) {
        return null;
    }

    protected static class TestHelper {
        private Integer expectedTestCount = null;
        private int actualTestCount = 0;

        public TestHelper expect(int expectedTestCount) {
            this.expectedTestCount = expectedTestCount;
            return this;
        }

        public TestHelper equal(String actual, String expected) {
            assertEquals(expected, actual);
            actualTestCount++;
            return this;
        }

        public TestHelper equal(String actual, String expected, String message) {
            assertEquals(message, expected, actual);
            actualTestCount++;
            return this;
        }

        public TestHelper done() {
            if( expectedTestCount != null ){
                assertEquals("Didn't assert expected number of test cases.", (int)expectedTestCount, actualTestCount);
            }
            return this;
        }

        public TestHelper ok() {
            // todo
            return this;
        }

        public TestHelper ok(boolean dst, String s) {
            // todo
            return this;
        }

        public TestHelper ok(int i, String s) {
            // todo
            return this;
        }

        public void equals(String x, String s, String s1) {
            // todo
        }
    }
}
