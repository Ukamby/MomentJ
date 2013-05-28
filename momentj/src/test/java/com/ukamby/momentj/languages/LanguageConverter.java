package com.ukamby.momentj.languages;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

            String filteredLines = String.format(classPrefix, language, formattedDate, className);

            List<String> outputLines = new ArrayList<>();
            outputLines.addAll(Arrays.asList(filteredLines.split("\\n")));


            outputLines.add("}");

            Files.write(outputFile, outputLines, Charset.forName("UTF-8"));
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
            "public class %s extends MomentLanguage {\n";

}
