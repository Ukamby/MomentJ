package com.ukamby.momentj.languages;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: luke
 * Date: 28/05/13
 * Time: 10:55 PM
 */
public class LanguageConverter {
    private static final Pattern languageSpecifierLine = Pattern.compile(".+\\.lang\\('(.+)'.+");

    private static final String monthsInput = ".+months\\s*[:=]\\s*[\"'](.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)[\"']\\s*\\.split\\([\"']_[\"']\\).+";
    private static final String monthsOutput = "\tprivate static String\\[\\] months = new String\\[\\]\\{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\",\"$8\",\"$9\",\"$10\",\"$11\",\"$12\"\\};";
    private static final String monthsShortInput = ".+monthsShort\\s*[:=]\\s*[\"'](.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)[\"']\\s*\\.split\\([\"']_[\"']\\).+";
    private static final String monthsShortOutput = "\tprivate static final String[] monthsShort = new String[]{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\",\"$8\",\"$9\",\"$10\",\"$11\",\"$12\"};";
    private static final String weekdaysInput = ".+weekdays\\s*[:=]\\s*[\"'](.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)[\"']\\s*\\.split\\([\"']_[\"']\\).+";
    private static final String weekdaysOutput = "\tprivate static final String[] weekdays = new String[]{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\"};";
    private static final String weekdaysShortInput = ".+weekdaysShort\\s*[:=]\\s*[\"'](.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)[\"']\\s*\\.split\\([\"']_[\"']\\).+";
    private static final String weekdaysShortOutput = "\tprivate static final String[] weekdaysShort = new String[]{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\"};";
    private static final String weekdaysMinInput = ".+weekdaysMin\\s*[:=]\\s*[\"'](.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)[\"']\\s*\\.split\\([\"']_[\"']\\).+";
    private static final String weekdaysMinOutput = "\tprivate static final String[] weekdaysMin = new String[]{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\"};";

    public static void main(String[] args) throws IOException {
        String inputDir = args[0]; //e.g. /Users/luke/MomentJ/momentj/src/test/resources/languages
        String outputDir = args[1]; //e.g. /Users/luke/MomentJ/momentj/src/main/java/com/ukamby/momentj/languages

        Path inputDirFiles = Paths.get(inputDir);
        for( Path inputPath : Files.newDirectoryStream(inputDirFiles, "*.js")) {
            List<String> lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));
            String language = getLanguage(lines);

            String className = "MomentLanguage" + language.toUpperCase().replace("-", "_");
            Path outputFile = Paths.get(outputDir, className + ".java");

            Date writeDate = new Date();
            String formattedDate = writeDate.getDate() + "/" + (1 + writeDate.getMonth()) + "/" + (1900 + writeDate.getYear());

            String formattedClassPrefix = String.format(classPrefix, language, formattedDate, className);

            List<String> outputLines = new ArrayList<>();
            outputLines.addAll(Arrays.asList(formattedClassPrefix.split("\\n")));

            boolean matchedMonths = false, matchedMonthsShort = false, matchedWeekdays = false, matchedWeekdaysShort = false, matchedWeekdaysMin = false;
            for (String line : lines) {
                if( line.matches(monthsInput) ){
                    outputLines.add(line.replaceAll(monthsInput, monthsOutput));
                    matchedMonths = true;
                }
                if( line.matches(monthsShortInput) ){
                    outputLines.add(line.replaceAll(monthsShortInput, monthsShortOutput));
                    matchedMonthsShort = true;
                }
                if( line.matches(weekdaysInput) ){
                    outputLines.add(line.replaceAll(weekdaysInput, weekdaysOutput));
                    matchedWeekdays = true;
                }
                if( line.matches(weekdaysShortInput) ){
                    outputLines.add(line.replaceAll(weekdaysShortInput, weekdaysShortOutput));
                    matchedWeekdaysShort = true;
                }
                if( line.matches(weekdaysMinInput) ){
                    outputLines.add(line.replaceAll(weekdaysMinInput, weekdaysMinOutput));
                    matchedWeekdaysMin = true;
                }
            }


//            outputLines.add("    private static final Map<String, String> longDateFormat = createLongDateFormat();");
//            outputLines.add("    private static final Map<String, String> calendar = createCalendar();");
//            outputLines.add("    private static final Map<String, String> relativeTime = createRelativeTime();");
            outputLines.add("    private static final Map<String, Integer> week = createWeek();");
            outputLines.add("");

            outputLines.add("    /**");
            outputLines.add("     * dow : The first day of the week.");
            outputLines.add("     * doy : The day number of the day in which the first week of the year occurs for this locale.");
            outputLines.add("     */");
            outputLines.add("    private static final Map<String, Integer> createWeek() {");
            outputLines.add("        Map<String, Integer> map = new HashMap<>();");
            outputLines.add(String.format("        map.put(\"dow\", %s);", getDow(lines, language)));
            outputLines.add(String.format("        map.put(\"doy\", %s);", getDoy(lines, language)));
            outputLines.add("        return Collections.unmodifiableMap(map);");
            outputLines.add("    }");
            outputLines.add("    ");



            outputLines.add("");
            if( matchedMonths ){
                outputLines.add("    @Override");
                outputLines.add("    String[] getMonths() {");
                outputLines.add("        return months;");
                outputLines.add("    }");
            }else{
                outputLines.add("    abstract String[] getMonths();");
            }

            outputLines.add("");
            if( matchedMonthsShort ){
                outputLines.add("    @Override");
                outputLines.add("    String[] getMonthsShort() {");
                outputLines.add("        return monthsShort;");
                outputLines.add("    }");
            }else{
                outputLines.add("    abstract String[] getMonthsShort();");
            }

            outputLines.add("");
            if( matchedWeekdays ){
                outputLines.add("    @Override");
                outputLines.add("    String[] getWeekdays() {");
                outputLines.add("        return weekdays;");
                outputLines.add("    }");
            }else{
                outputLines.add("    abstract String[] getWeekdays();");
            }

            outputLines.add("");
            if( matchedWeekdaysShort ){
                outputLines.add("    @Override");
                outputLines.add("    String[] getWeekdaysShort() {");
                outputLines.add("        return weekdaysShort;");
                outputLines.add("    }");
            }else{
                outputLines.add("    abstract String[] getWeekdaysShort();");
            }

            outputLines.add("");
            if( matchedWeekdaysMin ){
                outputLines.add("    @Override");
                outputLines.add("    String[] getWeekdaysMin() {");
                outputLines.add("        return weekdaysMin;");
                outputLines.add("    }");
            }else{
                outputLines.add("    abstract String[] getWeekdaysMin();");
            }

            if( !matchedMonths || !matchedMonthsShort || !matchedWeekdays || !matchedWeekdaysShort || !matchedWeekdaysMin ){
                System.out.println("This language file needs special treatment of the basic constants: " + className);
            }

            outputLines.addAll(Arrays.asList(classSuffix.split("\\n")));

            Files.write(outputFile, outputLines, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        }
    }

    private static String getDoy(List<String> lines, String locale) {
        //iterate the lines to find the day of year
        for( String line : lines ){
            String trimmed = line.trim();
            if( trimmed.startsWith("doy") ){

            }
        }
        System.out.println("Defaulting on doy for locale " + locale);
        return "6";
    }

    private static String getDow(List<String> lines, String locale) {
        //todo: iterate the lines to find the day of week
        System.out.println("Defaulting on dow for locale " + locale);
        return "0";
    }

    private static String getLanguage(List<String> lines) {
        String language = "";
        for (String line : lines) {
            Matcher languageMatcher = languageSpecifierLine.matcher(line);
            if( languageMatcher.matches() ){
                language = languageMatcher.group(1);
            }
        }
        return language;
    }

    private static String classPrefix = "package com.ukamby.momentj.languages;\n" +
            "\n" +
            "import java.util.Collections;\n" +
            "import java.util.HashMap;\n" +
            "import java.util.Map;\n" +
            "\n" +
            "/**\n" +
            " * %s language constants for MomentJ.\n" +
            " *\n" +
            " * User: luke\n" +
            " * Date: %s\n" +
            " */\n" +
            "public abstract class %s extends MomentLanguage {\n"; //extends MomentLanguage

    private static String classSuffix = "\n" +
//            "    @Override\n" +
//            "    Map<String, String> getLongDateFormat() {\n" +
//            "        return longDateFormat;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    Map<String, String> getCalendar() {\n" +
//            "        return calendar;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    Map<String, String> getRelativeTime() {\n" +
//            "        return relativeTime;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    Map<String, Integer> getWeek() {\n" +
//            "        return week;\n" +
//            "    }\n" +
            "}\n";
}
