package com.ukamby.momentj;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MomentPatterns {
	//ASP.NET json date format regex
	public static final Pattern ASP_NET_JSON_REGEX = Pattern.compile("^\\/?Date\\((\\-?\\d+)", Pattern.CASE_INSENSITIVE);
	
	public static final Pattern ASP_NET_TIME_SPAN_JSON_REGEX = Pattern.compile("(\\-)?(\\d*)?\\.?(\\d+)\\:(\\d+)\\:(\\d+)\\.?(\\d{3})?");

	//format tokens
	public static final Pattern FORMATTING_TOKENS = Pattern.compile("(\\[[^\\[]*\\])|(\\\\)?(Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|YYYYY|YYYY|YY|gg(ggg?)?|GG(GGG?)?|e|E|a|A|hh?|HH?|mm?|ss?|SS?S?|X|zz?|ZZ?|.)");
	public static final Pattern LOCAL_FORMATTING_TOKENS = Pattern.compile("(\\[[^\\[]*\\])|(\\\\)?(LT|LL?L?L?|l{1,4})");

	//parsing tokens
	public static final Pattern PARSE_MULTIPLE_FORMAT_CHUNKER = Pattern.compile("([0-9a-zA-Z\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]+)", Pattern.CASE_INSENSITIVE);

	//parsing token regexes
	public static final Pattern PARSE_TOKEN_ONE_OR_TWO_DIGITS = Pattern.compile("\\d\\d?"); // 0 - 99
	public static final Pattern PARSE_TOKEN_ONE_TO_THREE_DIGITS = Pattern.compile("\\d{1,3}"); // 0 - 999
	public static final Pattern PARSE_TOKEN_THREE_DIGITS = Pattern.compile("\\d{3}"); // 000 - 999
	public static final Pattern PARSE_TOKEN_FOUR_DIGITS = Pattern.compile("\\d{1,4}"); // 0 - 9999
	public static final Pattern PARSE_TOKEN_SIX_DIGITS = Pattern.compile("[+\\-]?\\d{1,6}"); // -999,999 - 999,999
	public static final Pattern PARSE_TOKEN_WORD = Pattern.compile("[0-9]*[a-z\\u00A0-\\u05FF\\u0700-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]+|[\\u0600-\\u06FF\\/]+(\\s*?[\\u0600-\\u06FF]+){1,2}", Pattern.CASE_INSENSITIVE); // any word (or two) characters or numbers including two/three word month in arabic.
	public static final Pattern PARSE_TOKEN_TIMEZONE = Pattern.compile("Z|[\\+\\-]\\d\\d:?\\d\\d", Pattern.CASE_INSENSITIVE); // +00:00 -00:00 +0000 -0000 or Z
	public static final Pattern PARSE_TOKEN_T = Pattern.compile("T", Pattern.CASE_INSENSITIVE); // T (ISO seperator)
	public static final Pattern PARSE_TOKEN_TIMESTAMP_MS = Pattern.compile("[\\+\\-]?\\d+(\\.\\d{1,3})?"); // 123456789 123456789.123

	//preliminary iso regex
	//0000-00-00 + T + 00 or 00:00 or 00:00:00 or 00:00:00.000 + +00:00 or +0000
	public static final Pattern ISO_REGEC = Pattern.compile("^\\s*\\d{4}-\\d\\d-\\d\\d((T| )(\\d\\d(:\\d\\d(:\\d\\d(\\.\\d\\d?\\d?)?)?)?)?([\\+\\-]\\d\\d:?\\d\\d)?)?");
	public static final String ISO_FORMAT = "YYYY-MM-DDTHH:mm:ssZ";

	//iso time formats and regexes
	public static final Map<String, Pattern> ISO_TIMES =  createIsoTimesHashMap(); 
	private static final Map<String, Pattern> createIsoTimesHashMap() {
		Map<String, Pattern> map = new HashMap<>(4);
		map.put("HH:mm:ss.S", Pattern.compile("(T| )\\d\\d:\\d\\d:\\d\\d\\.\\d{1,3}"));
		map.put("HH:mm:ss", Pattern.compile("(T| )\\d\\d:\\d\\d:\\d\\d"));
		map.put("HH:mm", Pattern.compile("(T| )\\d\\d:\\d\\d"));
		map.put("HH", Pattern.compile("(T| )\\d\\d"));
		return map;
	}

	//timezone chunker "+10:00" > ["10", "00"] or "-1530" > ["-15", "30"]
	public static final Pattern PARSE_TIMEZONE_CHUNKER = Pattern.compile("([\\+\\-]|\\d\\d)", Pattern.CASE_INSENSITIVE);

	public static final Map<String, Double> UNIT_MILLISECOND_FACTORS = createUnitMillisecondFactors();
	private static Map<String, Double> createUnitMillisecondFactors() {
		Map<String, Double> map = new HashMap<String, Double>(7);
		map.put("Milliseconds", 1d);
		map.put("Seconds", 1e3);
		map.put("Minutes", 6e4);
		map.put("Hours", 36e5);
		map.put("Days", 864e5);
		map.put("Months", 2592e6);
		map.put("Years", 31536e6);
		return map;
	}
	
	public static final Map<String, String> UNIT_ALIASES = createUnitAliases();
	private static Map<String, String> createUnitAliases() {
		Map<String, String> map = new HashMap<String, String>(7);
		map.put("ms", "millisecond");
		map.put("s", "second");
		map.put("m", "minute");
		map.put("h", "hour");
		map.put("d", "day");
		map.put("w", "week");
		map.put("M", "month");
		map.put("y", "year");
		return map;
	}

	//tokens to ordinalize and pad
	public static final String[] ORDINALIZE_TOKENS = new String[] { "DDD", "w", "W", "M", "D", "d" };
	public static final char[] PADDED_TOKENS = new char[] {'M', 'D', 'H', 'h', 'm', 's', 'w', 'W'};
	
}
