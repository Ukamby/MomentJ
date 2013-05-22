package com.ukamby.momentj;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * convert js tests to Java
 */
public class TestConvertor {

    public static void main(String[] args) throws Exception {
        new TestConvertor().convert();
    }

    public void convert() throws Exception {
        //System.out.println("----------------------------------------------------------------------------------------------------------------");
        String javaCode = prefix + "/*" + toJava() + "*/" + suffix;
        //System.out.println(javaCode);
        writeFile(javaCode);

    }

    private void writeFile(String javaCode) throws Exception {
        File outputFile = new File("momentj/src/test/java/com/ukamby/momentj/FormatTest.java");
        System.out.println("outputFile.getAbsolutePath() = " + outputFile.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(javaCode);
        fileWriter.close();
    }

    public String toJava() throws Exception {
        String jscode = getJavascriptCode();
        //System.out.println(jscode);

        // initial cleanup
        String javaCode = jscode;
        javaCode = javaCode.replaceAll(".*require.*\n","");
        javaCode = javaCode.replaceAll("^\n","");
        javaCode = javaCode.replaceAll("^.*\\{\n","");
        javaCode = javaCode.replaceAll("\n\\};$","");
        javaCode = javaCode.replaceAll("},(\n*\t*.*\".*\" : function\\(test\\))","}$1");

        // format methods
        Pattern pattern = Pattern.compile("\"(.*)\" : function\\(test\\) \\{");
        Matcher matcher = pattern.matcher(javaCode);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String functionName = matcher.group(1);
            // todo: camel case
            functionName = functionName.replaceAll(" ","");
            String rep = "@Test\n\tpublic void " + functionName + "() {";
            matcher.appendReplacement(sb,rep);
            //System.out.println(rep);
        }
        matcher.appendTail(sb);
        javaCode = sb.toString();

        // todo: convert " to \" inside '...' first
        //javaCode = javaCode.replaceAll("'(.*)\"(.*)\"(.*)'","'$1\\\\\"$2\\\\\"$3'");
        javaCode = javaCode.replaceAll("\"","\\\\\"");
        javaCode = javaCode.replaceAll("'","\"");

        // variable definitions
        //------------------------------
        // non-var cleanup
        for (int i=0; i<20; i++) { // as many non-var declarations as there are
            javaCode = javaCode.replaceAll("var (.*) = (.*),\n(\\s*)(\\s\\s\\s\\s)(.*) = (.*),\n","var $1 = $2;\n$3var $5 = $6,\n");
        }
        javaCode = javaCode.replaceAll("var (.*) = (.*),\n(\\s*)(\\s\\s\\s\\s)(.*) = (.*);\n","var $1 = $2;\n$3var $5 = $6;\n");
        // type (var -> String,Date,etc.)
        javaCode = javaCode.replaceAll("var (.*) = new Date\\((.*)\\.getTimezoneOffset\\(\\);","int $1 = new Date\\($2\\.getTimezoneOffset\\(\\);");
        javaCode = javaCode.replaceAll("var (.*) = moment\\((.*).format\\((.*)\\);","String $1 = moment\\($2.format\\($3\\);");
        javaCode = javaCode.replaceAll("var (.*) = \"","String $1 = \"");
        javaCode = javaCode.replaceAll("var (.*) = moment\\(","Moment $1 = moment\\(");
        javaCode = javaCode.replaceAll("var (.*) = new Date\\(","Date $1 = new Date\\(");
        javaCode = javaCode.replaceAll("var (.*) = (.*)<(.*);","boolean $1 = $2<$3;");
        javaCode = javaCode.replaceAll("var (.*) = /(.*)/;","Pattern $1 = Pattern.compile\\(\"$2\"\\);");

        // more javascript stuff
        javaCode = javaCode.replaceAll("===","==");

        return javaCode;
    }

    private String getJavascriptCode() throws IOException {
        File file = new File(this.getClass().getResource("/format.js").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    private static final String prefix = "package com.ukamby.momentj;\n\n" +
            "import org.junit.Test;\n" +
            "import java.util.regex.Pattern;\n" +
            "\n" +
            "import static com.ukamby.momentj.Moment.moment;\n\n"+
            "/**\n"+
            " * Format Tests\n"+
            " */\n"+
            "public class FormatTest extends JsTestBase {\n"+
            "\n";

    private static final String suffix = "}";

}
