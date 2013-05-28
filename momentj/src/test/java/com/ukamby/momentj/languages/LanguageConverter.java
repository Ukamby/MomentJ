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

    private static final String monthsInput = ".+months : \"(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)_(.+)\"\\.split\\(\"_\"\\),";
    private static final String monthsOutput = "\tprivate static String\\[\\] months = new String\\[\\]\\{\"$1\",\"$2\",\"$3\",\"$4\",\"$5\",\"$6\",\"$7\",\"$8\",\"$9\",\"$10\",\"$11\",\"$12\"\\};";


    public static void main(String[] args) throws IOException {
        String inputDir = args[0]; //e.g. /Users/luke/MomentJ/momentj/src/test/resources/languages
        String outputDir = args[1]; //e.g. /Users/luke/MomentJ/momentj/src/main/java/com/ukamby/momentj/languages

        Path inputDirFiles = Paths.get(inputDir);
        for( Path inputPath : Files.newDirectoryStream(inputDirFiles, "*.js")) {
            System.out.println("-------------------------------");

            List<String> lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));
            String language = getLanguage(lines);
            System.out.println("language = " + language);

            String className = "MomentLanguage" + language.toUpperCase().replace("-", "_");
            Path outputFile = Paths.get(outputDir, className + ".java");
            System.out.println("input file = " + inputPath);
            System.out.println("output file = " + outputFile);

            Date writeDate = new Date();
            String formattedDate = writeDate.getDay() + "/" + writeDate.getMonth() + "/" + writeDate.getYear();

            String formattedClassPrefix = String.format(classPrefix, language, formattedDate, className);

            List<String> outputLines = new ArrayList<>();
            outputLines.addAll(Arrays.asList(formattedClassPrefix.split("\\n")));

            for (String line : lines) {
                if( line.matches(monthsInput) ){
                    outputLines.add(line.replaceAll(monthsInput, monthsOutput));
                }
            }

//            private static final String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
//            private static final String[] monthsShort = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
//            private static final String[] weekdays = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
//            private static final String[] weekdaysShort = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
//            private static final String[] weekdaysMin = new String[]{"Su","Mo","Tu","We","Th","Fr","Sa"};
//            private static final Map<String, String> longDateFormat = createLongDateFormat();
//            private static final Map<String, String> calendar = createCalendar();
//            private static final Map<String, String> relativeTime = createRelativeTime();
//            private static final Map<String, Integer> week = createWeek();


            outputLines.addAll(Arrays.asList(classSuffix.split("\\n")));

            Files.write(outputFile, outputLines, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING);
        }
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
            "public class %s {\n"; //extends MomentLanguage

    private static String classSuffix = "\n" +
//            "\n" +
//            "    @Override\n" +
//            "    String[] getMonths() {\n" +
//            "        return months;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    String[] getMonthsShort() {\n" +
//            "        return monthsShort;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    String[] getWeekdays() {\n" +
//            "        return weekdays;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    String[] getWeekdaysShort() {\n" +
//            "        return weekdaysShort;\n" +
//            "    }\n" +
//            "\n" +
//            "    @Override\n" +
//            "    String[] getWeekdaysMin() {\n" +
//            "        return weekdaysMin;\n" +
//            "    }\n" +
//            "\n" +
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
