package com.ukamby.momentj;

import org.junit.Test;
import java.util.regex.Pattern;

import static com.ukamby.momentj.Moment.moment;

/**
 * Format Tests
 */
public class FormatTest extends JsTestBase {

/*    @Test
	public void formatYY() {
        test.expect(1);

        Moment b = moment(new Date(2009, 1, 14, 15, 25, 50, 125));
        test.equal(b.format("YY"), "09", "YY ---> 09");
        test.done();
    }

    @Test
	public void formatescapebrackets() {
        test.expect(9);

        moment.lang("en");

        Moment b = moment(new Date(2009, 1, 14, 15, 25, 50, 125));
        test.equal(b.format("[day]"), "day", "Single bracket");
        test.equal(b.format("[day] YY [YY]"), "day 09 YY", "Double bracket");
        test.equal(b.format("[YY"), "[09", "Un-ended bracket");
        test.equal(b.format("[[YY]]"), "[YY]", "Double nested brackets");
        test.equal(b.format("[[]"), "[", "Escape open bracket");
        test.equal(b.format("[Last]"), "Last", "localized tokens");
        test.equal(b.format("[L] L"), "L 02/14/2009", "localized tokens with escaped localized tokens");
        test.equal(b.format("[L LL LLL LLLL aLa]"), "L LL LLL LLLL aLa", "localized tokens with escaped localized tokens");
        test.equal(b.format("[LLL] LLL"), "LLL February 14 2009 3:25 PM", "localized tokens with escaped localized tokens (recursion)");
        test.done();
    }

    @Test
	public void formatmilliseconds() {
        test.expect(6);
        Moment b = moment(new Date(2009, 1, 14, 15, 25, 50, 123));
        test.equal(b.format("S"), "1", "Deciseconds");
        test.equal(b.format("SS"), "12", "Centiseconds");
        test.equal(b.format("SSS"), "123", "Milliseconds");
        b.milliseconds(789);
        test.equal(b.format("S"), "7", "Deciseconds");
        test.equal(b.format("SS"), "78", "Centiseconds");
        test.equal(b.format("SSS"), "789", "Milliseconds");
        test.done();
    }

    @Test
	public void formattimezone() {
        test.expect(2);

        Moment b = moment(new Date(2010, 1, 14, 15, 25, 50, 125));
        String explanation = "moment().format(\"z\") = " + b.format("z") + " It should be something like \"PST\""
        if (moment().zone() == -60) {
            explanation += \"For UTC+1 this is a known issue, see https://github.com/timrwood/moment/issues/162\";
        }
        test.ok(b.format("Z").match(/^[\+\-]\d\d:\d\d$/), b.format("Z") + " should be something like \"+07:30\"");
        test.ok(b.format("ZZ").match(/^[\+\-]\d{4}$/), b.format("ZZ") + " should be something like \"+0700\"");
        test.done();
    }

    @Test
	public void formatmultiplewithzone() {
        test.expect(1);

        Moment b = moment("2012-10-08 -1200", ["YYYY ZZ", "YYYY-MM-DD ZZ"]);
        test.equals(b.format("YYYY-MM"), "2012-10", "Parsing multiple formats should not crash with different sized formats");
        test.done();
    }

    @Test
	public void isDST() {
        test.expect(2);

        int janOffset = new Date(2011, 0, 1).getTimezoneOffset();
        int julOffset = new Date(2011, 6, 1).getTimezoneOffset();
        boolean janIsDst = janOffset < julOffset;
        boolean julIsDst = julOffset < janOffset;
        Moment jan1 = moment([2011]);
        Moment jul1 = moment([2011, 6]);

        if (janIsDst && julIsDst) {
            test.ok(0, "January and July cannot both be in DST");
            test.ok(0, "January and July cannot both be in DST");
        } else if (janIsDst) {
            test.ok(jan1.isDST(), "January 1 is DST");
            test.ok(!jul1.isDST(), "July 1 is not DST");
        } else if (julIsDst) {
            test.ok(!jan1.isDST(), "January 1 is not DST");
            test.ok(jul1.isDST(), "July 1 is DST");
        } else {
            test.ok(!jan1.isDST(), "January 1 is not DST");
            test.ok(!jul1.isDST(), "July 1 is not DST");
        }
        test.done();
    }

    @Test
	public void unixtimestamp() {
        test.expect(4);

        Moment m = moment("1234567890.123", "X");
        test.equals(m.format("X"), "1234567890", "unix timestamp without milliseconds");
        test.equals(m.format("X.S"), "1234567890.1", "unix timestamp with deciseconds");
        test.equals(m.format("X.SS"), "1234567890.12", "unix timestamp with centiseconds");
        test.equals(m.format("X.SSS"), "1234567890.123", "unix timestamp with milliseconds");

        test.done();
    }

    @Test
	public void zone() {
        test.expect(3);

        if (moment().zone() > 0) {
            test.ok(moment().format("ZZ").indexOf("-") > -1, "When the zone() offset is greater than 0, the ISO offset should be less than zero");
        }
        if (moment().zone() < 0) {
            test.ok(moment().format("ZZ").indexOf("+") > -1, "When the zone() offset is less than 0, the ISO offset should be greater than zero");
        }
        if (moment().zone() == 0) {
            test.ok(moment().format("ZZ").indexOf("+") > -1, "When the zone() offset is equal to 0, the ISO offset should be positive zero");
        }
        if (moment().zone() == 0) {
            test.equal(moment().zone(), 0, "moment.fn.zone should be a multiple of 15 (was " + moment().zone() + ")");
        } else {
            test.equal(moment().zone() % 15, 0, "moment.fn.zone should be a multiple of 15 (was " + moment().zone() + ")");
        }
        test.equal(moment().zone(), new Date().getTimezoneOffset(), "zone should equal getTimezoneOffset");
        test.done();
    }

    @Test
	public void defaultformat() {
        test.expect(1);
        Pattern isoRegex = Pattern.compile("\d{4}.\d\d.\d\dT\d\d.\d\d.\d\d[\+\-]\d\d:\d\d");
        test.ok(isoRegex.exec(moment().format()), \"default format (\" + moment().format() + \") should match ISO\");
        test.done();
    }

    @Test
	public void escapingquotes() {
        test.expect(4);
        moment.lang("en");
        Moment date = moment([2012, 0]);
        test.equal(date.format("MMM \"YY"), \"Jan "12\", \"Should be able to format with single parenthesis\");
        test.equal(date.format("MMM \"YY"),  "Jan \"12", \"Should be able to format with double parenthesis\");
        test.equal(date.format(\"MMM "YY\"),  \"Jan "12\", \"Should be able to format with single parenthesis\");
        test.equal(date.format(\"MMM \\"YY\"), "Jan \"12", \"Should be able to format with double parenthesis\");
        test.done();
    }

    @Test
	public void toJSON() {
        var supportsJson = typeof JSON !== \"undefined\" && JSON.stringify && JSON.stringify.call;
        Moment date = moment(\"2012-10-09T21:30:40.678+0100\");

        test.expect(supportsJson ? 2 : 1);

        test.equal(date.toJSON(), \"2012-10-09T20:30:40.678Z\", \"should output ISO8601 on moment.fn.toJSON\");
        test.equal(JSON.stringify({
            date : date
        }), "{\"date\":\"2012-10-09T20:30:40.678Z\"}", \"should output ISO8601 on JSON.stringify\");
        test.done();
    }

    @Test
	public void weeksformat() {

        // http://en.wikipedia.org/wiki/ISO_week_date
        var cases = {
            \"2005-01-02\": \"2004-53\",
            \"2005-12-31\": \"2005-52\",
            \"2007-01-01\": \"2007-01\",
            \"2007-12-30\": \"2007-52\",
            \"2007-12-31\": \"2008-01\",
            \"2008-01-01\": \"2008-01\",
            \"2008-12-28\": \"2008-52\",
            \"2008-12-29\": \"2009-01\",
            \"2008-12-30\": \"2009-01\",
            \"2008-12-31\": \"2009-01\",
            \"2009-01-01\": \"2009-01\",
            \"2009-12-31\": \"2009-53\",
            \"2010-01-01\": \"2009-53\",
            \"2010-01-02\": \"2009-53\",
            \"2010-01-03\": \"2009-53\"
        };

        for (var i in cases) {
            var iso = cases[i].split("-").pop();
            String the = moment(i).format("WW");
            test.equal(iso, the, i + \": should be \" + iso + \", but \" + the);
        }

        test.done();
    }

    @Test
	public void isoweekyearformats() {

        // http://en.wikipedia.org/wiki/ISO_week
        var cases = {
            \"2005-01-02\": \"2004-53\",
            \"2005-12-31\": \"2005-52\",
            \"2007-01-01\": \"2007-01\",
            \"2007-12-30\": \"2007-52\",
            \"2007-12-31\": \"2008-01\",
            \"2008-01-01\": \"2008-01\",
            \"2008-12-28\": \"2008-52\",
            \"2008-12-29\": \"2009-01\",
            \"2008-12-30\": \"2009-01\",
            \"2008-12-31\": \"2009-01\",
            \"2009-01-01\": \"2009-01\",
            \"2009-12-31\": \"2009-53\",
            \"2010-01-01\": \"2009-53\",
            \"2010-01-02\": \"2009-53\",
            \"2010-01-03\": \"2009-53\"
        };

        for (var i in cases) {
            var isoWeekYear = cases[i].split("-")[0];
            String formatted5 = moment(i).format("GGGGG");
            test.equal("0" + isoWeekYear, formatted5, i + \": should be \" + isoWeekYear + \", but \" + formatted4);
            String formatted4 = moment(i).format("GGGG");
            test.equal(isoWeekYear, formatted4, i + \": should be \" + isoWeekYear + \", but \" + formatted4);
            String formatted2 = moment(i).format("GG");
            test.equal(isoWeekYear.slice(2, 4), formatted2, i + \": should be \" + isoWeekYear + \", but \" + formatted2);
        }

        test.done();
    }

    @Test
	public void weekyearformats() {

        // http://en.wikipedia.org/wiki/ISO_week
        var cases = {
            \"2005-01-02\": \"2004-53\",
            \"2005-12-31\": \"2005-52\",
            \"2007-01-01\": \"2007-01\",
            \"2007-12-30\": \"2007-52\",
            \"2007-12-31\": \"2008-01\",
            \"2008-01-01\": \"2008-01\",
            \"2008-12-28\": \"2008-52\",
            \"2008-12-29\": \"2009-01\",
            \"2008-12-30\": \"2009-01\",
            \"2008-12-31\": \"2009-01\",
            \"2009-01-01\": \"2009-01\",
            \"2009-12-31\": \"2009-53\",
            \"2010-01-01\": \"2009-53\",
            \"2010-01-02\": \"2009-53\",
            \"2010-01-03\": \"2009-53\"
        };

        moment.lang("en-gb"); // 1, 4
        for (var i in cases) {
            var isoWeekYear = cases[i].split("-")[0];
            String formatted5 = moment(i).format("ggggg");
            test.equal("0" + isoWeekYear, formatted5, i + \": should be \" + isoWeekYear + \", but \" + formatted4);
            String formatted4 = moment(i).format("gggg");
            test.equal(isoWeekYear, formatted4, i + \": should be \" + isoWeekYear + \", but \" + formatted4);
            String formatted2 = moment(i).format("gg");
            test.equal(isoWeekYear.slice(2, 4), formatted2, i + \": should be \" + isoWeekYear + \", but \" + formatted2);
        }

        test.done();
    }

    @Test
	public void isoweekdayformats() {
        test.expect(7);

        test.equal(moment([1985, 1,  4]).format("E"), "0", \"Feb  4 1985 is Monday    -- 0th day\");
        test.equal(moment([2029, 8, 18]).format("E"), "1", \"Sep 18 2029 is Tuesday   -- 1st day\");
        test.equal(moment([2013, 3, 24]).format("E"), "2", \"Apr 24 2013 is Wednesday -- 2nd day\");
        test.equal(moment([2015, 2,  5]).format("E"), "3", \"Mar  5 2015 is Thursday  -- 3nd day\");
        test.equal(moment([1970, 0,  2]).format("E"), "4", \"Jan  2 1970 is Friday    -- 4th day\");
        test.equal(moment([2001, 4, 12]).format("E"), "5", \"May 12 2001 is Saturday  -- 5th day\");
        test.equal(moment([2000, 0,  2]).format("E"), "6", \"Jan  2 2000 is Sunday    -- 6th day\");

        test.done();
    }

    @Test
	public void weekdayformats() {
        test.expect(7);

        moment.lang("dow:3,doy:5", {week: {dow: 3, doy: 5}});
        test.equal(moment([1985, 1,  6]).format("e"), "0", \"Feb  6 1985 is Wednesday -- 0th day\");
        test.equal(moment([2029, 8, 20]).format("e"), "1", \"Sep 20 2029 is Thursday  -- 1st day\");
        test.equal(moment([2013, 3, 26]).format("e"), "2", \"Apr 26 2013 is Friday    -- 2nd day\");
        test.equal(moment([2015, 2,  7]).format("e"), "3", \"Mar  7 2015 is Saturday  -- 3nd day\");
        test.equal(moment([1970, 0,  4]).format("e"), "4", \"Jan  4 1970 is Sunday    -- 4th day\");
        test.equal(moment([2001, 4, 14]).format("e"), "5", \"May 14 2001 is Monday    -- 5th day\");
        test.equal(moment([2000, 0,  4]).format("e"), "6", \"Jan  4 2000 is Tuesday   -- 6th day\");

        test.done()
    }

    @Test
	public void toStringisjusthumanreadableformat() {
        test.expect(1);

        Moment b = moment(new Date(2009, 1, 5, 15, 25, 50, 125));
        test.equal(b.toString(), b.format("ddd MMM DD YYYY HH:mm:ss [GMT]ZZ"));
        test.done();
    }

    @Test
	public void toJSONskipspostformat() {
        test.expect(1);

        moment.lang("postformat", {postformat: function(s) { s.replace(/./g, "X") }});
        test.equal(moment.utc([2000, 0, 1]).toJSON(), \"2000-01-01T00:00:00.000Z\", \"toJSON doesn"t postformat\");
        test.done();
    }
*/}